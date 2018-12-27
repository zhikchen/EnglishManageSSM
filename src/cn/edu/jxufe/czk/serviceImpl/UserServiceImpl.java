package cn.edu.jxufe.czk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.jxufe.czk.entity.User;
import cn.edu.jxufe.czk.mapper.UserMapper;
import cn.edu.jxufe.czk.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper ;
	
	@Override
	public List<User> queryAllUser() {
		return userMapper.selectAllUser();
	}

	@Override
	public User queryUserById(String id) {
		return userMapper.selectUserById(id);
	}

}
