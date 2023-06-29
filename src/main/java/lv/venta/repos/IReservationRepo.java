package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Reservation;

public interface IReservationRepo extends CrudRepository<Reservation, Long>{

}
