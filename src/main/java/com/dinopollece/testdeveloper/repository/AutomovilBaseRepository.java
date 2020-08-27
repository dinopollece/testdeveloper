/**
 * 
 */
package com.dinopollece.testdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.dinopollece.testdeveloper.model.Automovil;

/**
 * @author Dino Pollece
 *
 */
@NoRepositoryBean
public interface AutomovilBaseRepository<T extends Automovil> extends JpaRepository<T, Long> {
}
