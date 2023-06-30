package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "review_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Review {
	@Column(name = "Idrating")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idrating;
    
    @NotNull
    @ManyToOne
    private Guest guest;
    
    @Column(name = "Comment")
    private String comment;
    
    @Column(name = "Rating")
    @Min(1)
    @Max(5)
    private int rating;

	public Review(@NotNull Guest guest, String comment, @Min(1) @Max(5) int rating) {
		super();
		this.guest = guest;
		this.comment = comment;
		this.rating = rating;
	}
    
    
}
