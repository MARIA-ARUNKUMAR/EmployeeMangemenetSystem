package Employee.Crud.Self.Sample.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Employee.Crud.Self.Sample.entity.Employee;


public interface EmployeeService 
{
	  List<Employee> getAllEmployees();
	  void saveEmployee(Employee employee);
	  Employee getEmployeeById(long id);
	  void deleteEmployeeById(long id);
	}
