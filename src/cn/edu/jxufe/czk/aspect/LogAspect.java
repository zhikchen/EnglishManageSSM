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

	//����ʹ��slf4j����Ҳ��spring���õ���־���ߡ��÷���log4j���
	private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	@Pointcut("execution(* cn.edu.jxufe.czk.controller.*.*(..))")
	public void log() {}
	
	@Before(value = "log()")
	public void logbefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		logger.info("url={}",request.getRequestURI());  //�����и�С���ɣ�������
		//method
		logger.info("method={}",request.getMethod());
		//ip
		logger.info("ip={}",request.getRemoteAddr());
		//�෽��
		logger.info("class_method={}",
				joinPoint.getSignature().getDeclaringTypeName()
				+"."+joinPoint.getSignature().getName()); //����.����
		//����
		logger.info("args={}",joinPoint.getArgs());
	}
	
	//��¼�û�������־�����ز�����־
	@AfterReturning(pointcut="log()",returning="object")
	public void logAfterRet(Object object){
		logger.info("response={}",object);
	}
	
	
}
