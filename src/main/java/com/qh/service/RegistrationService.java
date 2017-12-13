package com.qh.service;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qh.dao.RegistrationDAO;
import com.qh.domain.Registration;
import com.qh.exeception.MyException;

@Service
public class RegistrationService {
	
	@Resource
	private RegistrationDAO registrationDAO;
	
	public int getReg(int lyear, String season){
		return registrationDAO.registration(lyear, season);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=MyException.class)
	public void addreg(Registration registration){
		registrationDAO.addreg(registration);
	}
	
}
