package com.qh.action;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.qh.dao.PlayerDAO;
import com.qh.domain.Player;
import com.qh.domain.Registration;
import com.qh.service.PlayerService;
import com.qh.service.RegistrationService;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("select")
@Results({
	@Result(name="success",location="/registration/registrationsuccess.jsp"),
	@Result(name="input",location="/registration/SelectDivision.jsp")
})
public class RegistrationAction extends ActionSupport{
	
	@Resource
	private RegistrationService registrationService;
	@Resource
	private PlayerService playerService;
	@Resource
	private PlayerDAO playerDAO;
	
	private Player player;
	
	public Player getPlayer() {
		System.out.println(player);
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	

	private int lyear;
	private String season;
	private String division;
	
	
	public int getLyear() {
		return lyear;
	}
	public void setLyear(int lyear) {
		this.lyear = lyear;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	@Override
	public void validate(){
		if (lyear == 0) {
			addFieldError("年份", getText("error.year.required"));
		}else if (lyear>=2030 || lyear <2000 ) {
			addFieldError("年份", getText("error.year.posivive"));
		}
		if ("UNKNOWN".equals(season)) {
			addFieldError("季节", getText("error.season.posivive"));
		}
		if ("UNKNOWN".equals(division)) {
			addFieldError("分组", getText("error.division.posivive"));
		}
	}
	
	@Override
	public String execute(){
		int x = 0 ;
		x = registrationService.getReg(lyear, season);
		if (x != 0) {
			HttpSession session= ServletActionContext.getRequest().getSession();
			Player player = (Player)session.getAttribute("Player");
			playerService.addPlayer(player);
			
			int pid = playerService.getpid(player);
			
			Registration registration = new Registration(x, division, pid);
			registrationService.addreg(registration);
			return "success";
		}
		System.out.println(678);
		addFieldError("查询结果", "查询错误");
		return "success";
	}
}
