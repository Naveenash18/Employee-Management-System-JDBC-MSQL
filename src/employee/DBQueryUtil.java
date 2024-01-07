package employee;

public class DBQueryUtil {

	public static String queryCreate() {

		return "insert into employee values (?,?,?,?)";

	}
	
	public static String queryViewAll() {

		return "select * from employee";

	}
	
	public static String queryViewId(int id) {

		return "select * from employee where id = " + id;

	}
	
	public static String queryUpdate() {

		return "update employee set salary = ? where id = ?";

	}
	
	public static String queryDelete() {

		return "delete from employee where id = ?";

	}

}
