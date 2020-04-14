package nl.hicts.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
	@Getter
	@Setter
	@Column(name = "date")
	private LocalDate date;
	@Getter
	@Setter
	@Column(name = "description")
	private String description;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
}
