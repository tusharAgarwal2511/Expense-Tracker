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


@WebServlet("/userLogin")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		UserDAO userDao = new UserDAO(HibernateUtil.getSessionFactory());
		
		User u = userDao.loginUser(email, password);
		
		HttpSession session = req.getSession();
		
		if(u == null){
			session.setAttribute("msg", "Wrong email or password");
			resp.sendRedirect("login.jsp");
		}
		
		else {
			session.setAttribute("loginUser", u);
			resp.sendRedirect("user/home.jsp");
		
		}
		
	}

	
	
}
