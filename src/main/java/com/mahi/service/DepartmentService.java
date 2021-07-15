package com.mahi.service;

import java.util.List;

import com.mahi.entity.Department;
import com.mahi.error.DepartmentNotFoundException;

public interface DepartmentService {

	public List<Department> fetchDepartmentList();

	public Department saveDepartment(Department department);

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Department department, Long departmentId);

	public Department fetchDepartmentByName(String departmentName);

}
