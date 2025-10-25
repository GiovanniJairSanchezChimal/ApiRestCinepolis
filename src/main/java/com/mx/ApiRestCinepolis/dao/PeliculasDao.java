package com.mx.ApiRestCinepolis.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mx.ApiRestCinepolis.model.Peliculas;
//Repositorios que vioenen de Spring data
//JpaRepositoy--metodos del crud y la paginacion
//CrudRepository--metodos del crud
public interface PeliculasDao extends JpaRepository<Peliculas, Integer>{

}
