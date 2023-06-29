package lv.venta.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lv.venta.models.Guest;
import lv.venta.models.HotelService;
import lv.venta.models.Reservation;
import lv.venta.models.Room;

public interface IGuestService {
	public ArrayList<Guest> selectAllGuests();
	
	public Guest findGuestByNameOrSurname(String name) throws Exception;
	
	public void deleteGuestById(long id) throws Exception;
	
	public void addGuestService(Guest guest, HotelService service);
	
	public void addGuest(String name, String surname, Boolean checkedIn, LocalDateTime CheckedInTime, LocalDateTime CheckedOutTime, ArrayList<Reservation> reservation, Room room, ArrayList<HotelService> services) throws Exception;
	
	public double calculateGuestServiceExpensesById(long id)throws Exception;
	
	public double calculateGuestTotalExpensesById(long id) throws Exception;
}
