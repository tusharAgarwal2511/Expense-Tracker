package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDAO;
import com.db.HibernateUtil;
import com.entity.Expense;
import com.entity.User;


@WebServlet("/addExpense")
public class SaveExpenseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String title = req.getParameter("title");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		
		HttpSession session = req.getSession();
		
		User user = (User)session.getAttribute("loginUser");
		
		
		Expense exp = new Expense(title, date, time, description, price, user);
		
		
		ExpenseDAO expenseDao = new ExpenseDAO(HibernateUtil.getSessionFactory());
		
		boolean f = expenseDao.saveExpense(exp);
		
		if(f) {
			session.setAttribute("msg", "Expense Added Successfully");
			resp.sendRedirect("user/add_expense.jsp");
		}
		else {
			session.setAttribute("msg", "Something went Wrong");
			resp.sendRedirect("user/add_expense.jsp");
		}
	}
	
	
	

}
