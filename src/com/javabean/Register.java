package com.javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.util.BaseConnection;

public class Register {
	    @SuppressWarnings("unused")
		private static BaseConnection baseConnection=new BaseConnection();
	    private static Connection connection=null;
	    private static PreparedStatement pStatement=null;
	    private static String message=null;
	    private static  String sqlInsert=null;
	    //message:register error  register success
	public Register() {
	}
	public static String userRegister(String userName,String password)
    {
		connection=BaseConnection.getConnection("netWork", "root","rootmysql");
		sqlInsert="insert into user_info (user_name,password)values(?,?)";
		try {
			pStatement=connection.prepareStatement(sqlInsert);
			pStatement.setString(1, userName);
			pStatement.setString(2, password);
			int count=pStatement.executeUpdate();
			if(count==0)message="register error";
			else message="register success";
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseConnection.closeTwoRes(connection, pStatement);
		}
		return message;
    	
    }
}
