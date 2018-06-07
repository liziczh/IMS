package com.liziczh.ims.tools;


import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtils {

	private static BasicDataSource dataSource = new BasicDataSource();
	static {
		InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			dataSource.setDriverClassName(properties.getProperty("driverClassName"));
			dataSource.setUrl(properties.getProperty("url"));
			dataSource.setUsername(properties.getProperty("username"));
			dataSource.setPassword(properties.getProperty("password"));

			dataSource.setMaxActive(Integer.parseInt(properties.getProperty("maxIdle")));
			dataSource.setMaxWait(Long.parseLong(properties.getProperty("maxWait")));
			dataSource.setMaxActive(Integer.parseInt(properties.getProperty("maxActive")));
			dataSource.setInitialSize(Integer.parseInt(properties.getProperty("initialSize")));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static DataSource getDataSource() {
		return dataSource;
	}


	// 分页语句
	public static String PagenationSql(String sql, int currentPage, int pageSize){
		String pageSql = "select * from ( select \"temp\".*, ROWNUM \"rn\" from ("
				+ sql + ") \"temp\" where ROWNUM <= " + currentPage + " * " + pageSize + " ) where \"rn\" > ("+ currentPage + " - 1) * "+ pageSize;
		return pageSql;
	}
}

