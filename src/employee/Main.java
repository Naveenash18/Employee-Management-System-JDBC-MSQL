package employee;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			int id;
			String name;
			int age;
			double salary;

			EmployeeDAO service = new EmployeeService();

			System.out.println("*********** Welcome to the Employee Management ***********");
			System.out.println("__________________________________________________________");

			int choice;
			
			do {
				System.out.println("==========================================================");
				System.out.println("1. Create the Employee");
				System.out.println("2. View All Employee");
				System.out.println("3. View Employee based on ID");
				System.out.println("4. Update Employee ");
				System.out.println("5. Delete the Employee");
				System.out.println("6. Exit");
				System.out.println("==========================================================");

				choice = sc.nextInt();

				switch (choice) {

				case 1:
					Employee emp = new Employee();

					System.out.println("Enter Employee ID");
					id = sc.nextInt();
					System.out.println("Enter Employee Name");
					name = sc.next();
					System.out.println("Enter Employee Age");
					age = sc.nextInt();
					System.out.println("Enter Employee Salary");
					salary = sc.nextDouble();

					emp.setId(id);
					emp.setName(name);
					emp.setAge(age);
					emp.setSalary(salary);

					service.createEmployee(emp);

					break;

				case 2:

					service.viewAllEmployee();

					break;

				case 3:

					System.out.println("Enter Employee ID");
					id = sc.nextInt();

					System.out.println("Employee Details:-");
					service.viewEmployee(id);

					break;

				case 4:

					System.out.println("Enter Employee ID to Update the Details");
					id = sc.nextInt();

					boolean isFound = service.viewEmployee(id);

					if (!isFound) {
						System.out.println("Enter their Salary");
						salary = sc.nextDouble();
						service.updateEmployee(id, salary);
					}

					break;

				case 5:

					System.out.println("Enter ID to Delete Employee");
					id = sc.nextInt();

					service.deleteEmployee(id);

					break;

				case 6:

					System.out.println("****************** Thankyou for using ******************");
					System.out.println("========================================================");
					break;

				default:
					System.out.println("Please Enter Valid Choice!\n");

				}

			} while (choice != 6);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
