package cn.edu.jxufe.czk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class loginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse, 
			Object object, 
			Exception exception)
			throws Exception {
		System.out.println("third视图绚烂完再调用的拦截器方法");
		System.out.println(object);
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, 
			Object object,
			ModelAndView modelAndView)
			throws Exception {
		//当有视图解析器的话这里可以调用视图解析器
		//modelAndView.setViewName("error");
		System.out.println("这里能重新解析一下视图吗？");
		System.out.println("--------这里能重新绚烂视图!----------");
		System.out.println("second调用拦截器");
	}

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse,
			Object object) throws Exception {
		System.out.println("first调用的拦截器方法");
		return true;
	}
}
