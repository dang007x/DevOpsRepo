package com.bootcamp.converter;

import org.springframework.stereotype.Component;

import com.bootcamp.dto.EmployeeDTO;
import com.bootcamp.dto.EmployeeLiteDTO;
import com.bootcamp.entity.EmployeeEntity;

@Component
public class EmployeeConverter {
	
	public EmployeeEntity toEntity(EmployeeDTO dto) {
		EmployeeEntity entity = new EmployeeEntity();
//		entity.setFull_name(dto.getFull_name());
//		entity.setAge(dto.getAge());
//		entity.setDate_of_birth(dto.getDate_of_birth());
//		entity.setSex(dto.getSex());
//		entity.setPhone_number(dto.getPhone_number());
//		entity.setAddress(dto.getAddress());
//		entity.setPosition(dto.getPosition());
//		entity.setFirst_name(dto.getFirst_name());
//		entity.setLast_name(dto.getLast_name());
//		entity.setEmail(dto.getEmail());
//		entity.setPhone_number(dto.getPhone_number());
//		entity.setSalary(dto.getSalary());
		return entity;
	}
	
	public EmployeeDTO toDTO(EmployeeEntity entity) {
		EmployeeDTO dto = new EmployeeDTO();

		if(entity.getEmployee_id() != null) {
			dto.setEmployee_id(entity.getEmployee_id());
		}
		dto.setFirst_name(entity.getFirst_name());
		dto.setLast_name(entity.getLast_name());
		dto.setEmail(entity.getEmail());
		dto.setPhone_number(entity.getPhone_number());
		dto.setHire_date(entity.getHire_date());
		dto.setJob_id(entity.getJob().getJob_id());
		dto.setSalary(entity.getSalary());
		dto.setCommission_pct(entity.getCommission_pct());
		dto.setDepartment_id(entity.getDepartment().getDepartment_id());
		
		return dto;
	}
	
	public EmployeeLiteDTO toLiteDTO(EmployeeEntity entity) {
		EmployeeLiteDTO dto = new EmployeeLiteDTO();

		if(entity.getEmployee_id() != null) {
			dto.setEmployee_id(entity.getEmployee_id());
		}
		dto.setDepartment_id(entity.getDepartment().getDepartment_id());
		dto.setName(entity.getFirst_name() + " " + entity.getLast_name());
		dto.setEmail(entity.getEmail());
		return dto;
	}
	
	public EmployeeEntity toEntity(EmployeeDTO dto, EmployeeEntity entity) {
//		entity.setFull_name(dto.getFull_name());
//		entity.setAge(dto.getAge());
//		entity.setDate_of_birth(dto.getDate_of_birth());
//		entity.setSex(dto.getSex());
//		entity.setPhone_number(dto.getPhone_number());
//		entity.setAddress(dto.getAddress());
//		entity.setPosition(dto.getPosition());
		return entity;
	}

}
