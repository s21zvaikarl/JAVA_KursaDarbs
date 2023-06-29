package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Room;

@Repository
public interface IRoomRepo extends CrudRepository<Room, Long>{

}
