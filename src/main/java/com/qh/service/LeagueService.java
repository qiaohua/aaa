package com.qh.service;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qh.dao.LeagueDAO;
import com.qh.domain.League;
import com.qh.exeception.MyException;

@Service
public class LeagueService {
	@Resource
	private LeagueDAO leagueDAO;
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=MyException.class)
	public void addLeague(League league){
		leagueDAO.addLeague(league);
	}
}
