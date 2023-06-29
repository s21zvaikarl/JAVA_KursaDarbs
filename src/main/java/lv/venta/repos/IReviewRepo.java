package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Review;

@Repository
public interface IReviewRepo extends CrudRepository<Review, Long>{

}
