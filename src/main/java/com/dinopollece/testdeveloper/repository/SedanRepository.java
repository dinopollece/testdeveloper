/**
 * 
 */
package com.dinopollece.testdeveloper.repository;

import javax.transaction.Transactional;

import com.dinopollece.testdeveloper.model.Sedan;

/**
 * Repository en donde definimos las operaciones de base de datos para la clase
 * Sedan
 * 
 * @author Dino Pollece
 *
 */

@Transactional
public interface SedanRepository extends AutomovilBaseRepository<Sedan> {
}
