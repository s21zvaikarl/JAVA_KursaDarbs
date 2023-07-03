package lv.venta.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "reservation_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reservation {
	@Column(name = "Idre")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idre;
	
	@Column(name = "ReservationDateStart")
	@NotNull(message = "Date must be provided")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate reservationDateStart;
	
	@Column(name = "ReservationDateEnd")
	@NotNull(message = "Date must be provided")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate reservationDateEnd;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "Idro")
    private Room room;

	public Reservation(@NotNull(message = "Date must be provided") LocalDate resDateStart,
			@NotNull(message = "Date must be provided") LocalDate resDateEnd, @NotNull Room room) {
		super();
		reservationDateStart = resDateStart;
		reservationDateEnd = resDateEnd;
		this.room = room;
	}
    
    
}
