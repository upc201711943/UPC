package pe.upc.model.repository;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.upc.model.entity.TipoAsesoria;

@Named
public class TipoAsesoriaRepository implements Serializable{
private static final long serialVersionUID = 8L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public Long registrar(TipoAsesoria tipo) throws Exception{
		em.persist(tipo);
		return tipo.getCodigo();
	}
	
	public Long actualizar(TipoAsesoria tipo) throws Exception{
		em.merge(tipo);
		return tipo.getCodigo();	
	}
	
	public void eliminar(TipoAsesoria tipo) throws Exception{
		em.remove(tipo);		
	}
}
