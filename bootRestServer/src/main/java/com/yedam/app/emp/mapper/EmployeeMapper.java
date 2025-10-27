package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.emp.service.Departments;
import com.yedam.app.emp.service.Employee;
import com.yedam.app.emp.service.Jobs;

@Mapper
public interface EmployeeMapper {

	List<Employee> findEmployees();		//사원검색
	Employee findById(Integer id);    //사원ID로 검색
	int persist(Employee emp);			//사원등록
	int merge(Employee emp);			//사원수정
	int remove(Integer id);				//사원삭제
	
	List<Jobs> findJobs();				//job검색
	List<Departments> findDepartments();//부서검색
}
