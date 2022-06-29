package es.sgv.FIA.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.google.gson.annotations.Expose;

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
	
	//@ToString.Exclude
	@OneToOne(fetch = FetchType.EAGER)
	private Escuderia escuderia;

	// Sobreescribo el metodo toString para que no me de StackOverFlow al mostrar la escuderia, termino mostrando unicamente el id y el nombre y así no la tengo que excluir del tostring
	@Override
	public String toString() {
		return "Trabajador [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + ", fechaNacimiento="
				+ fechaNacimiento + ", escuderia=" + escuderia.getId() + "/" + escuderia.getNombre() + "]";
	}
	
	

}
