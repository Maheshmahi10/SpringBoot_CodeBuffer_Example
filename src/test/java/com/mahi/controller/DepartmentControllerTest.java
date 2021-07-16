package com.mahi.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mahi.entity.Department;
import com.mahi.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService; 
	
	private Department department;
	
	void setUp() {
		
		department= Department.builder()
				.departmentId(1L)
				.departmentName("Computer")
				.departmentAddress("Bengaluru")
				.departmentCode("CS-01")
				.build();
	}

	@Test
	public void saveDepartmet() {
		Department inputdepartment= Department.builder()
				.departmentName("Computer")
				.departmentAddress("Bengaluru")
				.departmentCode("CS-01")
				.build();
		Mockito.when(departmentService.saveDepartment(inputdepartment)).thenReturn(department);
		
        
	}
	
	public void fetchDepartmentById() {
		
	}
}
