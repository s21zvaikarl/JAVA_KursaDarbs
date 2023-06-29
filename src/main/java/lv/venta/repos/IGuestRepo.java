package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Guest;

public interface IGuestRepo extends CrudRepository<Guest, Long> {

}
