package com.mahi.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.entity.Department;
import com.mahi.error.DepartmentNotFoundException;
import com.mahi.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private  final Logger logger = LoggerFactory.getLogger(Department.class);

	@PostMapping("/departments")
	public Department saveDepartment( @Valid @RequestBody Department department) {
		logger.info("Inside save department of Controler");
		return departmentService.saveDepartment(department);

	}

	@GetMapping("/departmentList")
	public List<Department> fetchDepartmentList() {
		logger.info("Inside fetchDepartmentList of Controler");
		return departmentService.fetchDepartmentList();
	}

	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

		return departmentService.fetchDepartmentById(departmentId);
	}

	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "DepartmentId is deleted successfully";

	}

	@PutMapping("/departments/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId) {
		return departmentService.updateDepartment(department, departmentId);

	}

	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {

		return departmentService.fetchDepartmentByName(departmentName);
	}
}