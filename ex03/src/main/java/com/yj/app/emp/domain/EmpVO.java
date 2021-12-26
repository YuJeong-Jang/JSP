package com.yj.app.emp.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
private int EmployeeId;	//not null, pk
private String firstName;
private String lastName;	//not null
private String email;		//not null
private String phoneNumber;
private Date hireDate;		//not null
private String jobId;		//not null
private double salary;
private double commissionPct;
private int managerId;
private int departmentId;

}
