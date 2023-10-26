package Employee.Crud.Self.Sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;
import  java.util.List;
import java.util.Optional;

import Employee.Crud.Self.Sample.entity.Employee;
import Employee.Crud.Self.Sample.repository.EmployeeRepository;

@Service
public class EmplServiceImpl implements EmployeeService 
{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee)
	{
		// TODO Auto-generated method stub
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) 
	{
		// TODO Auto-generated method stub
	Optional<Employee> optinal=employeeRepository.findById(id);
	Employee employee=null;
	if (optinal.isPresent())
	{
		employee=optinal.get();
	}
	else 
	{
		throw new RuntimeException(" Employee id not found ");
	}
	return employee;
	}

	@Override
	public void deleteEmployeeById(long id) 
	{
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);
		
	}

	
	

	

	
	
	
	
  
}

