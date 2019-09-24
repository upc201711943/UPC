package pe.upc.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Profesor;

@Named
public class ProfesorRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public Long registrar(Profesor profesor) throws Exception{
		em.persist(profesor);
		return profesor.getId();
	}
	
	public Long actualizar(Profesor profesor) throws Exception{
		em.merge(profesor);
		return profesor.getId();	
	}
	
	public List<Profesor>listarProfesor() throws Exception{
		
		List<Profesor>profesores=new ArrayList<>();

		TypedQuery<Profesor> query = em.createQuery("FROM Profesor p", Profesor.class);
		profesores= query.getResultList();
		return profesores;
	}
	
}
