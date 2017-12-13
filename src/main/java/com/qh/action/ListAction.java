package com.qh.action;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.qh.domain.League;
import com.qh.service.ListService;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("listAction")
@Results({
	@Result(name="success",location="/listleague.jsp"),
	@Result(name="input",location="/admin/addleague.jsp")
})
public class ListAction  extends ActionSupport{
	@Resource
	private ListService listService;
	private List<League> list;
	public List<League> getList() {
		return list;
	}
	public void setList(List<League> list) {
		this.list = list;
	}
	
	
	@Override
	public String execute(){
		list = listService.getList();
		/*for (League league : list) {
			
		}*/
		return "success";
	}
	

	
}
