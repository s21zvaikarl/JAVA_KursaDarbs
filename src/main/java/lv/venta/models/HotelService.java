package lv.venta.models;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "service_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class HotelService {
	
	@Column(name = "Ids")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long ids;
	
	@Column(name = "ServiceType")
	@NotNull
    @Enumerated(EnumType.STRING)
    private HotelServiceType type;
    
	@Column(name = "price")
	@NotNull
	@Min(0)
    private Double price;
    
    @ManyToMany(mappedBy = "services")
    @ToString.Exclude
    private ArrayList<Guest> guests;

	public HotelService(@NotNull HotelServiceType type, @NotNull Double price) {
		super();
		this.type = type;
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}
    
    

}
