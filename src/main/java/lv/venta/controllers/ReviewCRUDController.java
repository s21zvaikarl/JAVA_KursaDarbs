package lv.venta.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.models.Guest;
import lv.venta.models.Review;
import lv.venta.services.IGuestService;
import lv.venta.services.IReviewService;

@Controller
@RequestMapping("/review")
public class ReviewCRUDController {
	@Autowired
	private IReviewService reviewService;
	
	@Autowired
	private IGuestService guestService;
	
	@GetMapping("/showAll") // localhost:8080/review/showAll
    public String showAllReviews(Model model) {
        ArrayList<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "all-review-page";
    }
	
    @GetMapping("/addNew") // localhost:8080/review/addNew
    public String showAddReviewForm(Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("guests", guestService.selectAllGuests());
        return "addFormReview";
    }

    @PostMapping("/addNew")
    public String addReview(@ModelAttribute("review") Review review) {
        try {
            Guest guest = new Guest();
            reviewService.addReview(guest, review.getComment(), review.getRating());
            return "redirect:/review/showAll";
        } catch (Exception e) {
            return "error-page";
        }
    }

    

    @GetMapping("/update/{id}") // localhost:8080/review/update/1
    public String showUpdateReviewForm(@PathVariable("id") long id, Model model) {
        try {
            Review review = reviewService.findReviewById(id);
            if (review == null) {
                return "error-page";
            }
            model.addAttribute("review", review);
            model.addAttribute("guests", guestService.selectAllGuests());
            return "updateFormReview";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @PostMapping("/update/{id}")
    public String updateReview(@PathVariable("id") long id, @ModelAttribute("review") Review review) {
        try {
            Guest guest = guestService.findGuestById(review.getGuest().getIdg());
            if (guest == null) {
                return "error-page";
            }
            reviewService.updateReview(id, review.getComment(), review.getRating());
            return "redirect:/review/showAll";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/remove/{id}") // localhost:8080/review/delete/1
    public String deleteReview(@PathVariable("id") long id) {
        try {
            reviewService.deleteReview(id);
            return "redirect:/review/showAll";
        } catch (Exception e) {
            return "error-page";
        }
    }
}
