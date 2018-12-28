package cn.edu.jxufe.czk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.edu.jxufe.czk.enums.ErrorEnum;
import cn.edu.jxufe.czk.exception.SBMException;


@Component
@Aspect
public class ErrorThrowAspect {

	private final static Logger logger = LoggerFactory.getLogger(ErrorThrowAspect.class);
	
	@Pointcut("execution(* cn.edu.jxufe.czk.serviceImpl.*.*(..))")
	public void errorThrowAspectPointcut() {}
	
	//针对执行方法过程中抛出错误的情况
	@Around(value = "errorThrowAspectPointcut()")
	public Object catchException(ProceedingJoinPoint pJoinPoint) throws Exception {
		Object result = null;
		try {
			result = pJoinPoint.proceed();
		} catch (Throwable e) {
			logger.info("error={}",e);
			String methodName = pJoinPoint.getSignature().getName().toLowerCase();  //获取方法名并转小写
			if(methodName.indexOf("add")!=-1||methodName.indexOf("insert")!=-1){
				throw new SBMException(ErrorEnum.ADD_FAIL);
			}else if(methodName.indexOf("remove")!=-1||methodName.indexOf("delete")!=-1){
				throw new SBMException(ErrorEnum.DELETE_FAIL);
			}else if(methodName.indexOf("modify")!=-1||methodName.indexOf("update")!=-1){
				throw new SBMException(ErrorEnum.EDIT_FAIL);
			}else if(methodName.indexOf("find")!=-1||methodName.indexOf("query")!=-1){
				throw new SBMException(ErrorEnum.FIND_ERROR);
			}else{
				throw new Exception(e);
			}
		}
		return result;
	}
	
	
	//针对返回值内容做判断：比如查询结果为null，或者添加结果为false，皆应该抛出异常
	@AfterReturning(value="errorThrowAspectPointcut()", returning="object")
	public void returnCheck(JoinPoint joinpoint,Object object) {
		String methodName = joinpoint.getSignature().getName().toLowerCase();
		if(object!=null){ 
			if(object instanceof Boolean) {
			    boolean retValue = ((Boolean) object).booleanValue();
			    if(!retValue){   //如果返回值类型是boolean，并且值为false，在来就是如下情况下。说明操作失败
			    	if(methodName.indexOf("add")!=-1||methodName.indexOf("insert")!=-1){
						throw new SBMException(ErrorEnum.ADD_FAIL);
					}else if(methodName.indexOf("remove")!=-1||methodName.indexOf("delete")!=-1){
						throw new SBMException(ErrorEnum.DELETE_FAIL);
					}else if(methodName.indexOf("modify")!=-1||methodName.indexOf("update")!=-1){
						throw new SBMException(ErrorEnum.EDIT_FAIL);
					}
			    }
			}
		}else{ //返回值为null，并且方法名包含find或query说明没查到数据。对集合没有影响，专用于校验返回单个对象
			if(methodName.indexOf("find")!=-1||methodName.indexOf("query")!=-1){
				throw new SBMException(ErrorEnum.FIND_NULL);
			}
		}
	}
	
}
