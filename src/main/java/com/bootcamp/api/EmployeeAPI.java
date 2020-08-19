package com.bootcamp.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.api.output.EmployeeLiteOutput;
import com.bootcamp.api.output.EmployeeOutput;
import com.bootcamp.dto.EmployeeDTO;
import com.bootcamp.dto.EmployeeFoundDTO;
import com.bootcamp.dto.EmployeeInformationDTO;
import com.bootcamp.service.IEmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin
@RestController
public class EmployeeAPI {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping(value = "/employee/detail")
	public EmployeeOutput showDetailEmployee(@RequestParam(value = "page", required = false) Integer page, 
									   @RequestParam(value = "limit", required = false) Integer limit) {
		
		EmployeeOutput result = new EmployeeOutput();
	
		if(page == null || limit == null) {
			result.setListResult(employeeService.getAll());
		}
		else {
			result.setCurrentPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(employeeService.getAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (employeeService.totalItem()) / limit));
		}
		
		return result;
	}
	
	@GetMapping(value = "/employee")
	public EmployeeLiteOutput showEmployee(@RequestParam(value = "page", required = false) Integer page,
											  @RequestParam(value = "limit", required = false) Integer limit) {
		
		EmployeeLiteOutput result = new EmployeeLiteOutput();
		
		if(page == null || limit == null) {
			result.setListResult(employeeService.getEmployeeName());
		}
		else {
			result.setCurrentPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(employeeService.getEmployeeName(pageable));
			result.setTotalPage((int) Math.ceil((double) (employeeService.totalItem()) / limit));
		}
		
		return result;
	}
	
//	@GetMapping(value = "/test")
//	public List<Object> showDetail() throws JsonProcessingException {
//		
//		List<Object> result = new ArrayList<Object>();
//		result = employeeService.showDetail();
//		
//		return result;
//	}
	
	@GetMapping(value = "/employee/plus")
	public List<EmployeeInformationDTO> showDetail1() throws JsonProcessingException {
		List<Object[]> result = employeeService.showDetail();
		List<EmployeeInformationDTO> finall = new ArrayList<EmployeeInformationDTO>(); 
		
		for(int i = 0; i < result.size(); i++) {
			EmployeeInformationDTO dto = new EmployeeInformationDTO();
			dto.setEmployee_id((Integer) result.get(i)[0]);
			dto.setName((String) result.get(i)[1]);
			dto.setDepartment_name((String) result.get(i)[2]);
			dto.setEmail((String) result.get(i)[3]);
			dto.setPhone_number((String) result.get(i)[4]);
			dto.setHire_date((String) result.get(i)[5]);
			dto.setSalary((Integer) result.get(i)[6]);
			dto.setJob_id((String) result.get(i)[7]);
			dto.setManager_id((Integer) result.get(i)[8]);
			dto.setCommission_pct((Integer) result.get(i)[9]);
			dto.setCity((String) result.get(i)[10]);
			dto.setStreet_address((String) result.get(i)[11]);
			
			finall.add(dto);
		}
		
		return finall;
	}
	
	@GetMapping(value = "/employee/id")
	public List<EmployeeFoundDTO> findById(@RequestParam(name = "employee_id") Integer employee_id) {
		List<Object[]> result = employeeService.findEmployeeById(employee_id);
		List<EmployeeFoundDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/city")
	public List<EmployeeFoundDTO> findByCity(@RequestParam(name = "city") String city) {
		List<Object[]> result = employeeService.findEmployeeByCity(city);
		List<EmployeeFoundDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/department_name")
	public List<EmployeeFoundDTO> findByDepartment(@RequestParam(name = "name") String department_name) {
		List<Object[]> result = employeeService.findEmployeeByDepartmentName(department_name);;
		List<EmployeeFoundDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/name")
	public List<EmployeeFoundDTO> findByName(@RequestParam(name = "first_name", required = false) String first_name,
								   @RequestParam(name = "last_name", required = false) String last_name) {
		
		List<EmployeeFoundDTO> finall = new ArrayList<EmployeeFoundDTO>();
		
		if(last_name == null) {
			List<Object[]> result = employeeService.findEmployeeByFirstName(first_name);
			finall = convertObject(result);
		}
		else if(first_name == null) {
			List<Object[]> result = employeeService.findEmployeeByLastName(last_name);
			finall = convertObject(result);
		}
		else {
			List<Object[]> result = employeeService.findEmployeeByName(first_name, last_name);
			
			finall = convertObject(result);
		}
		return finall;
	}
	
	@GetMapping(value = "/employee/jobid")
	public List<EmployeeFoundDTO> findByJobId(@RequestParam(name = "job_id") String job_id) {
		List<Object[]> result = employeeService.findEmployeeByJobId(job_id);	
		List<EmployeeFoundDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/hire_date")
	public List<EmployeeFoundDTO> findByHireDate(@RequestParam(name = "hire_date") String hire_date) {
		List<Object[]> result = employeeService.findEmployeeByHireDate(hire_date);
		List<EmployeeFoundDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/salary")
	public List<EmployeeFoundDTO> findBySalary(@RequestParam(name = "begin") Integer begin, 
											   @RequestParam(name = "end") Integer end) {
		List<Object[]> result = employeeService.findEmployeeBySalary(begin, end);
		List<EmployeeFoundDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/email")
	public List<EmployeeFoundDTO> findByEmail(@RequestParam(name = "email") String email) {
		List<Object[]> result = employeeService.findEmployeeByEmail(email);
		List<EmployeeFoundDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/phone_number")
	public List<EmployeeFoundDTO> findByPhone(@RequestParam(name = "number") String phone_number) {
		List<Object[]> result = employeeService.findEmployeeByPhone(phone_number);
		List<EmployeeFoundDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/street_address")
	public List<EmployeeFoundDTO> findByStreet(@RequestParam(name = "street") String street) {
		List<Object[]> result = employeeService.findEmployeeByStreet(street);
		List<EmployeeFoundDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@PostMapping(value = "/employee")
	public EmployeeDTO insertEmployee(@RequestBody EmployeeDTO model) {
		return employeeService.post(model);
	}
	
	@PutMapping(value = "/employee/{id}")
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO model, @PathVariable("id") int id) {
		model.setEmployee_id(id);
		return employeeService.put(model);
	}
	
	@DeleteMapping(value = "/employee")
	public void deleteEmployee(@RequestBody int[] ids) {
		employeeService.delete(ids);
	}
	
	public List<EmployeeFoundDTO> convertObject(List<Object[]> result) {
		List<EmployeeFoundDTO> finall = new ArrayList<EmployeeFoundDTO>();
		
		for(int i = 0; i < result.size(); i++) {
			EmployeeFoundDTO dto = new EmployeeFoundDTO();
			dto.setEmployee_id((Integer) result.get(i)[0]);
			dto.setName((String) result.get(i)[1]);
			dto.setEmail((String) result.get(i)[2]);
			dto.setDepartment_id((Integer) result.get(i)[3]);
			dto.setDepartment_name((String) result.get(i)[4]);
			dto.setSalary((Integer) result.get(i)[5]);
			
			finall.add(dto);
		}
		return finall;
	}
	
	@GetMapping("/")
	String hello() {
		return "Hello World";
	}
	
	@GetMapping("/test")
	EmployeeFoundDTO test() {
		EmployeeFoundDTO dto = new EmployeeFoundDTO();
		dto.setEmployee_id(12);
		dto.setName("Nguyen Dag");
		dto.setEmail("ththth@gmail.com");
		dto.setDepartment_id(1239);
		dto.setDepartment_name("XLLL");
		dto.setSalary(10000);
		return dto;
	}
}
