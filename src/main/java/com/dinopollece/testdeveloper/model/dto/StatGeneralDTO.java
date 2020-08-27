/**
 * 
 */
package com.dinopollece.testdeveloper.model.dto;

import java.util.List;

/**
 * @author Dino Pollece
 *
 */
public class StatGeneralDTO {

	private int cantidadAutos;
	private List<StatAutomovilDTO> statsAutomoviles;
	private List<StatOpcionalDTO> statsOpcionales;

	public int getCantidadAutos() {
		return cantidadAutos;
	}

	public void setCantidadAutos(int cantidadAutos) {
		this.cantidadAutos = cantidadAutos;
	}

	public List<StatAutomovilDTO> getStatsAutomoviles() {
		return statsAutomoviles;
	}

	public void setStatsAutomoviles(List<StatAutomovilDTO> statsAutomoviles) {
		this.statsAutomoviles = statsAutomoviles;
	}

	public List<StatOpcionalDTO> getStatsOpcionales() {
		return statsOpcionales;
	}

	public void setStatsOpcionales(List<StatOpcionalDTO> statsOpcionales) {
		this.statsOpcionales = statsOpcionales;
	}

}
