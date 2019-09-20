package pe.upc.business;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Alumno;
import pe.upc.model.repository.AlumnoRepository;

@Named
public class AlumnoBusiness implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlumnoRepository alumnoRepository;
	
	@Transactional
	public String registrar(Alumno alumno) throws Exception{
		return alumnoRepository.registrar(alumno);
	}
	
	@Transactional
	public String actualizar(Alumno alumno) throws Exception{
		return alumnoRepository.actualizar(alumno);
	}
}
