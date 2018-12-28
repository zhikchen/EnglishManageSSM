package cn.edu.jxufe.czk.exception.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.jxufe.czk.exception.SBMException;

/**
 * 定义全局的异常处理类   对每个handler中的异常都能进行处理.
 * 
 * 当Handler类中抛出异常后，优先在本类中查找是否有异常处理方法，如果没有，
 * 则到标注了@ControllerAdvice的类中查找异常出来方法.
 *
 */
@ControllerAdvice
public class ControllerExpectionHandle {
	
	private final static Logger logger = LoggerFactory.getLogger(ControllerExpectionHandle.class);
	
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handle(Exception ex){
		logger.error("【系统异常】:", ex);
		//去往错误处理页面
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("exMsg",ex.getMessage());
		return mav ;
	}
	
	@ExceptionHandler({SBMException.class})
	public ModelAndView handleRuntimeException(SBMException ex ){
		logger.error("【操作异常】{}", ex.getMessage());
		//去往错误处理页面
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("exMsg",ex.getMessage());
		mav.addObject("code",ex.getCode());
		return mav ;
	}
	
}
