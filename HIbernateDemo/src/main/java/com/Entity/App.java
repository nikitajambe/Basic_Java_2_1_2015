package com.Entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Query;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello hibernate....!!!");

//		Employee e1 = new Employee();
//		e1.setEid(7);
//		EmpName n1 = new EmpName();
//		n1.setFname("Tanuja");
//		n1.setMname("Motiram");
//		n1.setLname("Jambe");
//		
//		e1.setEdept("ML");
//		e1.setAge(11);
//		e1.setSalary(93000.00);
//		e1.setLogin(LocalDate.now());

		Configuration con = new Configuration();
		SessionFactory sf = con.configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

//		**** create method -save is the create and insert method *****
//		session.save(e1);
		tx.commit();

////		**** update method ****
//		Transaction tx1 = session.beginTransaction();
//		Employee g1 = session.get(Employee.class, 1);
//		g1.setEmpName("Sangram");
//		session.update(g1);
//		tx1.commit();
		
		

//		***** delete method ****
//		Transaction tx3= session.beginTransaction();
//
//		Employee d1 = session.get(Employee.class, 6);
//		session.delete(d1);
//
//		tx3.commit();
//		
//		**** read or fetching data *****

//		Transaction tx4 = session.beginTransaction();
//		Employee r1 = session.get(Employee.class, args);
//		 r1 = session.get(Employee.class, 1);
//		 r1.toString();
//		System.out.println(r1);

//		List<Employee> employee = session.createQuery("from Employee").getResultList();
//
//		for (Employee emp : employee) {
//			System.out.println(emp.getEid() + " - " + emp.getEmpName() + " - " + emp.getEdept() + " - " + emp.getAge()
//					+ " - " + emp.getSalary());
//		}

//		tx4.commit();

//		postgrace
		
		
//		*************  HQL *************
		
//		Hql :database independent language
		
//		System.out.println("select query: ");
		String hqlString ="from employee";
//		List<Employee> objects = session.createQuery(hqlString,Employee.class).list();
//		objects.forEach(obj->{
//			obj.toString();
//			System.out.println(obj);
//		});
		
////		******  where ******
//		System.out.println("where query");
//		hqlString = "from employee E where E.salary >: MinSalary";
//		org.hibernate.query.Query <Employee> query = session.createQuery(hqlString,Employee.class).setParameter("MinSalary", 20000);
//		List<Employee> object1 = query.list();
//		object1.forEach(obj1 -> {
//			obj1.toString();
//			System.out.println(obj1);
//		});
		
		
//		****** order by ******
		
//		System.out.println("order by Query :");
//		hqlString ="from Employee orde by DESC";
//		List<Employee> object2 = query.list();
//		object2.forEach(obj2 -> {
//			obj2.toString();
//			System.out.println(obj2);
//		});
		
		
		
//		******** Aggregate function ********
		
		hqlString ="select AVG(salary) from Employee";
		Double avgsal = session.createQuery(hqlString,Double.class).uniqueResult();
		System.out.println("average salary = " +avgsal);
	}
}
