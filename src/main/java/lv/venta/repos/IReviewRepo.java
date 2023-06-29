package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Review;

@Repository
public interface IReviewRepo extends CrudRepository<Review, Long>{

	Review findByGuestId(long id);

	ArrayList<Review> findByRating(int rating);

	ArrayList<Review> findByCommentContainingIgnoreCase(String phrase);

}
