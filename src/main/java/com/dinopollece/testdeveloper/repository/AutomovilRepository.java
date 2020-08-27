/**
 * 
 */
package com.dinopollece.testdeveloper.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.dinopollece.testdeveloper.model.Automovil;
import com.dinopollece.testdeveloper.model.AutomovilType;
import com.dinopollece.testdeveloper.model.OpcionalType;

/**
 * Repository de la clase abstract Automovil, para no repetir los métodos base.
 * 
 * @author Dino Pollece
 *
 */

@Transactional
public interface AutomovilRepository extends AutomovilBaseRepository<Automovil> {
	
	List<Automovil> findByVariante(AutomovilType variante);
	List<Automovil> findByOpcionales_Nombre(OpcionalType nombre);

}
