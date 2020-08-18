package com.bootcamp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bootcamp.converter.DepartmentConverter;
import com.bootcamp.converter.EmployeeConverter;
import com.bootcamp.dto.DepartmentDTO;
import com.bootcamp.dto.DepartmentLiteDTO;
import com.bootcamp.dto.EmployeeDTO;
import com.bootcamp.entity.DepartmentEntity;
import com.bootcamp.entity.EmployeeEntity;
import com.bootcamp.repository.DepartmentRepository;
import com.bootcamp.repository.EmployeeRepository;
import com.bootcamp.service.IDepartmentService;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private DepartmentConverter departmentConverter;

	@Autowired
	private EmployeeConverter employeeConverter;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<DepartmentDTO> getAll(Pageable pageable) {
		List<DepartmentDTO> result = new ArrayList<DepartmentDTO>();
		List<DepartmentEntity> entities = departmentRepository.findAll(pageable).getContent();

		for (DepartmentEntity item : entities) {
			DepartmentDTO departmentDTO = departmentConverter.toDTO(item);
			result.add(departmentDTO);
		}

		return result;
	}

	@Override
	public List<DepartmentDTO> getAll() {
		List<DepartmentDTO> result = new ArrayList<DepartmentDTO>();
		List<DepartmentEntity> entities = departmentRepository.findAll();

		for (DepartmentEntity item : entities) {
			DepartmentDTO departmentDTO = departmentConverter.toDTO(item);
			result.add(departmentDTO);
		}

		return result;
	}

	@Override
	public int totalItem() {
		return (int) departmentRepository.count();
	}
	

	@Override
	public int totalEmployeeOfDepartment(Integer department_id) {
		return employeeRepository.countEmployeeByDepartmentId(department_id);
	}


	@Override
	public DepartmentDTO getOne(Integer id) {
		DepartmentDTO result = new DepartmentDTO();
		DepartmentEntity entity = departmentRepository.findOne(id);

		result = departmentConverter.toDTO(entity);

		return result;
	}

	@Override
	public List<EmployeeDTO> getEmployee(Integer department_id) {
		List<EmployeeDTO> result = new ArrayList<EmployeeDTO>();
		List<EmployeeEntity> entities = employeeRepository.findById(department_id);

		for (EmployeeEntity item : entities) {
			EmployeeDTO employeeDTO = employeeConverter.toDTO(item);
			result.add(employeeDTO);
		}

		return result;
	}

	@Override
	public List<EmployeeDTO> getEmployee(Integer department_id, Pageable pageable) {
		List<EmployeeDTO> result = new ArrayList<EmployeeDTO>();
		List<EmployeeEntity> entities = employeeRepository.findAll(pageable).getContent();

		for (EmployeeEntity item : entities) {
			if(item.getDepartment().getDepartment_id() == department_id) {
				EmployeeDTO employeeDTO = employeeConverter.toDTO(item);
				result.add(employeeDTO);
			}
		}

		return result;
	}

//	@Override
//	public List<Object> getDepartmentName() {
//		List<Object> result = new ArrayList<Object>();
//		result = departmentRepository.getByName();
//		return result;
//	}

	@Override
	public List<DepartmentLiteDTO> getDepartmentName() {
		List<DepartmentLiteDTO> result = new ArrayList<DepartmentLiteDTO>();
		List<DepartmentEntity> entities = departmentRepository.getByName();

		for (DepartmentEntity item : entities) {
			DepartmentLiteDTO departmentLiteDTO = departmentConverter.toLiteDTO(item);
			result.add(departmentLiteDTO);
		}

		return result;
	}

}
