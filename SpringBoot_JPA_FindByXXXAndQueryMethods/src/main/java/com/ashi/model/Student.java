package com.ashi.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stundet_info")
public class Student{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//1 ...
	@Column(name = "sid")
	private Integer id;
	
	@Column(name = "sname",length = 50,nullable = false )
	private String name; //if @Column not given => name is column name and size 255
	
	private String gender;
	
	private Double marks;
	
	@Column(name = "std_phno",unique = true,nullable = false)
	private Long phNo;
	
	
	
	
	
	
	
	
}
