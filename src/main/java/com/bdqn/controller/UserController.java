package com.bdqn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdqn.entity.User;
import com.bdqn.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getAll")
	public Object getAll(){
		
		List<User> list = userService.selectAll();
		System.out.println(list.size());
		
		return list;
	}
	

}
