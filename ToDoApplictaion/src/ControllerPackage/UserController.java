package ControllerPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAOPackage.UserDAO;
import ModelPackage.UserModel;

@WebServlet("/register")
public class UserController extends HttpServlet {

	private UserDAO userdao;
	private static final long serialVersionUID = 1L;

	public void init() {
		userdao = new UserDAO();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		userRegister(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.sendRedirect("register/register.jsp");
	}


	private void userRegister(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String uname = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(uname);

		UserModel user = new UserModel();
		user.setFirstname(fname);
		user.setLastname(lname);
		user.setUsername(uname);
		user.setPassword(password);
		System.out.println(user);

		try {
			int result = userdao.registerUser(user);
			if (result == 1) {
				req.setAttribute("NOTIFICATION", "User Registered Successfully!!");
				//System.out.println("User Registered Successfully!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher reqDis = req.getRequestDispatcher("register/register.jsp");
		reqDis.forward(req, res);

	}

	
}
