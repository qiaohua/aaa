package com.qh.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rid;
	private int lid;
	private int pid;
	private String division;
	
	public Registration() {
		super();
	}
	public Registration(int pid, String division, int lid) {
		super();
		this.pid = pid;
		this.division = division;
		this.lid = lid;
	}
	public Registration(int lid, int pid, String division, int rid) {
		super();
		this.lid = lid;
		this.pid = pid;
		this.division = division;
		this.rid = rid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "Registration [lid=" + lid + ", pid=" + pid + ", division=" + division + ", rid=" + rid + "]";
	}
	
	
}
