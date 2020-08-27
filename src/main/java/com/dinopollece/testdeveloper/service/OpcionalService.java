/**
 * 
 */
package com.dinopollece.testdeveloper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dinopollece.testdeveloper.model.Opcional;
import com.dinopollece.testdeveloper.model.OpcionalType;
import com.dinopollece.testdeveloper.repository.OpcionalRepository;

/**
 * @author Dino Pollece
 *
 */
@Service
@Transactional(readOnly = true)
public class OpcionalService {

	@Autowired
	OpcionalRepository opcionalRepository;

	/**
	 * Método para realizar la operacion de crear un Opcional.
	 * 
	 * @param opcional
	 * @return
	 */
	@Transactional
	public Opcional create(Opcional opcional) throws Exception {
		if (this.opcionalRepository.existsByNombre(opcional.getNombre())) {
			throw new Exception("El opcional ya existe");
		}
		return opcionalRepository.save(opcional);
	}

	/**
	 * Método para realizar la operacion de actualizar un Opcional.
	 * 
	 * @param opcional
	 * @return
	 */
	@Transactional
	public Opcional update(Opcional opcional) throws Exception {
		if (!this.opcionalRepository.existsByNombre(opcional.getNombre())) {
			throw new Exception("El opcional no existe");
		}
		return opcionalRepository.save(opcional);
	}

	/**
	 * Método para realizar la operacion de eliminar un Opcional.
	 * 
	 * @param opcional
	 */
	@Transactional
	public boolean delete(Long id) throws Exception {
		Opcional opcional = this.opcionalRepository.findById(id).get();
		if (opcional == null) {
			throw new Exception("El opcional no existe");
		}
		opcionalRepository.delete(opcional);
		return true;
	}

	/**
	 * Método para realizar la operacion de listar y devolver un Opcional.
	 * 
	 * @return
	 */
	public List<Opcional> retrieveAll() {
		return opcionalRepository.findAll();
	}

	/**
	 * Método para realizar la operacion de listar y devolver un Opcional por su ID.
	 * 
	 * @param id
	 * @return
	 */
	public Opcional retrieveById(Long id) {
		return this.opcionalRepository.findById(id).get();
	}

	/**
	 * Método para realizar la operación de listar y devolver un Opcional por su
	 * nombre.
	 * 
	 * @param nombre
	 * @return
	 */
	public Opcional retrieveByNombre(OpcionalType nombre) {
		return this.opcionalRepository.findByNombre(nombre);
	}

	/**
	 * Método para armar una lista de objetos Opcional mediante los nombres de los
	 * opcionales para un Automovil.
	 * 
	 * @param nombresDeOpcionales
	 * @return
	 */
	public List<Opcional> armarListaOpcionales(List<OpcionalType> nombresDeOpcionales) {

		List<Opcional> opcionales = new ArrayList<Opcional>();
		for (OpcionalType ot : nombresDeOpcionales) {
			Opcional opcional = this.retrieveByNombre(ot);
			opcionales.add(opcional);
		}
		return opcionales;
	}
}
