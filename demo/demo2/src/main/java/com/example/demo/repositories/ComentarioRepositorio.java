package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Comentario;
import com.example.demo.models.VideoTutorial;

@Repository
public interface ComentarioRepositorio extends CrudRepository<Comentario, Integer>{
}
