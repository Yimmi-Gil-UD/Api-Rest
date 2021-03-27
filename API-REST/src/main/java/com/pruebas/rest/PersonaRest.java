package com.pruebas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pruebas.model.Persona;

//import antlr.collections.List;
import java.util.List;
import com.pruebas.dao.PersonaDAO;

@RestController
@RequestMapping("Personas")
public class PersonaRest {


	@Autowired
	private PersonaDAO personaDAO;
	
	
	//Metodos HTTP
	
	// GET,Post,Delete,put--> 200, 500, 404 
	
	@PostMapping("/guardar") //localhost:8080/personas/guardar
	public String  guardar(@RequestBody Persona persona) {
		personaDAO.save(persona);
		
		
		return "Exito al insertar";
		
	}
	
	
	@GetMapping("/listar") //localhost:8080/Personas/listar  -- get --
	public List<Persona> Listar()
	{
		return personaDAO.findAll();
	}
	
	
	@DeleteMapping("/eliminar/{id}") ////localhost:8080/Personas/eliminar
	public void eliminar(@PathVariable("id") Integer id)
	{
		personaDAO.deleteById(id);
	} 
	
	@PutMapping("/actualizar")////localhost:8080/Personas/actualizar
	public void actualizar(@RequestBody Persona persona)
	{
		personaDAO.save(persona);
	}
	
	
	// metodo para sumar dos numeros
	// postman -- get-- localhost:8080/Personas/sumar?operando1=50&operando2=36
	@RequestMapping(
	value = "/sumar",
	method = RequestMethod.GET,
	params = {"operando1", "operando2"}
	)
	
		
	public Integer sumar(@RequestParam("operando1") Integer operando1,@RequestParam("operando2") Integer operando2) {
	return operando1 + operando2;
	}
	
	
	
}
