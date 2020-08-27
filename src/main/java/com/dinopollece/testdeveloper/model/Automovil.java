/**
 * 
 */
package com.dinopollece.testdeveloper.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * Clase Padre que contiene los datos en comun entre los distintos modelos de
 * Autos. La herencia la vamos a manejar con la estrategia JOINED.
 * 
 * @author Dino Pollece
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "variante")
@JsonSubTypes({ @JsonSubTypes.Type(value = Sedan.class, name = "sedan"),
		@JsonSubTypes.Type(value = Coupe.class, name = "coupe"),
		@JsonSubTypes.Type(value = Familiar.class, name = "familiar") })
@Entity(name = "automoviles")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Automovil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "precio", nullable = false)
	private Integer precio;

	@Column(name = "variante", nullable = false)
	@Enumerated(EnumType.STRING)
	private AutomovilType variante;

	// JoinTable no es obligatorio pero al especificarlo, podemos definir el nombre
	// y la estructura como nosotros queremos.
	@JoinTable(name = "rel_automoviles_opcionales", joinColumns = @JoinColumn(name = "id_automovil", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_opcional", nullable = false))
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Opcional> opcionales;

	public Automovil() {
		// TODO Auto-generated constructor stub
	}

	@JsonIgnore
	public abstract Integer costoFinal();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public AutomovilType getVariante() {
		return variante;
	}

	public void setVariante(AutomovilType variante) {
		this.variante = variante;
	}

	public List<Opcional> getOpcionales() {
		return opcionales;
	}

	public void setOpcionales(List<Opcional> opcionales) {
		this.opcionales = opcionales;
	}
}
