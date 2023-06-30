package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Guest;
import lv.venta.models.Room;
import lv.venta.models.RoomType;

@Repository
public interface IRoomRepo extends CrudRepository<Room, Long>{

	ArrayList<Room> findByIsBookedFalse();

	ArrayList<Room> findByType(RoomType type);

	ArrayList<Room> findByPriceBetween(double minPrice, double maxPrice);

	//ArrayList<Room> findByRoomGuest(Guest guest);

}
