package pe.upc.model.repository;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.upc.model.entity.Alumno;

@Named
public class AlumnoRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public String registrar(Alumno alumno) throws Exception{
		em.persist(alumno);
		return alumno.getCodigo();
	}
	
	public String actualizar(Alumno alumno) throws Exception{
		em.merge(alumno);
		return alumno.getCodigo();	
	}
	
	
}
