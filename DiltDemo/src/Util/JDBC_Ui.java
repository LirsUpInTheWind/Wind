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
		//���Properties����
		Properties pro = new Properties();
		//��ȡ�����ļ��������·����ȡ�ļ�
		InputStream  is = JDBC_Ui.class.getResourceAsStream("pro.Properties");
		try {
			//�����ļ���
			pro.load(is);
			//���ݼ����ֵ
			driver=pro.getProperty("driver");
			url=pro.getProperty("url");
			user=pro.getProperty("user");
			password=pro.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//������ӷ��� 
	public static Connection getConnection() throws Exception{
		Class.forName(driver);
		Connection conn =DriverManager.getConnection(url,user,password);
		return conn;
	}
	//�ṩ�رշ���
	public static void closeConnection(ResultSet rs,Statement stat,Connection conn) throws Exception{
		if(rs!=null)rs.close();
		if(stat!=null)stat.close();
		if(conn!=null)conn.close();
	}
	//����
	public static void closeConnection(Statement stat,Connection conn) throws Exception{
		closeConnection(null, stat, conn);
		
	}
	public static void main(String[] args) throws Exception {
		JDBC_Ui g = new JDBC_Ui();
		System.out.println(g.getConnection());
	}
}
