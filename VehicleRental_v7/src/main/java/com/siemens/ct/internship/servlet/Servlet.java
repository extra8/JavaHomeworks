package com.siemens.ct.internship.servlet;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Servlet extends HttpServlet 
{
	static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	
    }
}