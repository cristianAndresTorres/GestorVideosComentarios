package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Comentario;
import com.example.demo.models.VideoTutorial;
import com.example.demo.repositories.ComentarioRepositorio;
import com.example.demo.repositories.VideoTutorialRepositorio;

@Service
public class ComentarioServicio {
	@Autowired
	private ComentarioRepositorio comentarioRepositorio;
	
	//Retorna una lista de todos los videos
	public ArrayList<Comentario> obtenerComentario(){
		return (ArrayList<Comentario>) comentarioRepositorio.findAll();
	}
	
	//Retorna una lista de todos los comentarios
	public ArrayList<Comentario> obtenerListaComentario(){
		return (ArrayList<Comentario>) comentarioRepositorio.findAll();
	}
	//Modificar un comentario
	//Permite guardar un video tutorial
	public Comentario modificarComentario(Comentario comentario) {
		return comentarioRepositorio.save(comentario);
	}
	
	//Permite modificar un comentario
	public Optional<Comentario> obtenerComentrioId(Integer idComentario){
		return comentarioRepositorio.findById(idComentario);
	}
		
	//Permite eliminar un comentario
	public boolean eliminarComentario(Integer idComentario) {
		try {
			comentarioRepositorio.deleteById(idComentario);
			return true;		
		} catch (Exception err) {
			return false;
		}
	}
}
