package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentImpl;
import com.model.Student;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Update() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside update servlet...........");
		StudentImpl object = new StudentImpl();
		String user = request.getParameter("user");
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		String userId = request.getParameter("userId");
		List<Student> students = object.getDetails(Integer.parseInt(userId));
		Student student = students.get(0);
		session.setAttribute("id", userId);
		System.out.println(student);
		session.setAttribute("details", student);
		RequestDispatcher req = request.getRequestDispatcher("register.jsp");
		req.forward(request, response);

	}

}
