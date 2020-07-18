package com.mphasis.training.pl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mphasis.training.entities.Account;
import com.mphasis.training.util.HibernateUtil;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		
		Session session=sessionFactory.openSession();
		
		Account a1=(Account)session.get(Account.class, 456);
		
		//Account a12=(Account)session.get(Account.class, 456);
		
		session.close();
		
		Session session1=sessionFactory.openSession();
		Account a11=(Account)session1.get(Account.class, 456);
		
		session1.close();
	}

}
