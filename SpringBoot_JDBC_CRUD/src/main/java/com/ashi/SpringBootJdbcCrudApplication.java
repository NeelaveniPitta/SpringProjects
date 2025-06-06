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
				System.out.println("Ëmployee List : ");
				List<EmpEntity> employees = employeeController.getEmployeeService().getEmployees();

				employees.stream().forEach(System.out::println);
				break;
			case 2:
				System.out.println("Add employee");
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
				  System.out.println("Get Employee By id  ?");
				  break;
			case 5 :
				System.exit(0);
				break;
		    default : System.out.println("Invalid Choice");

			}
		}

		

	}

}
