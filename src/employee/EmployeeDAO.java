package employee;

public interface EmployeeDAO {

//	create Employee
	public void createEmployee(Employee emp) throws Exception;

//	Show all Employee
	public void viewAllEmployee() throws Exception;

//	Show all Employee based on ID
	public boolean viewEmployee(int id) throws Exception;

//	update Employee
	public void updateEmployee(int id, double salary) throws Exception;

//	Delete Employee
	public void deleteEmployee(int id) throws Exception;

}
