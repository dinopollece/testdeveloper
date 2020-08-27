/**
 * 
 */
package com.dinopollece.testdeveloper.model;

import javax.persistence.Entity;

/**
 * Clase que representa la variante Coupe del modelo de un Automovil.
 * 
 * @author Dino Pollece
 *
 */
@Entity(name = "coupes")
public class Coupe extends Automovil {

	private final static int PRECIO_BASE_COUPE = 270000;

	@Override
	public Integer costoFinal() {
		int sumaOpcionales = 0;
		for (Opcional o : super.getOpcionales()) {
			sumaOpcionales += o.getPrecio();
		}
		return (PRECIO_BASE_COUPE + sumaOpcionales);
	}
}
