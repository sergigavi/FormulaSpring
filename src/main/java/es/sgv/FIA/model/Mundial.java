package es.sgv.FIA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity
public class Mundial {
	
	@Id
	@NonNull
	@EqualsAndHashCode.Include
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private int anno;
	
	private Categoria categoria;

}
