package com.sever;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Time
 */
@WebServlet("/Time")
public class Time extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 设置响应内容类型
 	      response.setContentType("text/html");
 		// 实际的逻辑是在这里
 	      PrintWriter out = response.getWriter();
		  out.println("<table border=\"1\">");
   	      out.println("<tr><th>"+"Time"+
	        			 "</th>"+
	        			 "</tr>");

   	      
   	      for(int i=0;i<30;i++) {
   	    	int r = (int)(Math.random()*3);
   	    	out.println("<tr><th>"+r+
        			 "</th>"+
        			 "</tr>");
   	      }
   	   out.println("</table>");
   	   out.flush();
   	   out.close();
	}

}
