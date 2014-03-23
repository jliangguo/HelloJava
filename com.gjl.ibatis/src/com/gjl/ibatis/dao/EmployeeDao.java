package com.gjl.ibatis.dao;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gjl.ibatis.model.Employee;
import com.ibatis.sqlmap.client.SqlMapClient;

public class EmployeeDao {
	private final Log log = LogFactory.getLog(EmployeeDao.class);
	private final SqlMapClient client;

	public EmployeeDao() {
		client = SqlMapManager.getInstance().getSqlMapClient();
	}

	public Employee selectEmployeeInfoById(int id) {
		try {
			return (Employee) client.queryForObject(
					"EmployeeSql.selectEmployeeInfoById", id);
		} catch (SQLException e) {
			log.error("selectEmployeeInfoById ERROR.", e);
			return new Employee();
		}
	}

}
