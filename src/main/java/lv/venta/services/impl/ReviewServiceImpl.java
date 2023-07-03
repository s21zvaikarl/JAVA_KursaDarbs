package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Guest;
import lv.venta.models.Review;
import lv.venta.repos.IReviewRepo;
import lv.venta.services.IReviewService;

@Service
public class ReviewServiceImpl implements IReviewService{
	
	@Autowired
	private IReviewRepo revRepo;
	
	@Override
	public Review findReviewByGuestId(long id) throws Exception {
		if(id > 0) {
			return revRepo.findByGuestIdg(id);
		}
		else throw new Exception("ID must be positive");
	}

	@Override
	public ArrayList<Review> selectReviewsByRating(int rating) throws Exception {
		if(rating > 0 && rating < 5) {
			return revRepo.findByRating(rating);
		}
		else throw new Exception("Rating must be 1-5");
	}

	@Override
	public ArrayList<Review> findReviewByPhrase(String phrase) {
		return revRepo.findByCommentContainingIgnoreCase(phrase); //containg mekles frazi, ignorecase uztaisis ka nav case sensitive
	}
	
	@Override
    public Review addReview(Guest guest, String comment, int rating) {
        Review review = new Review(guest, comment, rating);
        return revRepo.save(review);
    }

    @Override
    public Review updateReview(long id, String comment, int rating) {
        Review review = findReviewById(id);
        if (review != null) {
            review.setComment(comment);
            review.setRating(rating);
            return revRepo.save(review);
        }
        return null;
    }

    @Override
    public void deleteReview(long id) {
        revRepo.deleteById(id);
    }

    @Override
    public Review findReviewById(long id) {
        Optional<Review> optionalReview = revRepo.findById(id);
        return optionalReview.orElse(null);
    }

    @Override
    public ArrayList<Review> getAllReviews() {
        return (ArrayList<Review>) revRepo.findAll();
    }

}
