package lv.venta;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Employee;
import lv.venta.models.EmployeePosition;
import lv.venta.models.Guest;
import lv.venta.models.HotelService;
import lv.venta.models.HotelServiceType;
import lv.venta.models.Reservation;
import lv.venta.models.Review;
import lv.venta.models.Room;
import lv.venta.models.RoomType;
import lv.venta.repos.IEmployeeRepo;
import lv.venta.repos.IGuestRepo;
import lv.venta.repos.IHotelServiceRepo;
import lv.venta.repos.IReservationRepo;
import lv.venta.repos.IReviewRepo;
import lv.venta.repos.IRoomRepo;

@SpringBootApplication
public class JavaMd21Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaMd21Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testModel(IEmployeeRepo empRepo, IGuestRepo gueRepo, IHotelServiceRepo hsRepo, IReservationRepo resRepo, IReviewRepo revRepo, IRoomRepo roomRepo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				
				System.out.println("Running testModel method...");
				
				Employee e1 = new Employee("Janis", "Berzins", EmployeePosition.bartender);
				Employee e2 = new Employee("Ivars", "Eglitis", EmployeePosition.chef);
				Employee e3 = new Employee("Aivars", "Melnalksnitis", EmployeePosition.concierge);
				Employee e4 = new Employee("Maija", "Meija", EmployeePosition.housekeeper);
				Employee e5 = new Employee("Julija", "Goba", EmployeePosition.housekeeper);
				Employee e6 = new Employee("Augusta", "Priede", EmployeePosition.hr);
				Employee e7 = new Employee("Septembre", "Ozola", EmployeePosition.lifeguard);
				Employee e8 = new Employee("Oktobra", "Eikalipte", EmployeePosition.manager);
				Employee e9 = new Employee("Novembrijs", "Bambuss", EmployeePosition.massager);
				Employee e10 = new Employee("Decembris", "Osis", EmployeePosition.receptionist);
				Employee e11 = new Employee("Ieva", "Baltalksne", EmployeePosition.security);
				
				empRepo.save(e1);
				empRepo.save(e2);
				empRepo.save(e3);
				empRepo.save(e4);
				empRepo.save(e5);
				empRepo.save(e6);
				empRepo.save(e7);
				empRepo.save(e8);
				empRepo.save(e9);
				empRepo.save(e10);
				empRepo.save(e11);
				
				Room room1 = new Room(201, RoomType.single, 45.0, true);
				Room room2 = new Room(202, RoomType.single, 45.0, false);
				Room room3 = new Room(301, RoomType.doubleEco, 70.0, true);
				Room room4 = new Room(302, RoomType.doubleEco, 70.0, false);
				Room room5 = new Room(401, RoomType.doubleLux, 105.0, true);
				Room room6 = new Room(402, RoomType.presidental, 205.0, false);
				roomRepo.save(room1);
				roomRepo.save(room2);
				roomRepo.save(room3);
				roomRepo.save(room4);
				roomRepo.save(room5);
				roomRepo.save(room6);

				
				HotelService hs1 = new HotelService(HotelServiceType.gym, 20.0);
				HotelService hs2 = new HotelService(HotelServiceType.pool, 8.0);
				HotelService hs3 = new HotelService(HotelServiceType.roomservice, 15.0);
				HotelService hs4 = new HotelService(HotelServiceType.spa, 30.0);
				hsRepo.save(hs1);
				hsRepo.save(hs2);
				hsRepo.save(hs3);
				hsRepo.save(hs4);
				
				
				Guest g1 = new Guest("Pauline", "Eidina", false, null, null, room1, null);
				Guest g2 = new Guest("Klaudijs", "Feldmanis",true, LocalDateTime.of(2023, 5, 30, 13, 5), LocalDateTime.of(2023, 6, 30, 13, 5), room2, null);
				Guest g3 = new Guest("Simona", "Duka", true, LocalDateTime.of(2023, 3, 30, 13, 5), LocalDateTime.of(2023, 4, 15, 13, 5), room3, null);
				Guest g4 = new Guest("Almants", "Tucins", true, LocalDateTime.of(2023, 4, 20, 13, 5), LocalDateTime.of(2023, 4, 30, 13, 5), room4, null);
				Guest g5 = new Guest("Peteris", "Paeglitis", false, null, null, room5, null);
				Guest g6 = new Guest("Lita", "Eidina", false, null, null, room6, null);
				Guest g7 = new Guest("Zanete", "Uzavniece", true, LocalDateTime.of(2023, 5, 30, 13, 5), LocalDateTime.of(2023, 5, 31, 13, 5), room1, null);
				Guest g8 = new Guest("Gudrite", "Veckalna", true, LocalDateTime.of(2023, 3, 30, 13, 5), LocalDateTime.of(2023, 4, 30, 13, 5), room2, null);
				gueRepo.save(g1);
				gueRepo.save(g2);
				gueRepo.save(g3);
				gueRepo.save(g4);
				gueRepo.save(g5);
				gueRepo.save(g6);
				gueRepo.save(g7);
				gueRepo.save(g8);
				
				
				Reservation res1 = new Reservation(LocalDate.of(2023, 7, 4), LocalDate.of(2023, 7, 8) , g1, room1);
				Reservation res2 = new Reservation(LocalDate.of(2023, 5, 30), LocalDate.of(2023, 6, 30) , g2, room2);
				Reservation res3 = new Reservation(LocalDate.of(2023, 6, 30), LocalDate.of(2023, 7, 4) , g3, room3);
				Reservation res4 = new Reservation(LocalDate.of(2023, 4, 4), LocalDate.of(2023, 5, 2) , g4, room4);
				Reservation res5 = new Reservation(LocalDate.of(2023, 8, 20), LocalDate.of(2023, 8, 21) , g5, room5);
				Reservation res6 = new Reservation(LocalDate.of(2023, 9, 3), LocalDate.of(2023, 9, 10) , g6, room6);
				Reservation res7 = new Reservation(LocalDate.of(2023, 5, 15), LocalDate.of(2023, 5, 20) , g7, room1);
				Reservation res8 = new Reservation(LocalDate.of(2023, 5, 20), LocalDate.of(2023, 5, 25) , g8, room2);
				resRepo.save(res1);
				resRepo.save(res2);
				resRepo.save(res3);
				resRepo.save(res4);
				resRepo.save(res5);
				resRepo.save(res6);
				resRepo.save(res7);
				resRepo.save(res8);
				
				Review rev1 = new Review(g3, "Skaists skats pa logu un draudzigi darbinieki", 5);
				Review rev2 = new Review(g4, "Briesmiga pieredze!!!! Vairs nekad neatgriezisos!!!", 1);
				revRepo.save(rev1);
				revRepo.save(rev2);
				
			}
			
		};
	}

}
