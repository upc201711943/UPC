package pe.upc.model.repository;
import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.upc.model.entity.Profesor;

@Named
public class ProfesorRepository implements Serializable{

	private static final long serialVersionUID = 6L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public String registrar(Profesor profesor) throws Exception{
		em.persist(profesor);
		return profesor.getCodigo();
	}
	
	public String actualizar(Profesor profesor) throws Exception{
		em.merge(profesor);
		return profesor.getCodigo();	
	}
	
}
