package cn.edu.jxufe.czk.exception.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.jxufe.czk.exception.SBMException;

/**
 * ����ȫ�ֵ��쳣������   ��ÿ��handler�е��쳣���ܽ��д���.
 * 
 * ��Handler�����׳��쳣�������ڱ����в����Ƿ����쳣�����������û�У�
 * �򵽱�ע��@ControllerAdvice�����в����쳣��������.
 *
 */
@ControllerAdvice
public class ControllerExpectionHandle {
	
	private final static Logger logger = LoggerFactory.getLogger(ControllerExpectionHandle.class);
	
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handle(Exception ex){
		logger.error("��ϵͳ�쳣��:", ex);
		//ȥ��������ҳ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("exMsg",ex.getMessage());
		return mav ;
	}
	
	@ExceptionHandler({SBMException.class})
	public ModelAndView handleRuntimeException(SBMException ex ){
		logger.error("�������쳣��{}", ex.getMessage());
		//ȥ��������ҳ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("exMsg",ex.getMessage());
		mav.addObject("code",ex.getCode());
		return mav ;
	}
	
}
