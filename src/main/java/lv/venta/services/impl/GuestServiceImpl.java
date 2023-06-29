package lv.venta.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Guest;
import lv.venta.models.HotelService;
import lv.venta.models.Reservation;
import lv.venta.models.Room;
import lv.venta.repos.IGuestRepo;
import lv.venta.services.IGuestService;

@Service
public class GuestServiceImpl implements IGuestService {
	@Autowired
	private IGuestRepo guestRepo;

	@Override
	public ArrayList<Guest> selectAllGuests() {
		return (ArrayList<Guest>) guestRepo.findAll();
	}

	@Override
	public Guest findGuestByNameOrSurname(String name) throws Exception {
		return guestRepo.findByNameOrSurname(name);
	}

	@Override
	public void deleteGuestById(long id) throws Exception {
		if(id > 0) {
			if(guestRepo.existsById(id)) {
				guestRepo.deleteById(id);
			}
			else {
				throw new Exception("No guest with this ID");
			}
		}
		else throw new Exception("ID must be positive");
		
	}

	@Override
	public void addGuest(String name, String surname, Boolean checkedIn, LocalDateTime CheckedInTime,
			LocalDateTime CheckedOutTime, ArrayList<Reservation> reservation, Room room,
			ArrayList<HotelService> services){
		Guest newGuest = new Guest(name, surname, checkedIn, CheckedInTime, CheckedOutTime, reservation, room, services);
		guestRepo.save(newGuest);
	}

	@Override
	public double calculateGuestServiceExpensesById(long id) throws Exception {
		Guest guest = guestRepo.findById(id).orElse(null);
        if (guest != null) {
            ArrayList<HotelService> services = guest.getServices();
            double totalExpenses = 0.0;
            for (HotelService service : services) {
                totalExpenses += service.getPrice();
            }
            return totalExpenses;
        }
        else throw new Exception("No Guest with this ID");
	}
	
}
