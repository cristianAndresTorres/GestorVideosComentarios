package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comentario")
public class Comentario {
	//Atributos
	@Id
	private Integer idcomentario;
	private String descripcion;
	private String fecha;
	private String autor;
	private Integer fk_idvideotutorial;
	
	
	public Integer getIdcomentario() {
		return idcomentario;
	}
	public void setIdcomentario(Integer idcomentario) {
		this.idcomentario = idcomentario;
	}
	public Integer getFk_idvideotutorial() {
		return fk_idvideotutorial;
	}
	public void setFk_idvideotutorial(Integer fk_idvideotutorial) {
		this.fk_idvideotutorial = fk_idvideotutorial;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Comentario [idcomentario=" + idcomentario + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", autor=" + autor + ", fk_idvideotutorial=" + fk_idvideotutorial + "]";
	}
	
	
}
