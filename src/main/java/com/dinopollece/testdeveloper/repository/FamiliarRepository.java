/**
 * 
 */
package com.dinopollece.testdeveloper.repository;


import javax.transaction.Transactional;

import com.dinopollece.testdeveloper.model.Familiar;

/**
 * Repository en donde definimos las operaciones de base de datos para la clase
 * Opcional
 * 
 * @author Dino Pollece
 *
 */

@Transactional
public interface FamiliarRepository extends AutomovilBaseRepository<Familiar> {

}
