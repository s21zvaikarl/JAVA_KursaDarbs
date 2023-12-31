package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "room_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Room {
	
	@Column(name = "Idro")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idro;
	
	@Column(name = "Number")
    private int number;
    
	@Column(name = "Type")
    @Enumerated(EnumType.STRING)
    private RoomType type;
    
	@Column(name = "Price")
    @NotNull
    private Double price;
    
	@Column(name = "isBooked")
    private boolean isBooked;

	public Room(int number, RoomType type, @NotNull Double price, boolean isBooked) {
		super();
		this.number = number;
		this.type = type;
		this.price = price;
		this.isBooked = isBooked;
	}

	public Double getPrice() {
		return price;
	}
	
	
	
}
