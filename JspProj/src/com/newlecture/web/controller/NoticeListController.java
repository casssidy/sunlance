package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		  String field_ = request.getParameter("f"); 
		  String query_ = request.getParameter("q");
		  String page_ = request.getParameter("p"); 
		 
		  String field = "title"; 
		  if(field_ != null) 
			  field = field_;
		  
		  String query = "query"; 
		  if(query_ != null) 
			  query = query_;
		  
		  int page = 1; 
		  if(page_ != null) 
			  page = Integer.parseInt(page_);
		 //test

		NoticeService service = new NoticeService();
		List<Notice> list = service.getNoticeList(field, query, page);

		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
	}
}
