package cn.edu.jxufe.czk.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
@Aspect
public class LogAspect {

	//这里使用slf4j，这也是spring内置的日志工具。用法和log4j差不多
	private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	@Pointcut("execution(* cn.edu.jxufe.czk.controller.*.*(..))")
	public void log() {}
	
	@Before(value = "log()")
	public void logbefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		logger.info("url={}",request.getRequestURI());  //这里有个小技巧：花括号
		//method
		logger.info("method={}",request.getMethod());
		//ip
		logger.info("ip={}",request.getRemoteAddr());
		//类方法
		logger.info("class_method={}",
				joinPoint.getSignature().getDeclaringTypeName()
				+"."+joinPoint.getSignature().getName()); //类名.方法
		//参数
		logger.info("args={}",joinPoint.getArgs());
	}
	
	//记录用户操作日志：返回参数日志
	@AfterReturning(pointcut="log()",returning="object")
	public void logAfterRet(Object object){
		logger.info("response={}",object);
	}
	
	
}
