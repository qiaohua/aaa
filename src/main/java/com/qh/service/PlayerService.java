package com.qh.service;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qh.dao.PlayerDAO;
import com.qh.domain.Player;
import com.qh.exeception.MyException;

@Service
public class PlayerService {
	@Resource
	private PlayerDAO playerDAO;
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=MyException.class)
	public void addPlayer(Player player){
		playerDAO.addPlayer(player);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,rollbackFor=MyException.class)
	public int getpid(Player player){
		System.out.println("playerservice"+player);
		return playerDAO.getpid(player);
	}
}
