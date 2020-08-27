/**
 * 
 */
package com.dinopollece.testdeveloper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase que representa las opciones que podemos agregarle a un Automovil como
 * por ejemplo techo corredizo.
 * 
 * @author Dino Pollece
 *
 */
@Entity(name = "opcionales")
public class Opcional {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre", nullable = false)
	@Enumerated(EnumType.STRING)
	private OpcionalType nombre;

	@Column(name = "precio", nullable = false)
	private int precio;

	public Opcional() {
		// TODO Auto-generated constructor stub
	}

	public Opcional(OpcionalType nombre, int precio) {
		this.setNombre(nombre);
		this.setPrecio(precio);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OpcionalType getNombre() {
		return nombre;
	}

	public void setNombre(OpcionalType nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
