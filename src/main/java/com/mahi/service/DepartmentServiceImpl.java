package com.mahi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahi.entity.Department;
import com.mahi.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) {
		
		return departmentRepository.findById(departmentId).get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		
		 departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		
		Department depId= departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && 
		 !"".equalsIgnoreCase(department.getDepartmentName())) {
			depId.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress()) && 
				 !"".equalsIgnoreCase(department.getDepartmentAddress())) {
					depId.setDepartmentAddress(department.getDepartmentAddress());
				}
		
		if(Objects.nonNull(department.getDepartmentCode()) && 
				 !"".equalsIgnoreCase(department.getDepartmentCode())) {
					depId.setDepartmentCode(department.getDepartmentCode());
				}
		return departmentRepository.save(depId);
		
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		
		return departmentRepository.findByDepartmentName(departmentName);
	}

}
