package lv.venta.repos;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Reservation;

@Repository
public interface IReservationRepo extends CrudRepository<Reservation, Long>{

	ArrayList<Reservation> findByReservationDateStart(LocalDate date);
    ArrayList<Reservation> findByGuestNameOrSurname(String name);
}
