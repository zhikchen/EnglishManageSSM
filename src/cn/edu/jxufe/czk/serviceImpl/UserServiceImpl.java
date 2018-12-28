package cn.edu.jxufe.czk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jxufe.czk.entity.User;
import cn.edu.jxufe.czk.mapper.UserMapper;
import cn.edu.jxufe.czk.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper ;
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
					propagation=Propagation.REQUIRED,
					readOnly=true,
					timeout=3)
	public List<User> queryAllUser() {
		return userMapper.selectAllUser();
	}
	
	/**
	 * 事务的属性:
	 * 	propagation:事务的传播行为.
	 *     REQUIRED:使用调用者的事务
	 *     REQUIRES_NEW:将调用者的事务挂起,使用自己的新事务.
	 *  
	 *  isolation:事务的隔离级别,最常用的就是READ_COMMITTED
	 *  readOnly:指定事务是否为只读. 如果是只读事务,代表这个事务只读取数据库的数据.而不进行修改操作 .
	 *  		 若一个事务真的是只读取数据,就有必须要设置readOnly=true,可以帮助数据库引擎进行优化
	 *  
	 *  rollbackFor
	 *  rollbackForClassName
	 *  noRollbackFor
	 *  noRollbackForClassName	
	 *  
	 *  timeout:指定强制回滚前事务可以占用的时间。 为了避免一个事务占用过长的时间.
	 * 
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED,
					propagation=Propagation.REQUIRED,
					readOnly=true,
					timeout=3)
	public User queryUserById(String id) {
		int a = 1/Integer.parseInt(id);
		return userMapper.selectUserById(id);
	}

}
