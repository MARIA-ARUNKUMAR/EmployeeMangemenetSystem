package Employee.Crud.Self.Sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Employee.Crud.Self.Sample.entity.Employee;
import Employee.Crud.Self.Sample.service.EmployeeService;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewIndexPage() 
	{
		return "index";
	}

	@GetMapping("/aboutus")
	public String getAboutUsPage() 
	{
		return "aboutus";
	}
	
	@GetMapping("/home")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "home";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee  , HttpSession session ) {
		// save employee to database
		employeeService.saveEmployee(employee);
		session.setAttribute("alertt", "Employee Added Successfully ..... ");
		return "redirect:/home";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id")long id,Model model) 
	{
		
		// get employee from service
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee.html";		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id")long id) 
	{
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/home";
	}
}
