package com.winning.woman.librerialatinoamericaapi.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "tb_libros" )
public class Libros implements Serializable {

	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private long id;

	private String titulo;
	private String autor;
	private String fechaAnadido;
	private String fechaFinalizacion;
	private int nota;
	private String estado;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getFechaAnadido() {
		return fechaAnadido;
	}
	public void setFechaAnadido(String fechaAnadido) {
		this.fechaAnadido = fechaAnadido;
	}
	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}
	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
