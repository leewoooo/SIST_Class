package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SistController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getRequestURI().toString();
		if(url.endsWith("insertBook.do")) {
			request.setAttribute("pageName", "insertBook");
			RequestDispatcher dispatcher = request.getRequestDispatcher("insertBook.jsp");
			dispatcher.forward(request, response); //이 때 request에 값을 추가해서 보낼 수 있다.
		}else if(url.endsWith("listBook.do")) {
			request.setAttribute("pageName", "listBook");
			RequestDispatcher dispatcher = request.getRequestDispatcher("insertBook.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
