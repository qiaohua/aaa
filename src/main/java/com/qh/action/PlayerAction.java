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

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("playerAction")
@Results({
	@Result(name="success",location="/registration/SelectDivision.jsp"),
	@Result(name="input", location="/registration/enterplayer.jsp")
})
	

public class PlayerAction extends ActionSupport{
	
	@Resource
	private PlayerDAO playerDAO;
	
	
	
	private String page;
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	

	private String name;
	private String address;
	private String city;
	private String email; 
	
	public PlayerAction() {
		super();
	}
	public PlayerAction(String name, String address, String city, String email) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	
	
	
	
	@Override
	public String execute(){
		try {
			Player player = new Player(name, address, city, email);
		HttpSession session= ServletActionContext.getRequest().getSession();
		session.setAttribute("Player", player);
		return "success";
		} catch (Exception e) {
			return "input";
		}
			
		//return null;
		
		
	}
	@Override
	public void validate(){
		if (name == null || name.trim().length() == 0) {
			addFieldError("name", getText("error.name.required"));
		}
		if (address == null || address.trim().length() == 0) {
			addFieldError("address", getText("error.address.required"));
		}
		if (city == null || city.trim().length() == 0) {
			addFieldError("city", getText("error.city.required"));
		}
		if (email == null || email.trim().length() == 0) {
			addFieldError("email", getText("error.email.required"));
		}
	}
	
	 
	
}
