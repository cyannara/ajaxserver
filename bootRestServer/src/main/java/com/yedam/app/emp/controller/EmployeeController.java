package com.yedam.app.emp.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.mapper.EmployeeMapper;
import com.yedam.app.emp.service.Departments;
import com.yedam.app.emp.service.Employee;
import com.yedam.app.emp.service.Jobs;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",  maxAge = 3600)
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeMapper employeeDao;
	
	//사원검색
	@GetMapping(value="/emp")
	public List<Employee> selectDepartment() {
		logger.info("사원전체조회");
		return employeeDao.findEmployees();
	}	
	
	//사원 ID검색
	@GetMapping(value="/emp/{id}")
	public Employee findById(@PathVariable int id) {
		logger.info("사원검색:"+ id);
		return employeeDao.findById(id);
	}
	
	//부서와 직업 검색
	@GetMapping(value="/deptJob")
	public Map<String, Object> jobDeptList() {
		Map<String, Object> map = new HashMap<>();
		map.put("jobs", employeeDao.findJobs());
		map.put("depts", employeeDao.findDepartments());
		return map;		
	}	
	
	
	//부서 검색
	@GetMapping(value="/dept")
	public  List<Departments> deptList() {
		return employeeDao.findDepartments();		
	}	
	
	//직업 검색
	@GetMapping(value="/job")
	public   List<Jobs> jobList() {
		return employeeDao.findJobs();		
	}	
	
	//사원등록
	@PostMapping(value="/emp")
	public  boolean insertEmployees( @RequestBody Employee emp) {
		return employeeDao.persist(emp) == 1 ? true : false;
	}
	
	//사원정보수정
	@PutMapping(value="/emp/{id}")
	public  boolean updateEmployees(@PathVariable int id, @RequestBody Employee emp) {
		return employeeDao.merge(emp) == 1 ? true : false;
	}	
	
	//사원삭제
	@DeleteMapping(value="/emp/{id}")
	public  boolean deleteEmployees(@PathVariable Integer id) {
		return employeeDao.remove(id) == 1 ? true : false;
	}
}
