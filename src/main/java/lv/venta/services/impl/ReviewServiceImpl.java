package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
