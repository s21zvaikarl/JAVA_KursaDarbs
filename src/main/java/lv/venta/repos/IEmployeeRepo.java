package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Employee;
import lv.venta.models.EmployeePosition;

@Repository
public interface IEmployeeRepo extends CrudRepository<Employee, Long> {

	ArrayList<Employee> findAllByPositions(EmployeePosition position);

}
