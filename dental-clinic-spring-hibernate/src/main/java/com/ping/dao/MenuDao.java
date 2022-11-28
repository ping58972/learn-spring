package com.ping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ping.entity.Menu;

@Repository
public class MenuDao {

	
		@Autowired
		private SessionFactory sessionFactory;

		public Menu findById(Integer id) {
			Session session = null;
			
			try{
				session = sessionFactory.openSession();
				
				Menu menu = (Menu) session.get(Menu.class, id);
				
				
				return menu;
				
			}catch(Exception e){
				e.printStackTrace();
				
				return null;
				
			}finally {
				session.close();
			}
	}

}
