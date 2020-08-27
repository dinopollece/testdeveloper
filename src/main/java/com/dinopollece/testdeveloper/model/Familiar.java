/**
 * 
 */
package com.dinopollece.testdeveloper.model;

import javax.persistence.Entity;

/**
 * Clase que representa la variante Familiar de un Automovil.
 * 
 * @author Dino Pollece
 *
 */
@Entity(name = "familiares")
public class Familiar extends Automovil {

	private final static int PRECIO_BASE_FAMILIAR = 245000;

	@Override
	public Integer costoFinal() {
		int sumaOpcionales = 0;
		for (Opcional o : super.getOpcionales()) {
			sumaOpcionales += o.getPrecio();
		}
		return (PRECIO_BASE_FAMILIAR + sumaOpcionales);
	}

}
