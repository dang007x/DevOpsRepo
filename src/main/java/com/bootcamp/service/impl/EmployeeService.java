package com.bootcamp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bootcamp.converter.EmployeeConverter;
import com.bootcamp.dto.EmployeeDTO;
import com.bootcamp.dto.EmployeeLiteDTO;
import com.bootcamp.entity.DepartmentEntity;
import com.bootcamp.entity.EmployeeEntity;
import com.bootcamp.repository.DepartmentRepository;
import com.bootcamp.repository.EmployeeRepository;
import com.bootcamp.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeConverter employeeConverter;

	@Override
	public void delete(int[] ids) {
		for (int item : ids) {
			employeeRepository.delete(item);
		}
	}

	@Override
	public EmployeeDTO post(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity = new EmployeeEntity();

		employeeEntity = employeeConverter.toEntity(employeeDTO);

		DepartmentEntity departmentEntity = departmentRepository.findOne(employeeDTO.getDepartment_id());
		employeeEntity.setDepartment(departmentEntity);
		employeeEntity = employeeRepository.save(employeeEntity);

		return employeeConverter.toDTO(employeeEntity);
	}

	@Override
	public EmployeeDTO put(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity = new EmployeeEntity();

		EmployeeEntity oldEmployee = employeeRepository.findOne(employeeDTO.getEmployee_id());
		employeeEntity = employeeConverter.toEntity(employeeDTO, oldEmployee);

		DepartmentEntity departmentEntity = departmentRepository.findOne(employeeDTO.getDepartment_id());
		employeeEntity.setDepartment(departmentEntity);
		employeeEntity = employeeRepository.save(employeeEntity);

		return employeeConverter.toDTO(employeeEntity);
	}

	@Override
	public List<EmployeeDTO> getAll(Pageable pageable) {
		List<EmployeeDTO> result = new ArrayList<EmployeeDTO>();
		List<EmployeeEntity> entities = employeeRepository.findAll(pageable).getContent();

		for (EmployeeEntity item : entities) {
			EmployeeDTO employeeDTO = employeeConverter.toDTO(item);
			result.add(employeeDTO);
		}

		return result;
	}

	@Override
	public List<EmployeeDTO> getAll() {
		List<EmployeeDTO> result = new ArrayList<EmployeeDTO>();
		List<EmployeeEntity> entities = employeeRepository.findAll();

		for (EmployeeEntity item : entities) {
			EmployeeDTO employeeDTO = employeeConverter.toDTO(item);
			result.add(employeeDTO);
		}

		return result;
	}

	@Override
	public int totalItem() {
		return (int) employeeRepository.count();
	}

	@Override
	public List<EmployeeLiteDTO> getEmployeeName() {
		List<EmployeeLiteDTO> result = new ArrayList<EmployeeLiteDTO>();
		List<EmployeeEntity> entities = employeeRepository.getByName();

		for (EmployeeEntity item : entities) {
			EmployeeLiteDTO eliteDTO = employeeConverter.toLiteDTO(item);
			result.add(eliteDTO);
		}

		return result;
	}

	@Override
	public List<EmployeeLiteDTO> getEmployeeName(Pageable pageable) {
		List<EmployeeLiteDTO> result = new ArrayList<EmployeeLiteDTO>();
		List<EmployeeEntity> entities = employeeRepository.findAll(pageable).getContent();

		for (EmployeeEntity item : entities) {
			EmployeeLiteDTO employeeDTO = employeeConverter.toLiteDTO(item);
			result.add(employeeDTO);
		}

		return result;
	}

	@Override
	public List<Object[]> showDetail() {
		List<Object[]> result;
		result = employeeRepository.showDetailInfor();
	
		return result;
	}
	
	/*
	 * Find employee with condition
	 */
	
	@Override
	public List<Object[]> findEmployeeById(Integer employee_id) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeById(employee_id);
		return result;
	}

	@Override
	public List<Object[]> findEmployeeByCity(String city) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeByCity(city);
		return result;
	}

	@Override
	public List<Object[]> findEmployeeByEmail(String email) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeByEmail(email);
		return result;
	}

	@Override
	public List<Object[]> findEmployeeByPhone(String phone_number) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeByPhone(phone_number);
		return result;
	}

	@Override
	public List<Object[]> findEmployeeByJobId(String job_id) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeByJobId(job_id);
		return result;
	}

	@Override
	public List<Object[]> findEmployeeBySalary(Integer begin, Integer end) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeBySalary(begin, end);
		return result;
	}

	@Override
	public List<Object[]> findEmployeeByHireDate(String hire_date) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeByHireDate(hire_date);
		return result;
	}

	@Override
	public List<Object[]> findEmployeeByDepartmentName(String department_name) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeByDepartmentName(department_name);
		return result;
	}

	@Override
	public List<Object[]> findEmployeeByName(String first_name, String last_name) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeByName(first_name, last_name);
		return result;
	}

	@Override
	public List<Object[]> findEmployeeByFirstName(String first_name) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeByFirstName(first_name);
		return result;
	}

	@Override
	public List<Object[]> findEmployeeByLastName(String last_name) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeByLastName(last_name);
		return result;
	}

	@Override
	public List<Object[]> findEmployeeByStreet(String street_address) {
		List<Object[]> result;
		result = employeeRepository.findEmployeeByStreet(street_address);
		return result;
	}

	/*
	 * End
	 */
}
