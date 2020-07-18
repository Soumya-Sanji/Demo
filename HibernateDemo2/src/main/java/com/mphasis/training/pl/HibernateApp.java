package com.mphasis.training.pl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mphasis.training.entities.Account;
import com.mphasis.training.entities.CurrentAccount;
import com.mphasis.training.entities.Laptop;
import com.mphasis.training.entities.Orders;
import com.mphasis.training.entities.Person;
import com.mphasis.training.entities.Product;
import com.mphasis.training.entities.SavingsAccount;
import com.mphasis.training.entities.Student;
import com.mphasis.training.util.HibernateUtil;

public class HibernateApp {

	public static void main(String[] args) {
//		Configuration con=new Configuration().configure().addAnnotatedClass(Account.class)
//				.addAnnotatedClass(SavingsAccount.class).addAnnotatedClass(CurrentAccount.class);
//		StandardServiceRegistryBuilder builder=
//				new StandardServiceRegistryBuilder().applySettings(con.getProperties());
//		SessionFactory sessionFactory=con.buildSessionFactory(builder.build());
//		
//		Student st=new Student();
//		//st.setSt_id(1);
//		st.setName("soumya");
//		st.getEmail().add("soumya@gmail.com");
//		st.getEmail().add("sanji@gmail.com");
//		st.getLp().setLpcode("LP123");
//		st.getLp().setBrand("HP");
//		st.getLp().setHddsize(1);
//		st.getLp().setRamsize(8);
//		st.getLp().setProcessor("quadcore");
//		
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(st);
//		session.getTransaction().commit();

		
		//SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		
//		Account a=new Account();
//		a.setAcc_holder_name("Soumya");
//		a.setAccnum(123);
//		a.setBalance(7894560);
//		
//		SavingsAccount sa=new SavingsAccount();
//		sa.setAcc_holder_name("Sanji");
//		sa.setAdharnum(4561);
//		sa.setAccnum(456);
//		sa.setBalance(7894561);
//		
//		CurrentAccount ca=new CurrentAccount();
//		ca.setAcc_holder_name("Raghav");
//		ca.setAccnum(444);
//		ca.setGstin("123456");
//		ca.setBalance(45698700);
//		
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(a);
//		session.save(sa);
//		session.save(ca);
//		session.getTransaction().commit();
//		session.close();
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		
		//criteria
		Session session=sessionFactory.openSession();
		List<Account> accounts=session.createCriteria(Account.class).list();
		for(Account a:accounts) {
			System.out.println(a.getAcc_holder_name()+" "+a.getAccnum()+" "+a.getBalance());
		}
		session.close();
		
		//HQL FROM Employee
		Session session1=sessionFactory.openSession();
		Query query=session1.createQuery("FROM Account");
		query.list().forEach(System.out::println);
		
		//HQL
		Query query1=session1.createQuery("SELECT a.accnum FROM Account a");
		query1.list().forEach(System.out::println);
		
		session1.beginTransaction();
		Query qd=session1.createQuery("DELETE FROM Account where accnum=:acc");
		qd.setParameter("acc", 456);
		qd.executeUpdate();
		session1.getTransaction().commit();
		System.out.println("deleted");
		
		session1.close();
		
		//sql select * from employee
		Session session2=sessionFactory.openSession();
		SQLQuery sqlquery=session2.createSQLQuery("select acc_holder_name,accnum from account");
		List<Object[]> objects=sqlquery.list();
		for(Object[] row:objects) {
			Account a=new Account();
			a.setAcc_holder_name(row[0].toString());
			a.setAccnum(Integer.parseInt(row[1].toString()));
			System.out.println(a.getAcc_holder_name()+" "+a.getAccnum());
		}	
		session2.close();
	}

}
