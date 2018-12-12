package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.User;

public interface UserDao {
	// 方法名必须和mapper中的id一致； 返回值类型必须是mapper中的resultType的类型或泛型
	List<User> selectAll();
	
}
