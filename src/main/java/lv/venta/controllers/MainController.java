package lv.venta.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.models.Employee;
import lv.venta.services.IEmployeeService;

@Controller
public class MainController {
	
	@Autowired 
	private IEmployeeService employeeService;
	
	@GetMapping("/employee/showAll")
	public String showAllEmployees(Model model) {
		ArrayList<Employee> employees = employeeService.selectAllEmployees();
		model.addAttribute("employees", employees);
		return "all-employees-page";
	}
}
