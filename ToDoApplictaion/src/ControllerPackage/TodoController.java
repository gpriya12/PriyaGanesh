package ControllerPackage;

import java.io.*;
import java.rmi.server.ServerCloneException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import DAOPackage.TodoDAO;
import DAOPackage.TodoDAOImpl;
import ModelPackage.TodoModel;

@WebServlet("/")
public class TodoController extends HttpServlet {
	private static final long serialVersionUID= 1L;
	private TodoDAO tododao;
	
	public void init() {
		tododao = new TodoDAOImpl();
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		doGet(req, res);
		
		
	}
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		String action=req.getServletPath();
		
		try {
			switch(action) {
			case "/new":
				showNewForm(req,res);
				break;
			case "/insert":
				insertTodo(req,res);
				break;
			case "/delete":
				deleteTodo(req,res);
				break;
			case "/edit":
				showEditForm(req,res);
				break;
			case "/update":
			updateTodo(req, res);
            break;
        case "/list":
            listTodo(req, res);
            break;
        default:
            RequestDispatcher dispatcher = req.getRequestDispatcher("login/login.jsp");
            dispatcher.forward(req, res);
            break;
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void listTodo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException,SQLException {
		// TODO Auto-generated method stub
		List<TodoModel> listTodo = tododao.selectAll();
		req.setAttribute("listTodo", listTodo);
		RequestDispatcher dispatcher = req.getRequestDispatcher("todo/list.jsp");
        dispatcher.forward(req, res);
		
	}

	private void updateTodo(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
        String username = req.getParameter("username");
        String description = req.getParameter("description");
        String inputString = req.getParameter("targetDate");
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate inputDate = LocalDate.parse(inputString);
        
        boolean isDone = Boolean.valueOf(req.getParameter("isDone"));
        TodoModel updateTodo = new TodoModel(id, title, username, description, inputDate, isDone);

        tododao.update(updateTodo);

        res.sendRedirect("list");
		
	}

	private void showEditForm(HttpServletRequest req, HttpServletResponse res)throws SQLException, ServletException, IOException  {
		// TODO Auto-generated method stub
	        int id = Integer.parseInt(req.getParameter("id"));
	        TodoModel existingTodo = tododao.select(id);
	        RequestDispatcher dispatcher = req.getRequestDispatcher("todo/todoform.jsp");
	        req.setAttribute("todo", existingTodo);
	        dispatcher.forward(req, res);
		
	}

	private void deleteTodo(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
        tododao.delete(id);
        res.sendRedirect("list");
		
	}

	private void insertTodo(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("title");
        String username = req.getSession().getAttribute("user").toString();
        String description = req.getParameter("description");
        boolean isDone = Boolean.valueOf(req.getParameter("isDone"));
        String inputString = req.getParameter("targetDate");
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate inputDate = LocalDate.parse(inputString);
        TodoModel newTodo = new TodoModel(title, username, description, inputDate, isDone);
        System.out.println(newTodo);
        tododao.insert(newTodo);
        res.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = req.getRequestDispatcher("todo/todoform.jsp");
        dispatcher.forward(req, res);
		
	}
	

}
