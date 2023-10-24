package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.VideoTutorial;
import com.example.demo.services.VideoTutorialServicio;

@RestController
@RequestMapping("/video")
public class VideoTutorialControlador {
	@Autowired
	private VideoTutorialServicio videoTutorialServicio;
	
	//Permite controlar la obtencion del listado de todos los videos 
	@RequestMapping("/")
	public String obtenerListaVideos(Model modelo){
		List<VideoTutorial>listaVideoTutorial = this.videoTutorialServicio.obtenerListaVideos();
		modelo.addAttribute("misVideoTutorial", listaVideoTutorial);
		return "index";
	}
	
	//Permite controlar el guardado de un video
	@PostMapping()
	public VideoTutorial guardarVideo(@RequestBody VideoTutorial video) {
		return this.videoTutorialServicio.guardarVideo(video);
	}
	
	//Permite controlar el filtrado de un videotutorial por id
	@GetMapping( path = "/{idvideotutorial}" )
	public Optional<VideoTutorial> obtenerVideoTutorialId(@PathVariable("idvideotutorial") Integer idvideotutorial){
		return this.videoTutorialServicio.obtenerVideoTutorialId(idvideotutorial);
	}
	
	//Permite controlar la eliminacion de un videotutorial por id
	@DeleteMapping(path = "/{id}")
	public String eliminarVideoTutorial(@PathVariable("id") Integer idvideotutorial) {
		boolean ok = this.videoTutorialServicio.eliminarVideo(idvideotutorial);
		if(ok) {
			return "Se elimino video con id" + idvideotutorial;
		}else {
			return "Se elimino video con id" + idvideotutorial;
		}
	}
	
}
