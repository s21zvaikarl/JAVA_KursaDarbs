package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.HotelService;

@Repository
public interface IHotelServiceRepo extends CrudRepository<HotelService, Long>{

}
