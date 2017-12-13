package com.qh.dao;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qh.domain.Player;

@Repository
public class PlayerDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	public void addPlayer(final Player player){
		hibernateTemplate.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				System.out.println(player);
				session.save("Player", player);
				
				return null;
			}
			
		});
		
		
	}
	
	public int getpid(Player player){
		System.out.println("player-dao"+player);
		String sql = "select pid from Player where Player.name=? and Player.address=? and Player.city=? and Player.email=?";
		Session session = hibernateTemplate.getSessionFactory().openSession();
		SQLQuery query = session.createSQLQuery(sql);
		query.setString(0, player.getName());
		query.setString(1, player.getAddress());
		query.setString(2, player.getCity());
		query.setString(3, player.getEmail());
		List<Integer> list = query.list();
		for (Integer pid : list) {
			//System.out.println(pid+"-----pid");
			return pid;
		}
		return 0;
	}
}
