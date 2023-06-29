package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Guest;

@Repository
public interface IGuestRepo extends CrudRepository<Guest, Long> {

	Guest findByNameOrSurname(String name);

}
