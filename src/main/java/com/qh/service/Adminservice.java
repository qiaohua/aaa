package com.qh.service;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qh.dao.AdminDAO;

@Service
public class Adminservice {
	
	@Resource
	private AdminDAO adminDAO;
	
	public int getAdmin(String username, String password){
		int x = adminDAO.getadmin(username, password);
		return x;
	}
}
