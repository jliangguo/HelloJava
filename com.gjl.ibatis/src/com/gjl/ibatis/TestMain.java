package com.gjl.ibatis;

import com.gjl.ibatis.dao.EmployeeDao;
import com.gjl.ibatis.model.Employee;

public class TestMain {

	public static void main(String[] args) {
		EmployeeDao ed = new EmployeeDao();
		int id = 201;
		Employee em = ed.selectEmployeeInfoById(id);
		print(em);
	}

	private static void print(Employee em) {
		if (null != em) {
			System.out.println(em.toString());
			System.out.println();
		}
	}

}
