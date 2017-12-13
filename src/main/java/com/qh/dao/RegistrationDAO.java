package com.qh.dao;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qh.domain.Registration;

@Repository
public class RegistrationDAO {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public int registration(int lyeay, String season){
		int x = 0;
		String sql = "select lid from league where lyear=? and season=?";
		Session session = hibernateTemplate.getSessionFactory().openSession();
		SQLQuery query = session.createSQLQuery(sql);
		query.setInteger(0, lyeay);
		query.setString(1, season);
		List<Integer> list = query.list();
		for (Integer league : list) {
			return league;
		}
		return x;
		
	}
	
	public void addreg(final Registration registration){
		/*hibernateTemplate.execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException {
				System.out.println(registration+"daoreg");
				session.save("Registration", registration);
				return null;
			}
			
		});*/
		hibernateTemplate.save(registration);
	}
}
