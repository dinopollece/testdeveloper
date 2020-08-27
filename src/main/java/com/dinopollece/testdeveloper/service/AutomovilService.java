/**
 * 
 */
package com.dinopollece.testdeveloper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dinopollece.testdeveloper.model.Automovil;
import com.dinopollece.testdeveloper.model.AutomovilType;
import com.dinopollece.testdeveloper.model.Coupe;
import com.dinopollece.testdeveloper.model.Familiar;
import com.dinopollece.testdeveloper.model.OpcionalType;
import com.dinopollece.testdeveloper.model.Sedan;
import com.dinopollece.testdeveloper.model.dto.StatAutomovilDTO;
import com.dinopollece.testdeveloper.model.dto.StatGeneralDTO;
import com.dinopollece.testdeveloper.model.dto.StatOpcionalDTO;
import com.dinopollece.testdeveloper.repository.AutomovilRepository;
import com.dinopollece.testdeveloper.repository.CoupeRepository;
import com.dinopollece.testdeveloper.repository.FamiliarRepository;
import com.dinopollece.testdeveloper.repository.SedanRepository;

/**
 * Clase en donde vamos a exponer todas las operaciones relacionada a los
 * Automoviles.
 * 
 * @author Dino Pollece
 *
 */
@Service
@Transactional(readOnly = true)
public class AutomovilService {

	@Autowired
	AutomovilRepository automovilRepository;
	@Autowired
	SedanRepository sedanRepository;
	@Autowired
	CoupeRepository coupeRepository;
	@Autowired
	FamiliarRepository familiarRepository;

	/**
	 * Método para realizar la operacion de alta de un Automovil. El switch evalua
	 * que Variante de Automovil es para saber que Repositorio tiene que utilizar.
	 * 
	 * @param automovil
	 * @return Automovil
	 * @throws Exception
	 */
	@Transactional
	public Automovil create(Automovil automovil) throws Exception {

		return save(automovil);
	}

	/**
	 * Método para realizar la operacion de actualizar un auto Sedan.
	 * 
	 * @param sedan
	 * @return Automovil
	 * @throws Exception
	 */
	@Transactional
	public Automovil update(Automovil automovil) throws Exception {
		if (!automovilRepository.existsById(automovil.getId())) {
			throw new Exception("Automovil no encontrado");
		}
		return save(automovil);
	}

	/**
	 * Metodo en comun que tienen los métodos create y update.
	 * 
	 * @param automovil
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Automovil save(Automovil automovil) throws Exception {
		switch (automovil.getVariante()) {
		case sedan:
			if (automovil instanceof Sedan) {
				return this.sedanRepository.save((Sedan) automovil);
			}
		case coupe:
			if (automovil instanceof Coupe) {
				return this.coupeRepository.save((Coupe) automovil);
			}
		case familiar:
			if (automovil instanceof Familiar) {
				return this.familiarRepository.save((Familiar) automovil);
			}
		default:
			throw new Exception("Repositorio no encontrado");
		}
	}

	/**
	 * Método para realizar la operación de eliminar un Automovil.
	 * 
	 * @param sedan
	 * @throws Exception
	 */
	@Transactional
	public boolean delete(Long id) throws Exception {
		Automovil automovil = this.automovilRepository.findById(id).get();
		if (automovil != null) {
			switch (automovil.getVariante()) {
			case sedan:
				this.sedanRepository.delete((Sedan) automovil);
				return true;
			case coupe:
				this.coupeRepository.delete((Coupe) automovil);
				return true;
			case familiar:
				this.familiarRepository.delete((Familiar) automovil);
				return true;
			default:
				throw new Exception("Repositorio no encontrado");
			}
		} else {
			throw new Exception("Automovil no encontrado");
		}

	}

	/**
	 * Método para realizar la operacion de listar todos los autos.
	 * 
	 * @return
	 */
	public List<Automovil> retrieveAll() {
		return this.automovilRepository.findAll();
	}

	/**
	 * Método para realizar la operación de listar los autos de la variante Sedan.
	 * 
	 * @return
	 */
	public List<Sedan> retrieveSedan() {
		return this.sedanRepository.findAll();
	}

