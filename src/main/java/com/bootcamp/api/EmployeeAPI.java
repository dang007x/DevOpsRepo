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
import com.bootcamp.dto.EmployeeInformationDTO;
import com.bootcamp.dto.EmployeePlusDTO;
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
	public List<EmployeePlusDTO> showDetail() throws JsonProcessingException {
		List<Object[]> result = employeeService.showDetail();
		List<EmployeePlusDTO> finall = convertObjectPlus(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/id")
	public List<EmployeeInformationDTO> findById(@RequestParam(name = "employee_id") Integer employee_id) {
		List<Object[]> result = employeeService.findEmployeeById(employee_id);
		List<EmployeeInformationDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/city")
	public List<EmployeeInformationDTO> findByCity(@RequestParam(name = "city") String city) {
		List<Object[]> result = employeeService.findEmployeeByCity(city);
		List<EmployeeInformationDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/department_name")
	public List<EmployeeInformationDTO> findByDepartment(@RequestParam(name = "name") String department_name) {
		List<Object[]> result = employeeService.findEmployeeByDepartmentName(department_name);;
		List<EmployeeInformationDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/name")
	public List<EmployeeInformationDTO> findByName(@RequestParam(name = "first_name", required = false) String first_name,
								   @RequestParam(name = "last_name", required = false) String last_name) {
		
		List<EmployeeInformationDTO> finall = new ArrayList<EmployeeInformationDTO>();
		
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
	public List<EmployeeInformationDTO> findByJobId(@RequestParam(name = "job_id") String job_id) {
		List<Object[]> result = employeeService.findEmployeeByJobId(job_id);	
		List<EmployeeInformationDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/hire_date")
	public List<EmployeeInformationDTO> findByHireDate(@RequestParam(name = "hire_date") String hire_date) {
		List<Object[]> result = employeeService.findEmployeeByHireDate(hire_date);
		List<EmployeeInformationDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/salary")
	public List<EmployeeInformationDTO> findBySalary(@RequestParam(name = "begin") Integer begin, 
											   @RequestParam(name = "end") Integer end) {
		List<Object[]> result = employeeService.findEmployeeBySalary(begin, end);
		List<EmployeeInformationDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/email")
	public List<EmployeeInformationDTO> findByEmail(@RequestParam(name = "email") String email) {
		List<Object[]> result = employeeService.findEmployeeByEmail(email);
		List<EmployeeInformationDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/phone_number")
	public List<EmployeeInformationDTO> findByPhone(@RequestParam(name = "number") String phone_number) {
		List<Object[]> result = employeeService.findEmployeeByPhone(phone_number);
		List<EmployeeInformationDTO> finall = convertObject(result);
		
		return finall;
	}
	
	@GetMapping(value = "/employee/street_address")
	public List<EmployeeInformationDTO> findByStreet(@RequestParam(name = "street") String street) {
		List<Object[]> result = employeeService.findEmployeeByStreet(street);
		List<EmployeeInformationDTO> finall = convertObject(result);
		
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
	
	public List<EmployeeInformationDTO> convertObject(List<Object[]> result) {
		List<EmployeeInformationDTO> finall = new ArrayList<EmployeeInformationDTO>();
		
		for(int i = 0; i < result.size(); i++) {
			EmployeeInformationDTO dto = new EmployeeInformationDTO();
			dto.setEmployee_id((Integer) result.get(i)[0]);
			dto.setFull_name((String) result.get(i)[1]);
			dto.setFirst_name((String) result.get(i)[2]);
			dto.setLast_name((String) result.get(i)[3]);
			dto.setDepartment_name((String) result.get(i)[4]);
			dto.setEmail((String) result.get(i)[5]);
			dto.setPhone_number((String) result.get(i)[6]);
			dto.setHire_date((String) result.get(i)[7]);
			dto.setSalary((Integer) result.get(i)[8]);
			dto.setJob_id((String) result.get(i)[9]);
			dto.setManager_id((Integer) result.get(i)[10]);
			dto.setCommission_pct((Integer) result.get(i)[11]);
			dto.setCity((String) result.get(i)[12]);
			dto.setStreet_address((String) result.get(i)[13]);
			
			finall.add(dto);
		}
		return finall;
	}
	
	public List<EmployeePlusDTO> convertObjectPlus(List<Object[]> result) {
		List<EmployeePlusDTO> finall = new ArrayList<EmployeePlusDTO>();
		
		for(int i = 0; i < result.size(); i++) {
			EmployeePlusDTO dto = new EmployeePlusDTO();
			dto.setEmployee_id((Integer) result.get(i)[0]);
			dto.setFirst_name((String) result.get(i)[1]);
			dto.setLast_name((String) result.get(i)[2]);
			dto.setDepartment_id((Integer) result.get(i)[3]);
			dto.setEmail((String) result.get(i)[4]);
			dto.setPhone_number((String) result.get(i)[5]);
			dto.setHire_date((String) result.get(i)[6]);
			dto.setSalary((Integer) result.get(i)[7]);
			dto.setJob_id((String) result.get(i)[8]);
			dto.setManager_id((Integer) result.get(i)[9]);
			dto.setCommission_pct((Integer) result.get(i)[10]);
			dto.setCity((String) result.get(i)[11]);
			dto.setStreet_address((String) result.get(i)[12]);
			
			finall.add(dto);
		}
		return finall;
	}
	
	@GetMapping("/")
	String hello() {
		return "Hello World";
	}
}
