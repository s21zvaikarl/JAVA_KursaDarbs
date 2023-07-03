package lv.venta.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

import lv.venta.models.Guest;
import lv.venta.models.HotelService;
import lv.venta.models.Room;

public interface IGuestService {
	public ArrayList<Guest> selectAllGuests();
	
	public Guest findGuestById(long id) throws Exception;
	
	public Guest findGuestByNameAndSurname(String name, String surname) throws Exception;
	
	public void deleteGuestById(long id) throws Exception;
	
	public void addGuestService(Guest guest, HotelService service);
	
	public void addGuest(String name, String surname, Boolean checkedIn, LocalDateTime CheckedInTime, LocalDateTime CheckedOutTime, Room room, Set<HotelService> services) throws Exception;
	
	public double calculateGuestServiceExpensesById(long id)throws Exception;
	
	public double calculateGuestTotalExpensesById(long id) throws Exception;

	public void updateGuestById(long id, String name, String surname, Boolean checkedIn, LocalDateTime CheckedInTime,
			LocalDateTime CheckedOutTime,  Room room,
			Set<HotelService> services) throws Exception;

	
}
