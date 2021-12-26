package com.yj.app.emp.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
private Integer employeeId; 	//not null
private String firstName;
private String lastName;	//not null
private String email;		//not null, unique
private String phoneNumber;
private Date hireDate;		//not null
private String jobId;		//not null
private Integer salary;
private Double commissionPct = 0.00;
private Integer managerId = 0;
private Integer departmentId = 0;
}
