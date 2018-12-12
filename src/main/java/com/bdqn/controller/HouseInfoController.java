package com.bdqn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bdqn.entity.HouseInfo;
import com.bdqn.entity.User;
import com.bdqn.service.HouseInfoService;
import com.bdqn.service.UserService;

/**
 * json处理所有的请求和响应信息
 * @author Administrator
 *
 */
@RestController
public class HouseInfoController {
	@Autowired
	private HouseInfoService houseInfoService;
	
	@RequestMapping("/getHouseInfo")
	public Object getAll(){
		List<HouseInfo> list = houseInfoService.selectAll();
		return list;
	}
	
	@RequestMapping("/getHouseInfoById")
	public Object getHouseById(Integer id){
		HouseInfo house = houseInfoService.selectById(id);
		return house;
	}
	
	@RequestMapping("/getHouseInfoFenye")
	public Object getFenye(Integer currentPage,Integer pageSize){
		List<HouseInfo> list = houseInfoService.selectFenye(currentPage, pageSize);
		//System.out.println(list.size());
		Map map = new HashMap<>();
		map.put("list", list);
		return map;
	}
	
	
	
	

}
