package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Employee;
import lv.venta.models.EmployeePosition;

public interface IEmployeeService {
	public ArrayList<Employee> selectAllEmployees();
	
	public ArrayList<Employee> findAllEmployeesByPosition(EmployeePosition position);
	
	public Employee findEmployeeById(long id) throws Exception;
	
	public void deleteEmployeeById(long id) throws Exception;
	
	public void addEmployeeById(long id, String name, String surname, EmployeePosition position) throws Exception;
	
	public void updateEmployeeById(long id, String name, String surname, EmployeePosition position) throws Exception;
}
