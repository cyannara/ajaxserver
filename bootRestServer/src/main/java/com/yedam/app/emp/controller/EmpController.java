package com.yedam.app.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EmpController {

	@Autowired
	EmpService empService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@ResponseBody
	@GetMapping("emp")
	public List<EmpVO> findEmp(EmpVO vo){
		log.info("findEmp=====");
		return empService.findEmp(vo);
	}
	
}

