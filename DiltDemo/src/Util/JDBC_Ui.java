package Util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_Ui {
	private static String driver =null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	private static String pro=null;
	static {
		//获得Properties对象
		Properties pro = new Properties();
		//获取属性文件流，相对路径读取文件
		InputStream  is = JDBC_Ui.class.getResourceAsStream("pro.Properties");
		try {
			//加载文件流
			pro.load(is);
			//根据键获得值
			driver=pro.getProperty("driver");
			url=pro.getProperty("url");
			user=pro.getProperty("user");
			password=pro.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//获得连接方法 
	public static Connection getConnection() throws Exception{
		Class.forName(driver);
		Connection conn =DriverManager.getConnection(url,user,password);
		return conn;
	}
	//提供关闭方法
	public static void closeConnection(ResultSet rs,Statement stat,Connection conn) throws Exception{
		if(rs!=null)rs.close();
		if(stat!=null)stat.close();
		if(conn!=null)conn.close();
	}
	//重载
	public static void closeConnection(Statement stat,Connection conn) throws Exception{
		closeConnection(null, stat, conn);
		
	}
	public static void main(String[] args) throws Exception {
		JDBC_Ui g = new JDBC_Ui();
		System.out.println(g.getConnection());
	}
}
