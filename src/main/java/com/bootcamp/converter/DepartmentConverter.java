package com.bootcamp.converter;

import org.springframework.stereotype.Component;

import com.bootcamp.dto.DepartmentDTO;
import com.bootcamp.dto.DepartmentLiteDTO;
import com.bootcamp.entity.DepartmentEntity;

@Component
public class DepartmentConverter {
	public DepartmentDTO toDTO(DepartmentEntity entity) {
		DepartmentDTO dto = new DepartmentDTO();

		if (entity.getDepartment_id() != null) {
			dto.setDepartment_id(entity.getDepartment_id());
		}
		dto.setDepartment_name(entity.getDepartment_name());
		dto.setManager_id(entity.getManager().getEmployee_id());
		dto.setLocation_id(entity.getLocation().getLocation_id());

		return dto;
	}

	public DepartmentLiteDTO toLiteDTO(DepartmentEntity entity) {
		DepartmentLiteDTO dto = new DepartmentLiteDTO();
		dto.setDepartment_name(entity.getDepartment_name());

		return dto;
	}

	public DepartmentEntity toEntity(DepartmentDTO dto) {
		DepartmentEntity entity = new DepartmentEntity();

		entity.setDepartment_name(dto.getDepartment_name());
		dto.setManager_id(entity.getManager().getEmployee_id());
		
		return entity;
	}
}
