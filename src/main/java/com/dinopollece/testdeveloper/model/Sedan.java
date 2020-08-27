/**
 * 
 */
package com.dinopollece.testdeveloper.model;

import javax.persistence.Entity;

/**
 * Clase que representa la variante Sedan de un Automovil.
 * 
 * @author Dino Pollece
 *
 */
@Entity(name = "sedanes")
public class Sedan extends Automovil {

	private final static int PRECIO_BASE_SEDAN = 230000;

	@Override
	public Integer costoFinal() {
		int sumaOpcionales = 0;
		for (Opcional o : super.getOpcionales()) {
			sumaOpcionales += o.getPrecio();
		}
		return (PRECIO_BASE_SEDAN + sumaOpcionales);
	}

}
