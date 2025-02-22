package com.Entity;


import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
//@Table(name="Emp")
public class Employee {

	@Id
	private int eid;
//	@Column(name="EmpName")
	private  EmpName ename;
	private String edept;
	//@Transient
	private int age;

	private double salary;
	@Temporal(value=TemporalType.DATE)
	private LocalDate login;
	
	
	public EmpName getEname() {
		return ename;
	}
	public void setEname(EmpName ename) {
		this.ename = ename;
	}
	
	public LocalDate getLogin() {
		return login;
	}
	public void setLogin(LocalDate localDate) {
		this.login = localDate;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
//	public String getEname() {
//		return ename;
//	}
//	public void setEname(String ename) {
//		this.ename = ename;
//	}
	
	public String getEdept() {
		return edept;
	}
	public void setEdept(String edept) {
		this.edept = edept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", edept=" + edept + ", age=" + age + ", salary=" + salary
				+ ", login=" + login + "]";
	}

	
}
