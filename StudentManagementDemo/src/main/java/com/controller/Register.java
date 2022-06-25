package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentImpl;
import com.model.Student;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		StudentImpl object = new StudentImpl();
		Student student = new Student();
		String isEdit = (String) session.getAttribute("user");
		System.out.println(isEdit);
		if (isEdit != null) {
			System.out.println("inside update method...");
			String id = (String) session.getAttribute("id");
			student.setFirstName(request.getParameter("fname"));
			student.setLastName(request.getParameter("lname"));
			student.setId(Integer.parseInt(id));
			object.updateStudent(student);
			session.removeAttribute("id");
			// session.removeAttribute("user");
			RequestDispatcher req = request.getRequestDispatcher("main.jsp");
			req.forward(request, response);
		} else {
			System.out.println("inside register method..");
			student.setFirstName(request.getParameter("fname"));
			student.setLastName(request.getParameter("lname"));
			object.addStudent(student);
			RequestDispatcher req = request.getRequestDispatcher("main.jsp");
			req.forward(request, response);
		}

	}

}
