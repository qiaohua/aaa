package com.qh.dao;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qh.domain.League;

@Repository
public class ListDAO {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<League> getList(){
		return hibernateTemplate.execute(new HibernateCallback<List<League>>() {

			@SuppressWarnings("unchecked")
			public List<League> doInHibernate(Session session) throws HibernateException {
				//String sql = "select * from League";
				String sql = "from League";
				Query query = session.createQuery(sql);
				System.out.println(1246578);
				List<League> list = query.list();
				System.out.println(list+"---------");
				/*for (League league : list) {
					System.out.println(league);
				}*/
				return list;
			}
			
		});
		
	}
}
