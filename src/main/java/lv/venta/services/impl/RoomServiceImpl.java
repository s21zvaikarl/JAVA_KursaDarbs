package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Guest;
import lv.venta.models.Room;
import lv.venta.models.RoomType;
import lv.venta.repos.IRoomRepo;
import lv.venta.services.IRoomService;

@Service
public class RoomServiceImpl implements IRoomService {
	
	@Autowired
	private IRoomRepo roomRepo;
	
	@Override
	public ArrayList<Room> selectAllUnbookedRooms() {
		return roomRepo.findByIsBookedFalse();
	}

	@Override
	public ArrayList<Room> selectRoomByType(RoomType type) {
		return roomRepo.findByType(type);
	}
	/*
	@Override
	public ArrayList<Room> findRoomByGuest(Guest guest) {
		return roomRepo.findByRoomGuest(guest);
	}
	*/

	@Override
	public ArrayList<Room> findRoomByPriceRange(double minPrice, double maxPrice) throws Exception {
		if(minPrice > 0 && maxPrice > 0 && minPrice<maxPrice) {
			return roomRepo.findByPriceBetween(minPrice, maxPrice);
		}
		else throw new Exception("Price must be positive and/or max price should be greater than min price");
	}

}
