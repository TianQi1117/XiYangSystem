package com.ttq.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JDBCUtil {
	//实例化数据库连接吃 DBCP
	private static DataSource dataSource;

	//读取文件
	static { //apache  tomcat  mybatis 
		Properties properties = new Properties(); // map集合
		//获得src 根目录下面的文件,读取成流
		InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			properties.load(inputStream);//将文件读取成map集合
			//根据map集合的配置实例化数据库连接池
			dataSource = new BasicDataSourceFactory().createDataSource(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//获得数据库连接池
	public static DataSource getDataSource() {
		return dataSource;
	}

	// 1.加载驱动,获得连接
	public static Connection getConnection() {
		try {
			return dataSource.getConnection(); //数据库连接池里获取的
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//	private static String driver = "";
	//	private static String url = "";
	//	private static String username = "";
	//	private static String password = "";
	//	static {
	//
	//		//读取配置文件，获得配置文件里面的驱动，URL，用户名和密码
	//		//读文件：io流
	//		try {
	//			BufferedReader reader = new BufferedReader(new FileReader("src/com/ttq/util/db.properties"));
	//			//key value map 多线程 安全的 Hashtable（安全）-> 子类Properties HashMap（不安全）
	//			Properties properties = new Properties();//Hashtable子类
	//			properties.load(reader);//加载***properties的文件，内容读取成->变成map集合
	//			//文件=左边是map的key，右边是map的value
	//			//根据key获得value值
	//			driver = properties.getProperty("driver");
	//			url = properties.getProperty("url");
	//			username = properties.getProperty("username");
	//			password = properties.getProperty("password");
	//
	//		} catch (FileNotFoundException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//
	//	}

	//加载驱动,获得连接
	//	public static Connection getConnection() {
	//		Connection connection = null;
	//		try {
	//			Class.forName(driver);
	//			connection = DriverManager.getConnection(url, username, password);
	//		} catch (ClassNotFoundException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return connection;
	//	}

	//关闭
	public static void close(Connection connection, Statement statement, ResultSet set) {
		if (set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();//连接是池子里的连接，归还到池子
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
