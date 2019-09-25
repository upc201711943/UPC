package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Seccion;
import pe.upc.model.entity.Curso;
import pe.upc.model.entity.Profesor;

@Named
public class SeccionRepository implements Serializable{

	private static final long serialVersionUID = 4L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public Long agregar(Seccion seccion) throws Exception{
		em.persist(seccion);
		return seccion.getId();
	}
	
	public Long actualizar(Seccion seccion) throws Exception{
		em.merge(seccion);
		return seccion.getId();
	}
	
	
	public void eliminar(Seccion seccion) throws Exception{
		em.remove(seccion);		
	}
	
	
	
	public List<Seccion>listarSeccionxProfesor(Profesor profesor) throws Exception{
		List<Seccion>secciones=new ArrayList<>();
		
		TypedQuery<Seccion> query=em.createQuery("FROM Seccion p WHERE p.profesor LIKE ?1",Seccion.class);
		query.setParameter(1, profesor);
		secciones=query.getResultList();
		
		return secciones;	
	}
	public List<Seccion>listarSeccionxCurso(Curso curso) throws Exception{
		List<Seccion>secciones=new ArrayList<>();
		
		TypedQuery<Seccion> query=em.createQuery("FROM Seccion p WHERE p.curso LIKE ?1",Seccion.class);
		query.setParameter(1, curso);
		secciones=query.getResultList();
		
		return secciones;	
	}
	public List<Seccion>listarSeccion() throws Exception{
		List<Seccion>secciones=new ArrayList<>();
		
		TypedQuery<Seccion> query=em.createQuery("FROM Seccion p",Seccion.class);
		secciones=query.getResultList();
		
		return secciones;	
	}

}