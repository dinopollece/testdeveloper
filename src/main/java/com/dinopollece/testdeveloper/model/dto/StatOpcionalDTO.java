/**
 * 
 */
package com.dinopollece.testdeveloper.model.dto;

import com.dinopollece.testdeveloper.model.OpcionalType;

/**
 * @author Dino Pollece
 *
 */
public class StatOpcionalDTO {

	private OpcionalType nombre;
	private int cantidad;
	private int porcentaje;

	public OpcionalType getNombre() {
		return nombre;
	}

	public void setNombre(OpcionalType nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

}
