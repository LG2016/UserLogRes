package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseConnection
{
	private static String driverClassName="com.mysql.jdbc.Driver";
	private static String mysqlUrl="jdbc:mysql://localhost:3306/";
		public static Connection getConnection(String databaseName,String user,String password)//根据数据库的名称，用户名和密码来获取数据库的连接
		{
			Connection conn=null;
			try {
				Class.forName(driverClassName);
				conn=DriverManager.getConnection(mysqlUrl+databaseName,user,password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;	
		}
		public static void closeTwoRes(Connection conn,PreparedStatement pstat)//关闭两个资源
		{
			try{
				if(pstat!=null)pstat.close();
				if(conn!=null)conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		public static void closeTreeRes(Connection conn,PreparedStatement pstat,ResultSet rs)//关闭三个资源
		{
			try{
				if(rs!=null)rs.close();
				if(pstat!=null)pstat.close();
				if(conn!=null)conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
}
