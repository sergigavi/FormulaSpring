package es.sgv.FIA.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity
public class Escuderia { //si una escuderia está en f1 y f2, estará dos veces, no será la misma como tal 
	
	@NonNull
	@Id
	@EqualsAndHashCode.Include
	private String id;
	
	private String nombre;
	
	private Categoria categoria;
	
	@OneToOne
	private Piloto pilotoOficial;
	
	@OneToOne
	private Piloto pilotoSecundario;
	
	@Singular
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEscuderia")
	private Set<Piloto> pilotosProbadores;
	
	@Singular
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idEscuderia")
	private Set<Trabajador> trabajadores;

}
