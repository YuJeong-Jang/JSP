package com.yedam.app.Impl;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.yedam.app.Departments;
import com.yedam.app.Employees;

	//DAO
public interface EmpMapper {
//	/* emp.xml에 있는 파라미터 이름이랑 같지않아도 인수가 하나기 때문에 알아서 받아진다 */
	List<Employees> getEmp(String deptid);
	List<Departments> getDept();
	
	@Select("select sysdate from dual")
	public String getTime();
}
