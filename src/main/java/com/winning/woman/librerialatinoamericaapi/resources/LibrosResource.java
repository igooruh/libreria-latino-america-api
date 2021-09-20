package com.winning.woman.librerialatinoamericaapi.resources;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winning.woman.librerialatinoamericaapi.models.Libros;
import com.winning.woman.librerialatinoamericaapi.repositories.LibrosRepository;

@RestController
@RequestMapping("/api")
public class LibrosResource {

	LibrosRepository libroRepository;

	@PostMapping("/libro")
	public void guardarLibro(@RequestBody Libros libro) {
		libroRepository.save(libro);
	}

	@GetMapping("/libro")
	public List<Libros> listaLibros() {
		return libroRepository.findAll();
	}

	@GetMapping("/libro/{id}")
	public Libros listaUnicoLibro(@PathVariable(value = "id") long id) {
		return libroRepository.findById(id);
	}

	@PutMapping("/libro")
	public Libros actualizacionLibro(@RequestBody Libros libro) {
		return libroRepository.save(libro);
	}

	@DeleteMapping("/libro")
	public void deletaLibro(@RequestBody Libros libro) {
		libroRepository.delete(libro);
	}
}
