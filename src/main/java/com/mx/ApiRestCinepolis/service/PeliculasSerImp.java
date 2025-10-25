package com.mx.ApiRestCinepolis.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mx.ApiRestCinepolis.dao.PeliculasDao;
import com.mx.ApiRestCinepolis.model.Peliculas;

@Service
public class PeliculasSerImp {
	//inyeccion de dependencias
	//@Autowired para tener mejor control de los objetos que se incialilzan
	
	@Autowired
	private PeliculasDao peliculasDao;
	
	//para indicarle que no vamoa  afectar la base de datos
	@Transactional(readOnly=true)
	public List<Peliculas>show(){
		List<Peliculas>registrobd = peliculasDao.findAll();
		return registrobd;
	}
	
	@Transactional
	public boolean save(Peliculas pelicula) {
		boolean flag = false;
		for(Peliculas p: peliculasDao.findAll()) {
			if(p.getNombre().equals(pelicula.getNombre())) {
				flag = true;
				break;
			}
		}
		if(!flag)
			peliculasDao.save(pelicula);
		return flag;
	}
	
	@Transactional(readOnly=true)
	public Peliculas search(Integer IdPeli) {
		Peliculas searchPeli= peliculasDao.findById(IdPeli).orElse(null);
		return searchPeli;
	}
	
	@Transactional
	public boolean edit(Peliculas pelicula) {
		if (search(pelicula.getId())!=null) {
			peliculasDao.save(pelicula);
			return true;
		}else
			return false;
	}	
	
	@Transactional
	public boolean delete(Integer idPeli) {
		if(search(idPeli)!=null) {
			peliculasDao.deleteById(idPeli);
			return true;
		}else
			return false;
	}
}
