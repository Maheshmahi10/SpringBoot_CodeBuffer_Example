package com.mahi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mahi.entity.Department;
import com.mahi.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp() {
		Department department =  Department.builder()
				                .departmentId(1L)
				                .departmentName("Development")
				                .departmentAddress("Jupiter")
				                .departmentCode("D001").build();
		Mockito.when(departmentRepository.findByDepartmentName("Development")).thenReturn(department);
		
	}
	
	@Test
	@DisplayName(value = "Get data based on Valid Department Name")
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		
		String deptName="Development";
		
		Department found= departmentService.fetchDepartmentByName(deptName);
		
		assertEquals(deptName,found.getDepartmentName());
		
	}

}
