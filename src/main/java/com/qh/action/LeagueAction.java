package com.qh.action;
import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.qh.domain.League;
import com.qh.service.LeagueService;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("leagueAction")
@Results({
	@Result(name="success",location="/admin/addleaguesuccess.jsp"),
	@Result(name="input",location="/admin/addleague.jsp")
})
public class LeagueAction extends ActionSupport{
	@Resource
	private LeagueService leagueService;
	private int lyear;
	private String season;
	private String title;
	public LeagueAction() {
		super();
	}
	public LeagueAction(int lyear, String season, String title) {
		super();
		this.lyear = lyear;
		this.season = season;
		this.title = title;
	}
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String execute(){
		
		try {
			
			League league = new League(lyear, season, title);
			
			leagueService.addLeague(league);
			
			return "success";
		} catch (Exception e) {
			return "input";
		}
			
		
		
		
	}
	
	@Override
	public void validate(){
		if (lyear == 0) {
			addFieldError("year", getText("error.year.required"));
		}else if (lyear>=2030 || lyear <2000 ) {
			addFieldError("year", getText("error.year.posivive"));
		}
		if ("UNKNOWN".equals(season)) {
			addFieldError("season", getText("error.season.posivive"));
		}
		if (title == null || title.trim().length() == 0) {
			addFieldError("title", getText("error.title.required"));
		}
	}
	
}
