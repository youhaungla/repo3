package com.yhl.util;

import java.sql.Connection;
import java.sql.DriverManager;
/*
 * 
 * 数据库工具类
 * @author admin
 */
public class DbUtil {
	private String url= "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private String user= "root";
	private String password="root";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(url, user, password);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}