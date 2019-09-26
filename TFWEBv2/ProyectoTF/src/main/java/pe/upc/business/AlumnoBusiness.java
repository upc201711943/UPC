package pe.upc.business;

import java.io.Serializable;
import java.util.List;

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
	public Long registrar(Alumno alumno) throws Exception {
		return alumnoRepository.registrar(alumno);
	}

	@Transactional
	public Long actualizar(Alumno alumno) throws Exception{
		return alumnoRepository.actualizar(alumno);
	}
	
	public List<Alumno> listarAlumno() throws Exception {
		return alumnoRepository.listarAlumno();
	}
	public List<Alumno> listarAlumnoxEmail(String email)throws Exception{
		return alumnoRepository.listarAlumnoxEmail(email);
	}
	public List<Alumno> listarAlumnoxCodigo(String codigo)throws Exception{
		return alumnoRepository.listarAlumnoxCodigo(codigo);
	}
	
	

	
}
