package DAOPackage;

import java.sql.SQLException;
import java.util.List;

import ModelPackage.TodoModel;

public interface TodoDAO {
	
	void insert(TodoModel todo)throws SQLException;
	TodoModel select(long todoid);
	List<TodoModel> selectAll();
	boolean delete(int id)throws SQLException;
	boolean update(TodoModel todo)throws SQLException;
	
	

}
