package com.bdqn.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdqn.entity.User;
import com.bdqn.service.HouseInfoService;
import com.bdqn.service.UserService;

@Controller
public class DownloadController {
	@Autowired
	private HouseInfoService houseInfoService;
	
	@RequestMapping("/down")
	public void getAll(String name,HttpServletRequest req,HttpServletResponse resp){
		
		File file = new File(req.getRealPath("image"),name);
		resp.setHeader("content-type", "application/octet-stream");
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "filename=" + name);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = resp.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(file));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		
	}
	

}
