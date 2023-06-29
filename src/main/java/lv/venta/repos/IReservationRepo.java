package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Reservation;

@Repository
public interface IReservationRepo extends CrudRepository<Reservation, Long>{

}
