package com.bootcamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bootcamp.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer>{
//	@Query(value = "SELECT name, name_of_manager FROM employee_management.department", nativeQuery = true)
//	List<Object> getByName();
	
	@Query(value = "SELECT * FROM department", nativeQuery = true)
	List<DepartmentEntity> getByName();
}
