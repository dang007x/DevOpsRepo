package com.bootcamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bootcamp.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	@Query(value = "SELECT * FROM employee", nativeQuery = true)
	List<EmployeeEntity> getByName();
	
	@Query(value = "SELECT * FROM employee WHERE department_id = :id", nativeQuery = true)
	List<EmployeeEntity> findById(@Param("id") Integer id);
	
	@Query(value = "SELECT count(*) FROM employee WHERE department_id = :department_id", nativeQuery = true)
	Integer countEmployeeByDepartmentId(@Param("department_id") Integer department_id);
	
	@Query(value = "select e.employee_id, concat(e.first_name, \" \", e.last_name) as full_name, d.department_name, e.email, e.phone_number, e.hire_date, e.salary, e.job_id, d.manager_id, e.commission_pct, l.city, l.street_address " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id", nativeQuery = true)
	public List<Object[]> showDetailInfor();
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and e.employee_id = :employee_id", nativeQuery = true)
	public List<Object[]> findEmployeeById(@Param("employee_id") Integer employee_id);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and street_address = :street_address", nativeQuery = true)
	public List<Object[]> findEmployeeByStreet(@Param("street_address") String street_address);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and department_name = :department_name", nativeQuery = true)
	public List<Object[]> findEmployeeByDepartmentName(@Param("department_name") String department_name);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and first_name = :first_name and last_name = :last_name", nativeQuery = true)
	public List<Object[]> findEmployeeByName(@Param("first_name") String first_name, @Param("last_name") String last_name);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and first_name = :first_name", nativeQuery = true)
	public List<Object[]> findEmployeeByFirstName(@Param("first_name") String first_name);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and last_name = :last_name", nativeQuery = true)
	public List<Object[]> findEmployeeByLastName(@Param("last_name") String last_name);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and e.email like %" + ":email" + "%", nativeQuery = true)
	public List<Object[]> findEmployeeByEmail(@Param("email") String email);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and e.job_id = :job_id", nativeQuery = true)
	public List<Object[]> findEmployeeByJobId(@Param("job_id") String job_id);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and e.salary between :begin and :end", nativeQuery = true)
	public List<Object[]> findEmployeeBySalary(@Param("begin") Integer begin,@Param("end") Integer end);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and e.phone_number = :phone_number", nativeQuery = true)
	public List<Object[]> findEmployeeByPhone(@Param("phone_number") String phone_number);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and hire_date like  %" + ":hire_date" + "%", nativeQuery = true)
	public List<Object[]> findEmployeeByHireDate(@Param("hire_date") String hire_date);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id and city = :city", nativeQuery = true)
	public List<Object[]> findEmployeeByCity(@Param("city") String city);
	
	@Query(value = "select  e.employee_id, concat(first_name, \" \", last_name) as full_name,  e.email, d.department_id, d.department_name, e.salary " + 
			"from employee as e, department as d, locations as l " + 
			"where e.department_id = d.department_id and d.location_id = l.location_id", nativeQuery = true)
	public List<Object[]> findEmployeeByNothing();
}
