package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Guest;
import lv.venta.models.Review;

public interface IReviewService {
	
	
	public Review findReviewByGuestId(long id) throws Exception;
	
	public ArrayList<Review> selectReviewsByRating (int rating)throws Exception;
	
	public ArrayList<Review> findReviewByPhrase(String phrase); //no Comment string var meklet frazi
	
	ArrayList<Review> getAllReviews();
	
	Review addReview(Guest guest, String comment, int rating);
	
    Review updateReview(long id, String comment, int rating);
    
    void deleteReview(long id);

	Review findReviewById(long id);
}
