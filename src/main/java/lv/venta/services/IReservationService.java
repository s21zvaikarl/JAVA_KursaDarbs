package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Reservation;

public interface IReservationService {
	public ArrayList<Reservation> findAllReservationsToday();
	
	public ArrayList<Reservation> findReservationByGuestNameOrSurname(String name);
}
