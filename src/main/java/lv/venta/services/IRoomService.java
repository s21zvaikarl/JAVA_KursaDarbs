package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Guest;
import lv.venta.models.Room;
import lv.venta.models.RoomType;

public interface IRoomService {
	
	ArrayList<Room> selectAllUnbookedRooms();
	
    ArrayList<Room> selectRoomByType(RoomType type);
    
    //ArrayList<Room> findRoomByGuest(Guest guest);
    
    ArrayList<Room> findRoomByPriceRange(double minPrice, double maxPrice) throws Exception;
    
    
}


