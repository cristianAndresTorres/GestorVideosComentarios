package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.VideoTutorial;
import com.example.demo.repositories.VideoTutorialRepositorio;

@Service
public class VideoTutorialServicio {
	@Autowired
	private VideoTutorialRepositorio videoTutorialRepositorio;
	
	//Retorna una lista de todos los videos
	public ArrayList<VideoTutorial> obtenerListaVideos(){
		return (ArrayList<VideoTutorial>) videoTutorialRepositorio.findAll();
	}
	
	//Permite guardar un video tutorial
	public VideoTutorial guardarVideo(VideoTutorial video) {
		return videoTutorialRepositorio.save(video);
	}
	
	//Permite modificar un video
	public Optional<VideoTutorial> obtenerVideoTutorialId(Integer idvideotutorial){
		return videoTutorialRepositorio.findById(idvideotutorial);
	}
	
	//Permite eliminar video tutorial
	public boolean eliminarVideo(Integer idvideotutorial) {
		try {
			videoTutorialRepositorio.deleteById(idvideotutorial);
			return true;
			
		} catch (Exception err) {
			return false;
		}
	}
	
	
}
