package com.ashi;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.SystemPropertyUtils;

import com.ashi.controller.EmployeeController;
import com.ashi.entites.EmpEntity;
import com.ashi.services.EmployeeService;

@SpringBootApplication
public class SpringBootJdbcCrudApplication {

	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootJdbcCrudApplication.class, args);

		// logics
		EmployeeController employeeController = context.getBean(EmployeeController.class);
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			 System.out.println("======= Employee CRUD =======");
	            System.out.println("1. Get all employee list");
	            System.out.println("2. Add employee");
	            System.out.println("3. Delete employee");
	            System.out.println("4. Get Employee By ID ");
	            System.out.println("5. Exit");
	            System.out.print("Enter Choice: ");

	            int ch = sc.nextInt();
			switch (ch) {

			case 1:
				System.out.println("Employee List : ");
				List<EmpEntity> employees = employeeController.getEmployeeService().getEmployees();

				employees.stream().forEach(System.out::println);
				break;
			case 2:
				System.out.println("Add employee");
				System.out.println("Enter employee Id: ");
				int id = sc.nextInt();
				System.out.println("Enter Employee Name: ");
				String name = sc.next();
				System.out.println("Enter employee age: ");
				int age = sc.nextInt();
				System.out.println("Enter employee Department: ");
				String department = sc.next();
				System.out.println("Enter employee salary: ");
				double salary = sc.nextDouble();
				System.out.println("Enter employee");
				EmpEntity emp = new EmpEntity(id, name, age, department, salary);
				if(employeeController.getEmployeeService().addEmployee(emp)) {
					System.out.println("Employee added successfully.");
				}
				else {
					System.out.println("Employee not added!!!");
				}
				break;
			case 3:
				System.out.println("delete employee ? enter ID :");
			    int	eid = sc.nextInt();
				if(employeeController.getEmployeeService().delete(eid)) {
				     System.out.println("Employee deleted !");
				}
				else {
					System.out.println("Id not found");
				}
				
				
				break;
			case 4 :
				  System.out.println("Get Employee By id ? enter ID :");
				  int empID = sc.nextInt();
				  
				  EmpEntity employee = employeeController.getEmployeeService().getEmployeeById(empID);
				  if(employee != null) {
					  System.out.println(employee);
				  }
				  else {
					  System.out.println("Employee ID not found!!");
				  }
				  				  
				  break;
			case 5 :
				System.exit(0);
				break;
		    default : System.out.println("Invalid Choice");

			}
		}

		

	}

}
