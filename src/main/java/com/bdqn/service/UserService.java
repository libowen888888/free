package com.bdqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bdqn.dao.UserDao;
import com.bdqn.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Cacheable(value="test",key="'selectAll'")
	public List<User> selectAll(){
		return userDao.selectAll();
	}
	
	

}
