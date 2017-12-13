package com.qh.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qh.dao.ListDAO;
import com.qh.domain.League;

@Service
public class ListService {
	@Resource
	private ListDAO listDAO;
	
	public List<League> getList(){
		return listDAO.getList();
	}
}
