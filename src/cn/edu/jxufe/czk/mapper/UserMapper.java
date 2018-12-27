package cn.edu.jxufe.czk.mapper;

import java.util.List;

import cn.edu.jxufe.czk.entity.User;

public interface UserMapper {

	List<User> selectAllUser();
	
	User selectUserById(String id);
	
	
}
