package com.ashi.entites;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*mysql> desc emp;
+------------+---------------+------+-----+---------+----------------+
| Field      | Type          | Null | Key | Default | Extra          |
+------------+---------------+------+-----+---------+----------------+
| id         | int           | NO   | PRI | NULL    | auto_increment |
| name       | varchar(100)  | YES  |     | NULL    |                |
| age        | int           | YES  |     | NULL    |                |
| department | varchar(50)   | YES  |     | NULL    |                |
| salary     | decimal(10,2) | YES  |     | NULL    |                |
+------------+---------------+------+-----+---------+----------------+
5 rows in set (0.01 sec)*/

//DTO class
//POJO class
//JAVA BEAN

//@Data //=> @Getter , @Setter , @ToString ,@HasCode

@SuppressWarnings("serial")
@Setter
@Getter
@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class EmpEntity implements Serializable {

	//recomended to use wrapper classes 
	
	private Integer Id;
	private String name;
	private Integer age;
	private String department;
	private Double salary;
	
	
}
