package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Alumno;

@Named
public class AlumnoRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public Long registrar(Alumno alumno) throws Exception{
		em.persist(alumno);
		return alumno.getId();
	}
	
	public Long actualizar(Alumno alumno) throws Exception{
		em.merge(alumno);
		return alumno.getId();	
	}
	
	public List<Alumno>listarAlumno() throws Exception{
	
		List<Alumno>alumnos=new ArrayList<>();

		TypedQuery<Alumno> query = em.createQuery("FROM Alumno p", Alumno.class);
		alumnos= query.getResultList();
		return alumnos;
	}
	public List<Alumno> listarAlumnoxEmail(String email) throws Exception {
		List<Alumno> lista= new ArrayList<>();

		TypedQuery<Alumno> query = em.createQuery("FROM Alumno p WHERE p.email LIKE ?1", Alumno.class);
		query.setParameter(1, "%" + email + "%");
		lista= query.getResultList();
		
		if(lista.isEmpty())
			return null;
		else
			return lista;
	}
	public List<Alumno> listarAlumnoxCodigo(String codigo) throws Exception {
		List<Alumno> lista = new ArrayList<>();

		TypedQuery<Alumno> query = em.createQuery("FROM Alumno p WHERE p.codigo LIKE ?1", Alumno.class);
		query.setParameter(1, "%" + codigo + "%");
		lista= query.getResultList();

		if(lista.isEmpty())
			return null;
		else
			return lista;
	}
	
}
