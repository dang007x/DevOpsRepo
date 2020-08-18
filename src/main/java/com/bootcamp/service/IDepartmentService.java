package com.bootcamp.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bootcamp.dto.DepartmentDTO;
import com.bootcamp.dto.DepartmentLiteDTO;
import com.bootcamp.dto.EmployeeDTO;

public interface IDepartmentService {
	List<DepartmentDTO> getAll(Pageable pageable);
	List<DepartmentDTO> getAll();
	
	List<EmployeeDTO> getEmployee(Integer id);
	List<EmployeeDTO> getEmployee(Integer id, Pageable pageable);
	
	List<DepartmentLiteDTO> getDepartmentName();
	
	//List<Object> getDepartmentName();
	
	int totalItem();
	int totalEmployeeOfDepartment(Integer department_id);
	
	DepartmentDTO getOne(Integer id);
}
