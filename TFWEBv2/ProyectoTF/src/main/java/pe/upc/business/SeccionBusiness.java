package pe.upc.business;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Curso;
import pe.upc.model.entity.Profesor;
import pe.upc.model.entity.Seccion;
import pe.upc.model.repository.SeccionRepository;

@Named
public class SeccionBusiness implements Serializable{


	private static final long serialVersionUID = 4L;

	@Inject
	private SeccionRepository seccionRepository;
	@Transactional
	public Long registrar(Seccion seccion) throws Exception{
		return seccionRepository.agregar(seccion);
	}
	@Transactional
	public Long actualizar(Seccion seccion) throws Exception{
		return seccionRepository.actualizar(seccion);
	}	
	@Transactional
	public void eliminar(Seccion seccion) throws Exception{
		seccionRepository.eliminar(seccion);
	
	}
	
	public List<Seccion>listarSeccion()throws Exception{
		return seccionRepository.listarSeccion();
	}
	public List<Seccion>listarSeccionxProfesor(Profesor profesor)throws Exception{
		return seccionRepository.listarSeccionxProfesor(profesor);
	}
	
	public List<Seccion>listarSeccionxCurso(Curso curso)throws Exception{
		return seccionRepository.listarSeccionxCurso(curso);
	}
	
	
	
	
}
