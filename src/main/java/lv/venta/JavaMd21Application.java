package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
				
			}
			
		};
	}

}
