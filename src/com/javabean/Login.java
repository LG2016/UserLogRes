package com.javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.BaseConnection;

public class Login {
   @SuppressWarnings("unused")
    private static BaseConnection baseConnection=new BaseConnection();
    private static Connection connection=null;
    private static PreparedStatement pStatement=null;
    private static ResultSet rs=null;
    private static String message=null;
    private static  String sqlToName=null;
    private static String sqlToNameAndPassord=null;
	public Login() {
	}
	//message=password error ¡¢no user¡¢success login£¨null£©
   public static String  userLogin(String userName,String password)
   {
	 connection=BaseConnection.getConnection("netWork", "root","rootmysql");
	 sqlToName="select count(0) from user_info where user_name='"+userName+"'";
	 sqlToNameAndPassord="select count(0) from user_info where user_name='"+userName+"'"+
	 "and password= '"+password+"'";
	 try {
		pStatement=connection.prepareStatement(sqlToName);
		rs=pStatement.executeQuery();
		if(rs.next())
		{
			int userCount=rs.getInt(1);
			if(userCount==0)
			{
				message="no user";
				return message;
			}
		}
	    pStatement=connection.prepareStatement(sqlToNameAndPassord);
	     rs=pStatement.executeQuery();
	    if(rs.next())
	    {
	    	int trueUserCount=rs.getInt(1);
	    	if(trueUserCount==0)
	    	{
	    		message="password error";
	    		return message;
	    	}
	    	message="success login";
	    }
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		BaseConnection.closeTreeRes(connection, pStatement, rs);
	}
		return message;   
	}
 
}
