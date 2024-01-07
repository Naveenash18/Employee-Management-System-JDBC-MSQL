package employee;

import java.sql.*;

public class EmployeeService implements EmployeeDAO {

	Connection con;

	@Override
	public void createEmployee(Employee emp) throws Exception {

		con = DBConnection.createDBConnection();

		PreparedStatement pstm = con.prepareStatement(DBQueryUtil.queryCreate());
		pstm.setInt(1, emp.getId());
		pstm.setString(2, emp.getName());
		pstm.setInt(3, emp.getAge());
		pstm.setDouble(4, emp.getSalary());
		int count = pstm.executeUpdate();
		if (count != 0) {
			System.out.println("Employee Inserted Successfully!.....\n");
		} else {
			System.out.println("Insert Failed!...\n");
		}

	}

	@Override
	public void viewAllEmployee() throws Exception {

		System.out.println("+-------------+-----------------+-----+--------------+");
		System.out.println("| Employee ID |       Name      | Age |    Salary    |");
		System.out.println("+-------------+-----------------+-----+--------------+");

		con = DBConnection.createDBConnection();

		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(DBQueryUtil.queryViewAll());
		while (result.next()) {
			System.out.format("| %-11d | %-15s | %-3d | %-7f |\n", result.getInt(1), result.getString(2),
					result.getInt(3), result.getDouble(4));
			System.out.println("+-------------+-----------------+-----+--------------+");

		}

	}

	@Override
	public boolean viewEmployee(int id) throws Exception {

		boolean isFound = false;

		con = DBConnection.createDBConnection();

		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(DBQueryUtil.queryViewId(id));

		if (result.next()) {

			System.out.println(" ID : " + result.getInt(1) + "\n" + " Name : " + result.getString(2) + "\n" + " Age : "
					+ result.getInt(3) + "\n" + " Salary : " + result.getDouble(4));

		} else {

			System.out.println(" ID " + id + " is not found!....");
		}

		System.out.println("");

		return isFound;

	}

	@Override
	public void updateEmployee(int id, double salary) throws Exception {

		con = DBConnection.createDBConnection();

		PreparedStatement pstm = con.prepareStatement(DBQueryUtil.queryUpdate());
		pstm.setDouble(1, salary);
		pstm.setInt(2, id);

		int count = pstm.executeUpdate();
		if (count != 0)
			System.out.println("Employee salary Updated Successfully!.....\n");

	}

	@Override
	public void deleteEmployee(int id) throws Exception {

		con = DBConnection.createDBConnection();

		PreparedStatement pstm = con.prepareStatement(DBQueryUtil.queryDelete());
		pstm.setInt(1, id);

		int count = pstm.executeUpdate();
		if (count != 0) {
			System.out.println("Employee Deleted Successfully!.....\n");
		} else {
			System.out.println("Empoyee not found!!.....");
		}

	}

}
