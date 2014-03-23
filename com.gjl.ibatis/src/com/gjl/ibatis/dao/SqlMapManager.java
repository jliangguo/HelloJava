package com.gjl.ibatis.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapManager {
	private final Log log = LogFactory.getLog(SqlMapManager.class);

	private static SqlMapManager instance;

	private SqlMapManager() {
	}

	public static SqlMapManager getInstance() {
		if (null == instance) {
			instance = new SqlMapManager();
		}
		return instance;
	}

	public SqlMapClient getSqlMapClient() {
		Reader reader = null;
		SqlMapClient client = null;

		try {
			reader = Resources.getResourceAsReader("sqlmap/SqlMapConfig.xml");
			client = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			log.error("Read SqlMapConfig.xml ERROR.", e);
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					log.error(e, e);
				}
			}
		}
		return client;
	}
}
