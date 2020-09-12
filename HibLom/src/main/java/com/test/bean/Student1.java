package com.test.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "Student1", uniqueConstraints= {@UniqueConstraint (columnNames= {"id"})})
public class Student1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable =false , unique =true,length=11)
	int id;
	
	@Column(name= "name", nullable=false , length=12)
	String name;
	
}
