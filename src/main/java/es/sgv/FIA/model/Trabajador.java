package es.sgv.FIA.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity
public class Trabajador {
	
	@NonNull
	@Id
	@EqualsAndHashCode.Include
	private String id;
	
	private String nombre;
	
	private String cargo;
	
	private LocalDate fechaNacimiento;
	
	@OneToOne(fetch = FetchType.EAGER) // esto no se si tengo que ponerlo
	private Escuderia escuderia;

}
