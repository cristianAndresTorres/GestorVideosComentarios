package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Comentario;
import com.example.demo.models.VideoTutorial;
import com.example.demo.models.BD.ComentarioDAO;
import com.example.demo.services.ComentarioServicio;
import com.example.demo.services.VideoTutorialServicio;


@RestController
@RequestMapping("/comentario")
public class ComentarioControlador {
	private @Autowired ComentarioServicio comentarioServicio;
	
	//Permite controlar la obtencion del listado de todos los videos 
	@GetMapping()
	public ArrayList<Comentario> obtenerListaComentario(){
		return this.comentarioServicio.obtenerListaComentario();
	}
	
	//Permite controlar el modificar un video
	@PostMapping()
	public Comentario modificarComentario(@RequestBody Comentario comentario) {
		return this.comentarioServicio.modificarComentario(comentario);
	}
		
	//Permite guardar un comentarios asociado a un libro
	@PostMapping("/guardarComentario")
	public String guardarComentario(@Validated Comentario comentario, Model modelo) {
				ComentarioDAO comentarioDAO = ComentarioDAO.getComentarioDAO(); 
				comentarioDAO.guardarComentario(comentario);
		return "redirect:/listarCitasMedicas";
	}
	
	//Permite controlar el filtrado de un comentario por id
	@GetMapping( path = "/{idComentario}" )
	public Optional<Comentario> obtenerComentarioId(@PathVariable("idComentario") Integer idComentario){
		return this.comentarioServicio.obtenerComentrioId(idComentario);
	}
		
	//Permite controlar la eliminacion de un comentario por id
	@DeleteMapping(path = "/{id}")
	public String eliminarVideoTutorial(@PathVariable("id") Integer idComentario) {
		boolean ok = this.comentarioServicio.eliminarComentario(idComentario);
		if(ok) {
			return "Se elimino comentario con id" + idComentario;
		}else {
			return "Se elimino comentario con id" + idComentario;
		}
	}
	
	@GetMapping(path = "/comentario/{idvideotutorial}")
	public ArrayList<Comentario> obtenerListaComentarios(@PathVariable int idvideotutorial, Model modelo){
		ArrayList<Comentario>listaComentario = ComentarioDAO.getComentarioDAO().obtenerListaComentarios(idvideotutorial);
		modelo.addAttribute("misComentarios", listaComentario);
		return listaComentario;
	}
	
	
}
