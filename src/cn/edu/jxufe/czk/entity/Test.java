package cn.edu.jxufe.czk.entity;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.jxufe.czk.service.UserService;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//for(int j=500;j<502;j++) {
		UserService bean = (UserService)context.getBean("userServiceImpl");
		
	
			ArrayList<User> list = new ArrayList<User>();
			for(int i=14500;i<15500;i++) {
				list.add(new User(-1,"c"+i+"k","123",(char)new Random().nextInt(2),i+"zk",i+"23@qq.com"));
			}
			bean.insertMutiUsers(list);
		
		//}
	}
}
