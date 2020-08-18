package com.bootcamp.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.api.output.DepartmentOutput;
import com.bootcamp.api.output.EmployeeOutput;
import com.bootcamp.dto.DepartmentDTO;
import com.bootcamp.dto.DepartmentLiteDTO;
import com.bootcamp.service.IDepartmentService;

@CrossOrigin
@RestController
public class DepartmentAPI {
	
	@Autowired
	private IDepartmentService departmentService;
	
	@GetMapping(value = "/department/detail")
	public DepartmentOutput showDepartment(@RequestParam(value = "page", required = false) Integer page,
										   @RequestParam(value = "limit", required = false) Integer limit) {
		
		DepartmentOutput result = new DepartmentOutput();
		
		if(page == null && limit == null) {
			result.setListResult(departmentService.getAll());
		}
		else {
			result.setCurrentPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(departmentService.getAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (departmentService.totalItem()) / limit));
		}
		
		return result;
	}
	
	@GetMapping(value = "/department/find")
	public DepartmentDTO showDepartment(@RequestParam(value = "id") Integer id) {
		DepartmentDTO dto = new DepartmentDTO();
		dto = departmentService.getOne(id);
		
		return dto;
	}
	
	@GetMapping(value = "/department/employee")
	public EmployeeOutput showEmployee(@RequestParam(value = "department_id") Integer department_id,
										  @RequestParam(value = "page", required = false) Integer page,
										  @RequestParam(value = "limit", required = false) Integer limit){
		
		EmployeeOutput result = new EmployeeOutput();

		if(page == null || limit == null) {
			result.setListResult(departmentService.getEmployee(department_id));
		}
		else {
			result.setCurrentPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(departmentService.getEmployee(department_id, pageable));
			result.setTotalPage((int) Math.ceil((double) (departmentService.totalEmployeeOfDepartment(department_id)) / limit));
		}
		
		return result;
	}
	
	@GetMapping(value = "/department")
	public List<DepartmentLiteDTO> showName() {
		List<DepartmentLiteDTO> result = new ArrayList<DepartmentLiteDTO>();
		
		result = departmentService.getDepartmentName();
		
		return result;
	}
	
//	@GetMapping(value = "/department")
//	public List<Object> showName() {
//		List<Object> result = new ArrayList<Object>();
//		
//		result = departmentService.getDepartmentName();
//		
//		return result;
//	}
	
} 
