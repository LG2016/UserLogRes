package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.javabean.Login;
import com.javabean.Register;

public class ServletControl extends HttpServlet {
	private static final long serialVersionUID = 8622123146194444515L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    this.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String login=req.getParameter("Login");
		String register=req.getParameter("Register");
		String reg=req.getParameter("Reg");
		//Null 不能和字符串做比较
		if(login==null)login="mark";
		if(register==null)register="mark";
		if(reg==null)reg="mark";
		if(login.equals("Login"))
		{
	
			String nameString=req.getParameter("username");
			String passwordString=req.getParameter("password");
			String messageString=Login.userLogin(nameString, passwordString);
			//message=password error 、no user、success login（null）
			if(messageString.equals("success login"))
			{
				resp.sendRedirect("JspView/display.jsp");
		        return;
			}else {
				req.setAttribute("message", messageString);
				req.getRequestDispatcher("JspView/login.jsp").forward(req, resp);
				return;
			}
		}
	
		if(register.equals("Register"))
		{
			req.getRequestDispatcher("JspView/register.jsp").forward(req, resp);
			return;
		}
		if(reg.equals("Reg"))
		{
			String nameString=req.getParameter("rname");
			String passwordString1=req.getParameter("rpassword1");
			String passwordString2=req.getParameter("rpassword2");
			System.out.println("pass1="+passwordString1);
			System.out.println("pass2="+passwordString2);
			if(nameString=="")
			{
			req.setAttribute("message", "userName is not empty");
			req.getRequestDispatcher("JspView/register.jsp").forward(req, resp);
			return;
			}
			if((passwordString2=="")||(passwordString1==""))
			{
			req.setAttribute("message", "password is not empty");
			req.getRequestDispatcher("JspView/register.jsp").forward(req, resp);
			return;
			}
			if(!passwordString1.equals(passwordString2))
			{
				req.setAttribute("message", "password error");
				req.getRequestDispatcher("JspView/register.jsp").forward(req, resp);
				return;
			}
			String message=Register.userRegister(nameString, passwordString1);
			  //message:register error  register success
			if(message.equals("egister error"))
			{
				req.setAttribute("message", message);
				req.getRequestDispatcher("JspView/register.jsp").forward(req, resp);
				return;
				
			}
			if(message.equals("register success"))
			{
				resp.sendRedirect("JspView/login.jsp");
				return;
			}
		}
	}

	
	

}
