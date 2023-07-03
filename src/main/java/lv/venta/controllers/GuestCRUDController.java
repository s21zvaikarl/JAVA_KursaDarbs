package lv.venta.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lv.venta.models.Guest;
import lv.venta.services.IGuestService;

@Controller
public class GuestCRUDController {
	
	@Autowired 
	private IGuestService guestService;
	
	@GetMapping("/guest/showAll")
	public String showAllGuests(Model model) {
	    ArrayList<Guest> guests = guestService.selectAllGuests();
	    model.addAttribute("guests", guests);
	    return "all-guests-page";
	}

	@GetMapping("/guest/addNew")
	public String showAddGuestForm(Model model) {
	    model.addAttribute("guest", new Guest());
	    return "addFormGuest";
	}

	@PostMapping("/guest/addNew")
	public String addGuest(@ModelAttribute("guest") Guest guest) {
	    try {
	        guestService.addGuest(null, null, null, null, null, null, null);
	        return "redirect:/guest/showAll";
	    } catch (Exception e) {
	        return "error-page";
	    }
	}

	@GetMapping("/guest/update/{id}")
	public String showUpdateGuestForm(@PathVariable("id") long id, Model model) {
	    try {
	        Guest guest = guestService.findGuestById(id);
	        model.addAttribute("guest", guest);
	        return "updateFormGuest";
	    } catch (Exception e) {
	        return "error-page";
	    }
	}

	@PostMapping("/guest/update/{id}")
	public String updateGuest(@PathVariable("id") long id, @ModelAttribute("guest") Guest guest) {
	    try {
	        guestService.updateGuestById(id, guest.getName(), guest.getSurname(), guest.getCheckedIn(), guest.getCheckInTime(), guest.getCheckOutTime(), guest.getRoom(), guest.getServices());
	        return "redirect:/guest/showAll";
	    } catch (Exception e) {
	        return "error-page";
	    }
	}

	@GetMapping("/guest/remove/{id}")
	public String deleteGuest(@PathVariable("id") long id) {
	    try {
	        guestService.deleteGuestById(id);
	        return "redirect:/guest/showAll";
	    } catch (Exception e) {
	        return "error-page";
	    }
	}
}
