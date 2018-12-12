package com.bdqn.dao;

import java.util.List;
import java.util.Map;

import com.bdqn.entity.HouseInfo;
import com.bdqn.entity.User;

public interface HouseInfoDao {
	// 方法名必须和mapper中的id一致； 返回值类型必须是mapper中的resultType的类型或泛型
	List<HouseInfo> selectAll();
	
	List<HouseInfo> selectFenye(Map map);
	
	HouseInfo selectById(Integer id);
	
	
	
}
