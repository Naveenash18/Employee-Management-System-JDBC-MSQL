package employee;

import java.sql.*;

public final class DBConnection {

	private static Connection con = null;

	public static final Connection createDBConnection() {

		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Naveen@2003");

		} catch (Exception e) {

			e.printStackTrace();

		}

		return con;

	}

}
