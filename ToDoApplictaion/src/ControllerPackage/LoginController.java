package ControllerPackage;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAOPackage.LoginDAO;
import ModelPackage.LoginModel;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private LoginDAO logindao;
	
	public void init() {
		logindao=new LoginDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        response.sendRedirect("login/login.jsp");
		    }

		    protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        verifyUser(request, response);
		    }
	private void verifyUser(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		LoginModel login=new LoginModel();
		login.setUsername(username);
		login.setPassword(password);
		
		try {
			if(logindao.validate(login)) {
				HttpSession session=req.getSession();
				session.setAttribute("user", username);
				RequestDispatcher reqDis=req.getRequestDispatcher("todo/list.jsp");
				reqDis.forward(req, res);
			}else {
				//HttpSession session=req.getSession();
				//session.setAttribute("user", username);
				res.sendRedirect("login/login.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
