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
import com.qh.service.Adminservice;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("adminAction")
@Results({
	@Result(name="success",location="/admin/addleague.jsp"),
	@Result(name="input", location="/admin/login.jsp")
})
public class AdminAction extends ActionSupport{
	
	@Resource
	private Adminservice adminservice;
	private String username;
	private String password;
	
	public AdminAction() {
		super();
	}
	public AdminAction(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	//@RequiredStringValidator(key = "error.username.required", trim = true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	//@RequiredStringValidator(key = "error.password.required", trim = true)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String execute(){
		
		int x = adminservice.getAdmin(username, password);
		if (x == 0) {
			return "input";
		}
		HttpSession session= ServletActionContext.getRequest().getSession();
		session.setAttribute("username", username);
		return "success";
	}
	
	@Override
	public void validate(){
		if (username == null || username.trim().length() == 0) {
			addFieldError("username", getText("error.username.required"));
		}
		if (password == null || password.trim().length() == 0) {
			addFieldError("password", getText("error.password.required"));
		}
	}
}
