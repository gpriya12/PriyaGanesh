package DAOPackage;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DbconnectPackage.DbConnection;
import ModelPackage.LoginModel;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDAO loginDao;

    public boolean validate(LoginModel loginModel) throws ClassNotFoundException {
        boolean status = false;


        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DbConnection.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from users where username = ? and password = ? ")) {
            preparedStatement.setString(1, loginModel.getUsername());
            preparedStatement.setString(2, loginModel.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs);
            status = rs.next();
            System.out.println(status);
            System.out.println(rs.next());

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return status;
    }
}


