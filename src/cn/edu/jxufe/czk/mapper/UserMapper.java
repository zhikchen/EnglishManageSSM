package cn.edu.jxufe.czk.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.edu.jxufe.czk.entity.User;

public interface UserMapper {

	List<User> selectAllUser();
	
	User selectUserById(String id);
	
	HashMap<String,Object> selectUserByIdMap(String id); 
	
	List<Map<String,Object>> selectAllUserMap();
	
	int insertMutiUser(@Param("users")List<User> list);
}
