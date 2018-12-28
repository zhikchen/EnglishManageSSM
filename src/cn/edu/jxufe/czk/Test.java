package cn.edu.jxufe.czk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.jxufe.czk.mapper.UserMapper;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext 
					= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper bean = (UserMapper)applicationContext.getBean("userMapper");
		HashMap<String, Object> map = bean.selectUserByIdMap("1");
		System.out.println(map);
		List<Map<String, Object>> list = bean.selectAllUserMap();
		System.out.println(list);
	}
}
