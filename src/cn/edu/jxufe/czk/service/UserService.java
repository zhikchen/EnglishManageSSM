package cn.edu.jxufe.czk.service;

import java.util.List;

import cn.edu.jxufe.czk.entity.User;


public interface UserService {

	List<User> queryAllUser();
	
	User queryUserById(String id);
}
