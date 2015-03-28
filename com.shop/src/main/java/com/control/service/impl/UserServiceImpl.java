package com.control.service.impl;
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.control.dao.UserDao;
import com.control.model.Users;
import com.control.service.UserService;

public class UserServiceImpl implements UserService {  

	@Autowired  
	UserDao userdao;  

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insertData(Users user) {  
		userdao.insertData(user);  
	}  

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Users> getUserList() {  
		return userdao.getUserList();  
	}  

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteData(Integer id) {  
		userdao.deleteData(id);  

	}  

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Users getUser(Integer id) {  
		return userdao.getUser(id);  
	}  

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateData(Users user) {  
		userdao.updateData(user);  

	}  
}  