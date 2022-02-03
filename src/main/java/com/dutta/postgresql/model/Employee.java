package com.dutta.postgresql.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Table(name = "employee")
@Entity
public class Employee extends EmployeeAudit{

   
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}
