package com.winning.woman.librerialatinoamericaapi.resources;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.winning.woman.librerialatinoamericaapi.models.Libros;
import com.winning.woman.librerialatinoamericaapi.repositories.LibrosRepository;

@RestController
@RequestMapping("/api")
public class LibrosResource {

	@Autowired
	private LibrosRepository libroRepository;

	@PostMapping("/libro")
	public ResponseEntity<Libros> guardarLibro(@RequestBody Libros libro) {
		try {
			Libros _libro = libroRepository.save(libro);
			return new ResponseEntity<>(_libro, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/libro")
	public ResponseEntity<List<Libros>> listaLibros() {
		try {
			List<Libros> libros = new ArrayList<Libros>();
			libroRepository.findAll().forEach(libros::add);
			if(libros.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(libros, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/libro/{id}")
	public ResponseEntity<Libros> listaUnicoLibro(@PathVariable(value = "id") long id) {
		Optional<Libros> librosData = libroRepository.findById(id);
		if(librosData.isPresent()) {
			return new ResponseEntity<>(librosData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/libro/{id}")
	public ResponseEntity<Libros> actualizacionLibro(@PathVariable("id") long id, @RequestBody Libros libro) {
		Optional<Libros> librosData = libroRepository.findById(id);

		if(librosData.isPresent()) {
			Libros _libro = librosData.get();
			_libro.setTitulo(libro.getTitulo());
			_libro.setAutor(libro.getAutor());
			_libro.setEstado(libro.getEstado());
			_libro.setNota(libro.getNota());
			_libro.setFechaAnadido(libro.getFechaAnadido());
			_libro.setFechaFinalizacion(libro.getFechaFinalizacion());
			return new ResponseEntity<>(libroRepository.save(_libro), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/libro/{id}")
	public ResponseEntity<HttpStatus> deletaLibro(@PathVariable(value="id") long id) {
		try {
			libroRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
