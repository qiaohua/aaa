package com.qh.dao;
import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdminDAO {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public int getadmin(String username, String password){
		System.out.println(username+"---");
		System.out.println(password);
		String hql = "select * from admin where username=? and password=?";
		Session session = hibernateTemplate.getSessionFactory().openSession();
		SQLQuery query = session.createSQLQuery(hql);
		query.setString(0, username);
		query.setString(1, password);
		int x = query.list().size();
		/*System.out.println(x+"==========");
		boolean flag = query.list().isEmpty();
		System.out.println(flag+"dao");*/
		return x;
	}
}
