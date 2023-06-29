package lv.venta.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "guest_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Guest {
	@Column(name = "Idg")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idg;
    
	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	private String surname;
    
	@Column(name = "CheckedIn")
    @NotNull
    private Boolean checkedIn;
	
	@Column(name = "CheckInTime")
	@NotNull(message = "Date and time must be provided")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime CheckInTime;
	
	@Column(name = "CheckOutTime")
	@NotNull(message = "Date and time must be provided")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime CheckOutTime;
    
    @OneToMany(mappedBy = "guest")
    @ToString.Exclude
    private ArrayList<Reservation> reservations;
    
    @ManyToOne
    @JoinColumn(name = "Idro")
    private Room room;
    
    @ManyToMany
    @JoinColumn(name = "Ids")
    private ArrayList<HotelService> services;

	public Guest(@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z]+") String name,
			@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z]+") String surname,
			@NotNull Boolean checkedIn, @NotNull(message = "Date and time must be provided") LocalDateTime checkInTime,
			@NotNull(message = "Date and time must be provided") LocalDateTime checkOutTime,
			ArrayList<Reservation> reservations, Room room, ArrayList<HotelService> services) {
		super();
		this.name = name;
		this.surname = surname;
		this.checkedIn = checkedIn;
		CheckInTime = checkInTime;
		CheckOutTime = checkOutTime;
		this.reservations = reservations;
		this.room = room;
		this.services = services;
	} 
    
    
    
}
