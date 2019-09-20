package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Profesor;
import pe.upc.model.entity.Seccion;
import pe.upc.model.repository.SeccionRepository;

@Named
public class SeccionBusiness implements Serializable{


	private static final long serialVersionUID = 7L;

	@Inject
	private SeccionRepository seccionRepository;
	@Transactional
	public Long registrar(Seccion seccion) throws Exception{
		return seccionRepository.agregar(seccion);
	}
	
	@Transactional
	public void eliminar(Seccion seccion) throws Exception{
		seccionRepository.eliminar(seccion);
	
	}
	
	public List<Seccion>listarSeccionxProfesor(Profesor profesor)throws Exception{
		return seccionRepository.listarSeccionxProfesor(profesor);
	}
	
	public List<Profesor>listarProfesorxSeccion(Seccion seccion)throws Exception{
		return seccionRepository.listarProfesorxSeccion(seccion);
	}
	
	
	
	
}
