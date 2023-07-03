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
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "employee_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
	@Column(name = "Ide")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long ide;
    
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
    
	@Column(name = "Position")
	@NotNull
    @Enumerated(EnumType.STRING)
    private EmployeePosition positions;

	public Employee(@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z]+") String name,
			@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z]+") String surname,
			@NotNull EmployeePosition positions) {
		super();
		this.name = name;
		this.surname = surname;
		this.positions = positions;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		
			return surname;
		
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public EmployeePosition getPositions() {
		
			return positions;
		
	}

	public void setPositions(EmployeePosition positions) {
		this.positions = positions;
	}



	


	
    
}
