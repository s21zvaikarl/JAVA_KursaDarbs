package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.HotelService;

public interface IHotelServiceRepo extends CrudRepository<HotelService, Long>{

}
