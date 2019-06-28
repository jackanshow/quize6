package com.sever;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Clock;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowPic
 */
@WebServlet("/ShowPic")
public class ShowPic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("request");
		int date = (int) (Math.random()*9)+2010;
		String date1 =String.valueOf(date);

		Connection conn = null;
		Statement stmt=null;
		try {
		      Class.forName("org.sqlite.JDBC");
		      conn = DriverManager.getConnection("jdbc:sqlite::resource:db/cloudDB.db");
		      //conn = DriverManager.getConnection("jdbc:sqlite:"+"resource/db/xxwDB.db");
		      conn.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = conn.createStatement();
		      String sql = "SELECT * FROM QUIZE6";
		      ResultSet rs = stmt.executeQuery(sql);
		   // 设置响应内容类型
	   	      response.setContentType("text/html");
	   		// 实际的逻辑是在这里
	   	      PrintWriter out = response.getWriter();
	   	      
	   	   out.println("<h1>Xiangxiang Wang</h1>");
	   	   out.println("<h1>1001681420</h1>");
	   	   out.println("<h1>Cloud Computing 6:00</h1>");

	   	   out.println("<img alt=\"pic\" src=\"img/a.jpg\" width=\"400px\" height=\"400px\">");


	   	   
	   	   
	   	   long timeStart = Clock.systemDefaultZone().millis();	
	   	      
	   	   out.println("<table border=\"1\">");
	   	      out.println("<tr><th>"+"Texas"+"</th>"+
		        			 "<th>"+"Lousiana"+"</th><th>"+"Oklahoma"+"</th>"+
		        			 "</tr>");
	   	      String tex = null;
	   	      String lou = null;
	   	      String ok = null;
		      while ( rs.next() ) {
		    	  System.out.println(rs.getString(date1));
		         if(rs.getString(2).equals("Texas") ) {
		        	 tex = rs.getString(date1);
		        	 		        	 
		         }else if(rs.getString(2).equals("Louisiana")) {
		        	 lou = rs.getString(date1);
		         }
		         else if(rs.getString(2).equals("Oklahoma")) {
		        	 ok=rs.getString(date1);
		         }
		     
		      }
		      out.println("<tr><th>"+tex+
	        			 "<th>"+lou+"</th><th>"+ok+"</th>"+
	        			 "</tr>");
		      
		      long timeEnd = Clock.systemDefaultZone().millis();
		      out.println("</table>");
		      out.print("<p>time start:>> "+timeStart+"time end:>>"+timeEnd+"elapsed time:>>"+(timeEnd-timeStart));
		      out.println("<form action=\"Time\" method = \"get\">\r\n" + 
		      		"		<p>search for time in seconds &ensp;  \r\n" + 
		      		"		<input type=\"txt\" name= \"Mag\" placeholder = \"time\" style=\"width:30px; \"> &ensp; <input type=\"submit\" value = \"submit\">");
		      
		      /*out.println("<table border=\"1\">");
	   	      out.println("<tr><th>"+"Time"+
		        			 "</th>"+
		        			 "</tr>");
	   	      int r = (int)(Math.random()*3);
	   	      
	   	      for(int i=0;i<30;i++) {
	   	    	out.println("<tr><th>"+r+
	        			 "</th>"+
	        			 "</tr>");
	   	      }
	   	   out.println("</table>");*/
		      
		      
		      
		      
		      
		      
		      
		      
		      out.flush();
		      out.close();
		      
		      		      		      		    		      
		      rs.close();
		      stmt.close();
		      conn.close();
		    } 
		    catch(SQLException se) {
	            // 处理 JDBC 错误
	            se.printStackTrace();
	        }
		    catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    finally{
	            // 最后是用于关闭资源的块
	            try{
	                if(stmt!=null)
	                stmt.close();
	            }catch(SQLException se2){
	            }
	            try{
	                if(conn!=null)
	                conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
		    System.out.println("Operation done successfully");
	}

}
