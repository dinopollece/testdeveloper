package com.dinopollece.testdeveloper.controllel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dinopollece.testdeveloper.model.Automovil;
import com.dinopollece.testdeveloper.model.AutomovilType;
import com.dinopollece.testdeveloper.model.OpcionalType;
import com.dinopollece.testdeveloper.model.dto.StatGeneralDTO;
import com.dinopollece.testdeveloper.service.AutomovilService;
import com.dinopollece.testdeveloper.service.OpcionalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("automoviles")
@Api(tags = "automoviles")
public class AutomovilController {

	@Autowired
	AutomovilService automovilService;

	@Autowired
	OpcionalService opcionalService;

	@ApiOperation(value = "Crear un Automovil", notes = "Servicio para crear un Automovil")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Automovil creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud inválida") })
	@PostMapping
	public ResponseEntity<Automovil> create(@RequestParam AutomovilType variante,
			@RequestParam List<OpcionalType> nombresDeOpcionales) throws Exception {

		Automovil automovil = this.automovilService.inicializarAutomovil(variante);

		automovil.setOpcionales(this.opcionalService.armarListaOpcionales(nombresDeOpcionales));
		automovil.setVariante(variante);
		automovil.setPrecio(automovil.costoFinal());
		return new ResponseEntity<Automovil>(this.automovilService.create(automovil), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Actualizar un Automovil", notes = "Servicio para actualizar un Automovil")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Automovil actualizado correctamente"),
			@ApiResponse(code = 404, message = "Automovil no encontrado") })
	@PutMapping("/{id}")
	public ResponseEntity<Automovil> update(@PathVariable("id") Long id,
			@RequestParam List<OpcionalType> nombresDeOpcionales) throws Exception {

		Automovil automovil = this.automovilService.findById(id);
		automovil.setOpcionales(this.opcionalService.armarListaOpcionales(nombresDeOpcionales));
		automovil.setPrecio(automovil.costoFinal());
		return new ResponseEntity<Automovil>(this.automovilService.create(automovil), HttpStatus.OK);
	}

	@ApiOperation(value = "Eliminar un Automovil", notes = "Servicio para eliminar un Automovil")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Automovil eliminado correctamente"),
			@ApiResponse(code = 404, message = "Automovil no encontrado") })
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) throws Exception {
		this.automovilService.delete(id);
	}

	@ApiOperation(value = "Listar todos los Automoviles", notes = "Servicio para listar todos los Automoviles")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Automoviles listados correctamnente "),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	@GetMapping
	public List<Automovil> retrieve() {
		return this.automovilService.retrieveAll();
	}
	
	@ApiOperation(value = "Stats", notes = "Servicio para mostrar los stats de los Automoviles y Opcionales")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Stats generado correctamnente "),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	@GetMapping("/stats")
	public StatGeneralDTO stats() {
		return this.automovilService.stats();
	}
}