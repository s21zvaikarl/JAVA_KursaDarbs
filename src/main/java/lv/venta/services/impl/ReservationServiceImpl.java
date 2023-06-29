package lv.venta.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Reservation;
import lv.venta.repos.IReservationRepo;
import lv.venta.services.IReservationService;

@Service
public class ReservationServiceImpl implements IReservationService{
	
	@Autowired
	private IReservationRepo resRepo;
	
	@Override
	public ArrayList<Reservation> findAllReservationsToday() {
		LocalDate today = LocalDate.now();
        return new ArrayList<>(resRepo.findByReservationDateStart(today));
	}

	@Override
	public ArrayList<Reservation> findReservationByGuestNameOrSurname(String name) {
		return new ArrayList<>(resRepo.findByGuestNameOrSurname(name));
	}

}
