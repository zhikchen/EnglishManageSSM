package cn.edu.jxufe.czk.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.jxufe.czk.entity.JsonResult;
import cn.edu.jxufe.czk.entity.User;
import cn.edu.jxufe.czk.service.UserService;

@Controller
public class UserController{

	@Autowired
	private UserService userServiceImpl ;
	
	@ResponseBody
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public JsonResult<List<User>> queryAllUser() {
		return new JsonResult(userServiceImpl.queryAllUser());
	}
	
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String queryUser(@PathVariable("id") String id,Map<String, Object> map) {
		User user = userServiceImpl.queryUserById(id);
		map.put("user", user);
		return "user";
	}
	
}
