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
	 * ���������:
	 * 	propagation:����Ĵ�����Ϊ.
	 *     REQUIRED:ʹ�õ����ߵ�����
	 *     REQUIRES_NEW:�������ߵ��������,ʹ���Լ���������.
	 *  
	 *  isolation:����ĸ��뼶��,��õľ���READ_COMMITTED
	 *  readOnly:ָ�������Ƿ�Ϊֻ��. �����ֻ������,�����������ֻ��ȡ���ݿ������.���������޸Ĳ��� .
	 *  		 ��һ�����������ֻ��ȡ����,���б���Ҫ����readOnly=true,���԰������ݿ���������Ż�
	 *  
	 *  rollbackFor
	 *  rollbackForClassName
	 *  noRollbackFor
	 *  noRollbackForClassName	
	 *  
	 *  timeout:ָ��ǿ�ƻع�ǰ�������ռ�õ�ʱ�䡣 Ϊ�˱���һ������ռ�ù�����ʱ��.
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
