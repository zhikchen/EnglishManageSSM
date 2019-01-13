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
		System.out.println("third��ͼѤ�����ٵ��õ�����������");
		System.out.println(object);
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, 
			Object object,
			ModelAndView modelAndView)
			throws Exception {
		//������ͼ�������Ļ�������Ե�����ͼ������
		//modelAndView.setViewName("error");
		System.out.println("���������½���һ����ͼ��");
		System.out.println("--------����������Ѥ����ͼ!----------");
		System.out.println("second����������");
	}

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse,
			Object object) throws Exception {
		System.out.println("first���õ�����������");
		return true;
	}
}
