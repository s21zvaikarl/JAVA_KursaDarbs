package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Employee;
import lv.venta.models.EmployeePosition;
import lv.venta.repos.IEmployeeRepo;
import lv.venta.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepo employeeRepo;

	@Override
	public ArrayList<Employee> selectAllEmployees() {
		return (ArrayList<Employee>) employeeRepo.findAll();
	}

	@Override
	public ArrayList<Employee> findAllEmployeesByPosition(EmployeePosition position) {
		return (ArrayList<Employee>) employeeRepo.findAllByPositions(position);
	}

	@Override
	public Employee findEmployeeById(long id) throws Exception {
		if(id > 0) {
			if(employeeRepo.existsById(id)) {
				Employee temp = employeeRepo.findById(id).get();
				return temp;
			}
			else {
				throw new Exception("No employee with this ID");
			}
		}
		else {
			throw new Exception("Wrong ID");
		}
	}

	@Override
	public void deleteEmployeeById(long id) throws Exception {
		if(id > 0) {
			if(employeeRepo.existsById(id)) {
				employeeRepo.deleteById(id);
			}
			else {
				throw new Exception("No employee with this ID");
			}
		}
		else throw new Exception("ID must be positive");
	}

	@Override
	public void addEmployeeById(long id, String name, String surname, EmployeePosition position) throws Exception {
		if(id > 0) {
			Employee newEmployee = new Employee(name, surname, position);
			employeeRepo.save(newEmployee);
		}
		else throw new Exception("ID must be positive");
	}

	@Override
	public void updateEmployeeById(long id, String name, String surname, EmployeePosition position) throws Exception {
		if(id > 0) {
			if(employeeRepo.existsById(id)) {
				Employee temp = employeeRepo.findById(id).get();
				temp.setName(name);
				temp.setSurname(surname);
				temp.setPositions(position);
				employeeRepo.save(temp);
			}
			else throw new Exception("Employee not found");
		}
		else throw new Exception("ID must be positive");
	}
	
	 
}
