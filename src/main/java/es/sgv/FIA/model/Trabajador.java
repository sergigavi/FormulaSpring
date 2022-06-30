package es.sgv.FIA.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

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
	
	@ToString.Exclude
	@JsonIgnore //asi no me lo pinta en el json y no tengo stackoverflow ya que cada escuderia me pinta ya los trabajadores
	@OneToOne(fetch = FetchType.EAGER)
	private Escuderia escuderia;

	// Sobreescribo el metodo toString para que no me de StackOverFlow al mostrar la escuderia, termino mostrando unicamente el id y el nombre y así no la tengo que excluir del tostring
	/*@Override
	public String toString() {
		return "Trabajador [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + ", fechaNacimiento="
				+ fechaNacimiento + ", escuderia=" + escuderia.getId() + "/" + escuderia.getNombre() + "]";
	}*/
	
	//hago el fromString para que a la hora de pasarle el adapter me meta correctamente la escuderia
	
	

}
