/**
 * 
 */
package com.dinopollece.testdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinopollece.testdeveloper.model.Opcional;
import com.dinopollece.testdeveloper.model.OpcionalType;

/**
 * Repository en donde definimos las operaciones de base de datos para la clase
 * Opcional
 * 
 * @author Dino Pollece
 *
 */
@Repository
public interface OpcionalRepository extends JpaRepository<Opcional, Long> {
	
	public Opcional findByNombre(OpcionalType nombre);
	public boolean existsByNombre(OpcionalType nombre);
}
