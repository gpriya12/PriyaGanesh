package DAOPackage;

import java.sql.*;

import DbconnectPackage.DbConnection;
import ModelPackage.UserModel;

public class UserDAO {

	public int registerUser(UserModel user) throws ClassNotFoundException {
		int result = 0;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into users(first_name,last_name,username,password) values(?,?,?,?)");
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			result = ps.executeUpdate();
			System.out.println(user.getUsername());
			System.out.println(result);
			if (result > 0) {
				System.out.println("Inserted into database successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
