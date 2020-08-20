package com.bootcamp.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bootcamp.dto.EmployeeDTO;
import com.bootcamp.dto.EmployeeLiteDTO;

public interface IEmployeeService {
	EmployeeDTO post(EmployeeDTO employeeDTO);
	EmployeeDTO put(EmployeeDTO employeeDTO);
	
	void delete(int[] ids);
	
	List<EmployeeDTO> getAll(Pageable pageable);
	List<EmployeeDTO> getAll();
	
	List<EmployeeLiteDTO> getEmployeeName();
	List<EmployeeLiteDTO> getEmployeeName(Pageable pageable);
	
	List<Object[]> showDetail();
	
	List<Object[]> findEmployeeById(Integer employee_id);
	List<Object[]> findEmployeeByEmail(String email);
	List<Object[]> findEmployeeByPhone(String phone_number);
	
	List<Object[]> findEmployeeByCity(String city);
	List<Object[]> findEmployeeByJobId(String job_id);
	List<Object[]> findEmployeeBySalary(Integer begin, Integer end);
	List<Object[]> findEmployeeByHireDate(String hire_date);
	List<Object[]> findEmployeeByDepartmentName(String department_name);
	List<Object[]> findEmployeeByName(String first_name, String last_name);
	List<Object[]> findEmployeeByFirstName(String first_name);
	List<Object[]> findEmployeeByLastName(String last_name);
	List<Object[]> findEmployeeByStreet(String street_address);
	
	
	int totalItem();
}