package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.db.HibernateUtil;
import com.entity.User;

@WebServlet("/userRegister")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String fullName = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String about = req.getParameter("about");
		
		
		User user = new User(fullName, email, password, about);
		
		UserDAO userDao = new UserDAO(HibernateUtil.getSessionFactory());
		
		boolean f = userDao.saveUser(user);

		HttpSession session = req.getSession();
		
		
		
		if(f) {
			System.out.println("User registered successfully");
			session.setAttribute("msg", "Registered Successfully");
			resp.sendRedirect("register.jsp");
		}
		else {
			System.out.println("Something went wrong");
			session.setAttribute("msg", "Something went Wrong");
			resp.sendRedirect("register.jsp");
		}
		
		
	}

	
	
}
