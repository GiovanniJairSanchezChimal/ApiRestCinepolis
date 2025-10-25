package com.mx.ApiRestCinepolis.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mx.ApiRestCinepolis.service.PeliculasSerImp;
import com.mx.ApiRestCinepolis.model.Peliculas;

@RestController
@RequestMapping(path = "api")
@CrossOrigin
public class PeliculasWebService {
	//RestController sirve para marcar como controlador de solicitudes
	//y tuiliza para crear webservices de tipo rest
	
	//RequestMapping se utiliza para asignar solicitudes web y poder tomar nuestra url
	//uri recurso o endpoint
	
	//@CrossOrigin sirve para la seguridad en nuestra aplicacion para que no sea bloqueada por el navegador
	
	@Autowired
	PeliculasSerImp peliculasSerImp;
	
	@GetMapping(path="show")
	public List<Peliculas>show(){
		return peliculasSerImp.show();
	}
	
	@PostMapping(path = "save")
	public ResponseEntity<?>save(@RequestBody Peliculas pelicula){
		try {
			boolean response = peliculasSerImp.save(pelicula);
			if(response==true)
				return new ResponseEntity<String>("El nombre de la pelicula ya existe", HttpStatus.OK);
			else
				return new ResponseEntity<Peliculas>(pelicula, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("Error al realizar el registro", HttpStatus.OK);
			
		}
	}
	
	@PostMapping(path = "searchId")
	public ResponseEntity<?>search(@RequestBody Peliculas pelicula){
		Peliculas findPeli = peliculasSerImp.search(pelicula.getId());
		if(findPeli == null)
			return new ResponseEntity<String>("No se encontro el registro", HttpStatus.OK);
		else
			return new ResponseEntity<Peliculas>(findPeli, HttpStatus.CREATED);
	}
	
	
	@PutMapping(path="edit")
	public ResponseEntity<?>edit(@RequestBody Peliculas pelicula){
		try {
			boolean response = peliculasSerImp.edit(pelicula);
			if(response == false)
				return new ResponseEntity<String>("No existe el registro", HttpStatus.OK);
			else
				return new ResponseEntity<Peliculas>(pelicula, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("Error al editar el registro", HttpStatus.OK);
		}
	}
	
	@PostMapping(path="delete")
	public ResponseEntity<String>delete(@RequestBody Peliculas pelicula){
		try {
			boolean response = peliculasSerImp.delete(pelicula.getId());
			if(response == false)
				return new ResponseEntity<String>("No existe el registro", HttpStatus.OK);
			else
				return new ResponseEntity<String>("Se elimino con exito", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Error al eliminar el registro"+e.getMessage(), HttpStatus.OK);
		}
	}
	
}
