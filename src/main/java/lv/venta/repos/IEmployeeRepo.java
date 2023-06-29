package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Employee;

public interface IEmployeeRepo extends CrudRepository<Employee, Long> {

}
