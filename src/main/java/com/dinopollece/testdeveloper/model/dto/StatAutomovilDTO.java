/**
 * 
 */
package com.dinopollece.testdeveloper.model.dto;

import com.dinopollece.testdeveloper.model.AutomovilType;

/**
 * @author Dino Pollece
 *
 */
public class StatAutomovilDTO {

	private AutomovilType variante;
	private int cantidad;
	private int porcentaje;

	public AutomovilType getVariante() {
		return variante;
	}

	public void setVariante(AutomovilType variante) {
		this.variante = variante;
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
