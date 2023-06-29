package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Review;

public interface IReviewRepo extends CrudRepository<Review, Long>{

}
