package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Matricula;
import pe.upc.model.entity.Seccion;
import pe.upc.model.entity.Alumno;
@Named
public class MatriculaRepository implements Serializable{

private static final long serialVersionUID = 5L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	public Long agregar(Matricula matricula) throws Exception{
		em.persist(matricula);
		return matricula.getCodigo();
	}
	public Long actualizar(Matricula matricula) throws Exception{
		em.merge(matricula);
		return matricula.getCodigo();
	}
	
	public void eliminar(Matricula matricula) throws Exception{
		em.remove(matricula);		
	}
	
	public List<Alumno> listarAlumnoxSeccion(Seccion seccion) throws Exception {
		List<Alumno> alumnos = new ArrayList<>();

		TypedQuery<Alumno> query = em.createQuery("FROM Matricula p WHERE p.seccion LIKE ?1", Alumno.class);
		query.setParameter(1, "%" + seccion+ "%");
		alumnos= query.getResultList();

		return alumnos;
	}
	public List<Seccion> listarSeccionxAlumno(Alumno alumno) throws Exception {
		List<Seccion> secciones= new ArrayList<>();

		TypedQuery<Seccion> query = em.createQuery("FROM Matricula p WHERE p.alumno LIKE ?1", Seccion.class);
		query.setParameter(1, "%" + alumno+ "%");
		secciones= query.getResultList();

		return secciones;
	}

}