	/**
	 * Método para realizar la operación de listar los autos de la variante Coupe.
	 * 
	 * @return
	 */
	public List<Coupe> retrieveCoupe() {
		return this.coupeRepository.findAll();
	}

	/**
	 * Método para realizar la operación de listar los autos de la variante
	 * Familiar.
	 * 
	 * @return
	 */
	public List<Familiar> retrieveFamiliar() {
		return this.familiarRepository.findAll();
	}

	/**
	 * Método para realizar la operación de listar y devolver un Auto por su ID.
	 * 
	 * @param id
	 * @return
	 */
	public Automovil findById(Long id) {
		return this.automovilRepository.findById(id).get();
	}

	/**
	 * Método para inicializar un tipo específico de Auto segun su variante.
	 * 
	 * @param variante
	 * @return
	 * @throws Exception
	 */
	public Automovil inicializarAutomovil(AutomovilType variante) throws Exception {
		switch (variante) {
		case sedan:
			return new Sedan();
		case coupe:
			return new Coupe();
		case familiar:
			return new Familiar();
		}
		throw new Exception("Variante no encontrada");
	}

	/**
	 * 
	 * Método que genera los Stats para mostrar.
	 * 
	 * @return
	 */
	public StatGeneralDTO stats() {
		int cantidadTotalAutos = this.automovilRepository.findAll().size();

		StatGeneralDTO statsGeneral = new StatGeneralDTO();
		List<StatAutomovilDTO> statsAutomoviles = this.inicializarListaStatsAuto(cantidadTotalAutos);
		List<StatOpcionalDTO> statsOpcionales = this.inicializarListaStatsOpcional(cantidadTotalAutos);

		statsGeneral.setCantidadAutos(cantidadTotalAutos);
		statsGeneral.setStatsAutomoviles(statsAutomoviles);
		statsGeneral.setStatsOpcionales(statsOpcionales);

		return statsGeneral;
	}

	/**
	 * Método para generar e inicializar la lista que muestra los Stats de los Autos
	 * por Variante
	 * 
	 * @param cantidadTotalAutos
	 * @return
	 */
	public List<StatAutomovilDTO> inicializarListaStatsAuto(int cantidadTotalAutos) {
		List<StatAutomovilDTO> statsAutomoviles = new ArrayList<StatAutomovilDTO>();
		int cantidadAutosPorVariable = 0;

		for (AutomovilType variante : AutomovilType.values()) {
			cantidadAutosPorVariable = this.automovilRepository.findByVariante(variante).size();

			StatAutomovilDTO automovilDTO = new StatAutomovilDTO();
			automovilDTO.setVariante(variante);
			automovilDTO.setCantidad(cantidadAutosPorVariable);
			automovilDTO.setPorcentaje((cantidadAutosPorVariable * 100) / cantidadTotalAutos);

			statsAutomoviles.add(automovilDTO);
		}

		return statsAutomoviles;
	}

	/**
	 * Método para generar e inicializar la lista que muestra los Stats de los
	 * Opcionales por Nombre.
	 * 
	 * @param cantidadTotalAutos
	 * @return
	 */
	public List<StatOpcionalDTO> inicializarListaStatsOpcional(int cantidadTotalAutos) {
		List<StatOpcionalDTO> statsOpcionales = new ArrayList<StatOpcionalDTO>();
		int cantidadAutosPorOpcional = 0;

		for (OpcionalType nombre : OpcionalType.values()) {
			cantidadAutosPorOpcional = this.automovilRepository.findByOpcionales_Nombre(nombre).size();

			StatOpcionalDTO statOpcionalDTO = new StatOpcionalDTO();
			statOpcionalDTO.setNombre(nombre);
			statOpcionalDTO.setCantidad(cantidadAutosPorOpcional);
			statOpcionalDTO.setPorcentaje((cantidadAutosPorOpcional * 100) / cantidadTotalAutos);

			statsOpcionales.add(statOpcionalDTO);
		}

		return statsOpcionales;
	}

}
