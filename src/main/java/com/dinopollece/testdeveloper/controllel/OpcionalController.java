/**
 * 
 */
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dinopollece.testdeveloper.model.Opcional;
import com.dinopollece.testdeveloper.model.OpcionalType;
import com.dinopollece.testdeveloper.service.OpcionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Dino Pollece
 *
 */
@RestController
@RequestMapping("opcional")
@Api(tags = "ocpional")
public class OpcionalController {

	@Autowired
	private OpcionalService opcionalService;

	/**
	 * Método para exponer la funcionalidad de crear un objeto Opcional
	 * 
	 * @param opcional
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	@ApiOperation(value = "Crear Opcional", notes = "Servicio para crear un objeto Opcional")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Opcional creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<Opcional> create(@RequestParam OpcionalType nombre, @RequestParam int precio)
			throws Exception {
		Opcional opcional = new Opcional(nombre, precio);
		return new ResponseEntity<Opcional>(this.opcionalService.create(opcional), HttpStatus.CREATED);
	}

	/**
	 * Método para exponer la funcionalidad de actualizar un objeto Opcional
	 * 
	 * @param id
	 * @param opcional
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{nombre}")
	@ApiOperation(value = "Actualizar Opcional", notes = "Servicio para actualizar un objeto Opcional")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Opcional actualizado correctamente"),
			@ApiResponse(code = 404, message = "Opcional no encontrado") })
	public ResponseEntity<Opcional> update(@PathVariable("nombre") OpcionalType nombre, @RequestParam int precio)
			throws Exception {
		Opcional opcional = this.opcionalService.retrieveByNombre(nombre);
		opcional.setPrecio(precio);

		return new ResponseEntity<Opcional>(this.opcionalService.update(opcional), HttpStatus.OK);
	}

	/**
	 * Método para exponer la funcionalidad de eliminar un objeto Opcional
	 * 
	 * @param id
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar Opcional", notes = "Servicio para eliminar un objeto Opcional")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Opcional eliminado con éxito"),
			@ApiResponse(code = 404, message = "Opcional no encontrado") })
	public void delete(@PathVariable("id") Long id) throws Exception {
		opcionalService.delete(id);
	}

	@GetMapping
	@ApiOperation(value = "Listar Opcionales", notes = "Servicio para listar los Opcionales")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Opcionales listados correctamente"),
			@ApiResponse(code = 400, message = "Solicitud inválida") })
	public List<Opcional> retrieveAll() {
		return this.opcionalService.retrieveAll();
	}

}
