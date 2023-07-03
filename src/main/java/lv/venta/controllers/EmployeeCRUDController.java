package lv.venta.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lv.venta.models.Employee;
import lv.venta.models.EmployeePosition;
import lv.venta.services.IEmployeeService;

@Controller
public class EmployeeCRUDController {
	
	@Autowired 
	private IEmployeeService employeeService;
	
	@GetMapping("/employee/showAll")//localhost:8080/employee/showAll
	public String showAllEmployees(Model model) {
		ArrayList<Employee> employees = employeeService.selectAllEmployees();
		model.addAttribute("employees", employees);
		return "all-employees-page";
	}
	
	@GetMapping("/employee/remove/{id}")//localhost:8080/employee/remove/1
    public String removeEmployeeById(@PathVariable("id") long id) {
        try {
            employeeService.deleteEmployeeById(id);
            return "redirect:/employee/showAll";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/employee/addNew")//localhost:8080/employee/addNew
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee(null, null, null));
        model.addAttribute("employeePosition", EmployeePosition.values());
        return "addFormEmployee";
    }

    @PostMapping("/employee/addNew")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        try {
            employeeService.addEmployee(employee.getName(), employee.getSurname(), employee.getPositions());
            return "redirect:/employee/showAll";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/employee/update/{id}")//localhost:8080/employee/update/1
    public String showUpdateEmployeeForm(@PathVariable("id") long id, Model model) {
        try {
            Employee employee = employeeService.findEmployeeById(id);
            model.addAttribute("employee", employee);
            model.addAttribute("employeePosition", EmployeePosition.values());
            return "updateFormEmployee";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @PostMapping("/employee/update/{id}")
    public String updateDriver(@PathVariable("id") long id, @ModelAttribute("employee") Employee employee) {
        try {
            employeeService.updateEmployeeById(id, employee.getName(), employee.getSurname(), employee.getPositions());
            return "redirect:/employee/showAll";
        } catch (Exception e) {
            return "error-page";
        }
    }
    
    @GetMapping("/error") //localhost:8080/error
	public String getErrorFunc(Model model) {
		model.addAttribute("packetError", "Wrong id");
		return "error-page";//will call error-page.html
	}
}
