package com.cglia.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.demo.entity.Department;
import com.cglia.demo.service.DepartmentService;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		logger.info("Saving department: {}", department);
		//System.out.println("Saving department: {}", department);
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		logger.info("Fetching department list");
		return departmentService.fetchDepartmentList();
	}

	@PutMapping("/departments/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId) {
		logger.info("Updating department with ID {}: {}", departmentId, department);
		return departmentService.updateDepartment(department, departmentId);
	}

	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		logger.info("Deleting department with ID {}", departmentId);
		return "Deleted Successfully";
	}

}
