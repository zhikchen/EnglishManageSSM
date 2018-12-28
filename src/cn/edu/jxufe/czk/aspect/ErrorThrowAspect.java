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
	
	//���ִ�з����������׳���������
	@Around(value = "errorThrowAspectPointcut()")
	public Object catchException(ProceedingJoinPoint pJoinPoint) throws Exception {
		Object result = null;
		try {
			result = pJoinPoint.proceed();
		} catch (Throwable e) {
			logger.info("error={}",e);
			String methodName = pJoinPoint.getSignature().getName().toLowerCase();  //��ȡ��������תСд
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
	
	
	//��Է���ֵ�������жϣ������ѯ���Ϊnull��������ӽ��Ϊfalse����Ӧ���׳��쳣
	@AfterReturning(value="errorThrowAspectPointcut()", returning="object")
	public void returnCheck(JoinPoint joinpoint,Object object) {
		String methodName = joinpoint.getSignature().getName().toLowerCase();
		if(object!=null){ 
			if(object instanceof Boolean) {
			    boolean retValue = ((Boolean) object).booleanValue();
			    if(!retValue){   //�������ֵ������boolean������ֵΪfalse������������������¡�˵������ʧ��
			    	if(methodName.indexOf("add")!=-1||methodName.indexOf("insert")!=-1){
						throw new SBMException(ErrorEnum.ADD_FAIL);
					}else if(methodName.indexOf("remove")!=-1||methodName.indexOf("delete")!=-1){
						throw new SBMException(ErrorEnum.DELETE_FAIL);
					}else if(methodName.indexOf("modify")!=-1||methodName.indexOf("update")!=-1){
						throw new SBMException(ErrorEnum.EDIT_FAIL);
					}
			    }
			}
		}else{ //����ֵΪnull�����ҷ���������find��query˵��û�鵽���ݡ��Լ���û��Ӱ�죬ר����У�鷵�ص�������
			if(methodName.indexOf("find")!=-1||methodName.indexOf("query")!=-1){
				throw new SBMException(ErrorEnum.FIND_NULL);
			}
		}
	}
	
}
