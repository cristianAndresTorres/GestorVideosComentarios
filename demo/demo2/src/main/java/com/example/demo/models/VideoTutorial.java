package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Video_tutorial")
public class VideoTutorial {
	
	//Atributos de la clase
	@Id
	private Integer idvideotutorial;
	private String descripcion;
	private String titulo;
	private String fecha;
	public Integer getIdvideotutorial() {
		return idvideotutorial;
	}
	public void setIdvideotutorial(Integer idvideotutorial) {
		this.idvideotutorial = idvideotutorial;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

	
}
