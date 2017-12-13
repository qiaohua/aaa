package com.qh.dao;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qh.domain.League;

@Repository
public class LeagueDAO {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	public void addLeague(final League league){
		
		hibernateTemplate.execute(new HibernateCallback<Object>(){

			public Object doInHibernate(Session session) throws HibernateException {
				//session.setFlushMode(FlushMode.AUTO);
				session.save(league);
				return null;
			}
			
		});
	}
	
}
