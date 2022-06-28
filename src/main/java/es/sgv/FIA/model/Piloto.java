package es.sgv.FIA.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class Piloto {
	
	@NonNull
	@Id
	@EqualsAndHashCode.Include
	private String id; //FA14 LH44
	
	private String nombre;
	
	private int dorsal;
	
	private LocalDate fechaNacimiento;
	
	@OneToMany
	@JoinColumn(name = "idPiloto")
	private Set<Mundial> mundiales; //año categoria
	
	
	/*
	 * he pensado en poner tambien temporada, circuitos, carreras, victorias y tal y poder tener guardadas todas las carreras
	 *  con la victoria de cada piloto, la escuderia en la que estaba y todo eso
	 */

}
