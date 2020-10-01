package DAOPackage;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DbconnectPackage.DbConnection;
import ModelPackage.TodoModel;

public class TodoDAOImpl implements TodoDAO {

	public TodoDAOImpl() {

	}

	@Override
	public void insert(TodoModel todo) throws SQLException {
		// TODO Auto-generated method stub
		try {
			
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into todos(title,username,description,target_date,is_done) values(?,?,?,?,?)");
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getUsername());
			ps.setString(3, todo.getDescription());
			ps.setDate(4, DbConnection.getSQLDate(todo.getTargetDate()));
			ps.setBoolean(5, todo.getStatus());
			System.out.println(ps);
			ps.executeUpdate();
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public TodoModel select(long todoid) {
		// TODO Auto-generated method stub
		TodoModel todo = null;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select id,title,username,description,target_date,is_done from todos where id=?");
			ps.setLong(1, todoid);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String username = rs.getString("username");
				String description = rs.getString("description");
				Date targetDate = rs.getDate("target_date");
				LocalDate td = targetDate != null ? targetDate.toLocalDate() : null;
				boolean isDone = rs.getBoolean("is_done");
				todo = new TodoModel(id, title, username, description, td, isDone);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return todo;
	}

	@Override
	public List<TodoModel> selectAll() {
		// TODO Auto-generated method stub
		List<TodoModel> listTodo = new ArrayList<>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from todos");
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String username = rs.getString("username");
				String description = rs.getString("description");
				Date targetDate = rs.getDate("target_date");
				LocalDate td = targetDate != null ? targetDate.toLocalDate() : null;
				boolean isDone = rs.getBoolean("is_done");
				listTodo.add(new TodoModel(id, title, username, description, td, isDone));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listTodo;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		boolean rowDelete = false;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from todos where id=? ");
			ps.setInt(1, id);
			rowDelete = ps.executeUpdate() > 0;
			System.out.println(rowDelete);
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return rowDelete;
	}

	@Override
	public boolean update(TodoModel todo) throws SQLException {
		// TODO Auto-generated method stub
		boolean rowUpdate = false;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update todos set title=?,username=?,description=?,target_date=?,is_done=? where id=?");
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getUsername());
			ps.setString(3, todo.getDescription());
			ps.setDate(4, DbConnection.getSQLDate(todo.getTargetDate()));
			ps.setBoolean(5, todo.getStatus());
			ps.setLong(6, todo.getId());
			rowUpdate = ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdate;
	}

}
