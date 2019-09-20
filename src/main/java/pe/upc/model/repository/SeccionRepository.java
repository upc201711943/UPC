package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Seccion;
import pe.upc.model.entity.Profesor;

@Named
public class SeccionRepository implements Serializable{

	private static final long serialVersionUID = 7L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	public Long agregar(Seccion seccion) throws Exception{
		em.persist(seccion);
		return seccion.getCodigo();
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
	public List<Profesor>listarProfesorxSeccion(Seccion seccion) throws Exception{
		List<Profesor>profesores=new ArrayList<>();
		
		TypedQuery<Profesor> query=em.createQuery("FROM Seccion p WHERE p.seccion LIKE ?1",Profesor.class);
		query.setParameter(1, seccion);
		profesores=query.getResultList();
		
		return profesores;	
	}

}
