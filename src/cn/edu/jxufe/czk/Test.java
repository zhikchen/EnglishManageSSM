package cn.edu.jxufe.czk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.jxufe.czk.controller.UserController;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext 
					= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserController userController = (UserController)applicationContext.getBean("userController");
		userController.queryAllUser();
	}
}
