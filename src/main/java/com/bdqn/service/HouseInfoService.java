package com.bdqn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bdqn.dao.HouseInfoDao;
import com.bdqn.dao.UserDao;
import com.bdqn.entity.HouseInfo;
import com.bdqn.entity.User;

@Service
public class HouseInfoService {
	@Autowired
	private HouseInfoDao houseInfoDao;
	
	
	public List<HouseInfo> selectAll(){
		return houseInfoDao.selectAll();
	}
	
	@Cacheable(value="freeroom",key="'selectById'")
	public HouseInfo selectById(Integer id){
		return houseInfoDao.selectById(id);
	}
	
	
	@Cacheable(value="freeroom",key="'selectFenye'")
	public List<HouseInfo> selectFenye(int currentPage,int pageSize){
		Map map = new HashMap<>();
		map.put("startIndex", (currentPage-1)*pageSize);
		map.put("pageSize", pageSize);
		return houseInfoDao.selectFenye(map);
	}
	

}
