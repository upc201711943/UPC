package pe.upc.business;
import java.util.List;
import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.upc.model.entity.Seccion;
import pe.upc.model.entity.Alumno;
import pe.upc.model.entity.Matricula;
import pe.upc.model.repository.MatriculaRepository;

@Named
public class MatriculaBusiness implements Serializable {

	private static final long serialVersionUID = 5L;
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;

	@Inject
	private MatriculaRepository matriculaRepository;

	@Transactional
	public Long registrar(Matricula matricula) throws Exception{
		return matriculaRepository.agregar(matricula);
	}
	
	@Transactional
	public Long actualizar(Matricula matricula) throws Exception{
		return matriculaRepository.actualizar(matricula);
	}
	@Transactional
	public void eliminar(Matricula matricula) throws Exception{
		matriculaRepository.eliminar(matricula);
	}
	
	
	public List<Alumno>listarAlumnoxSeccion(Seccion seccion)throws Exception{
		return matriculaRepository.listarAlumnoxSeccion(seccion);
	}
	
	public List<Seccion>listarSeccionxAlumno(Alumno alumno)throws Exception{
		return matriculaRepository.listarSeccionxAlumno(alumno);
	}
	
}
