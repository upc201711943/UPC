package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.TipoAsesoria;

@Named
public class TipoAsesoriaRepository implements Serializable{
private static final long serialVersionUID = 5L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public Long registrar(TipoAsesoria tipo) throws Exception{
		em.persist(tipo);
		return tipo.getId();
	}
	
	public Long actualizar(TipoAsesoria tipo) throws Exception{
		em.merge(tipo);
		return tipo.getId();	
	}
	
	public void eliminar(TipoAsesoria tipo) throws Exception{
		em.remove(tipo);		
	}
	
	public List<TipoAsesoria>listarTipoAsesoria() throws Exception{
		List<TipoAsesoria>lista=new ArrayList<>();
		
		TypedQuery<TipoAsesoria> query=em.createQuery("FROM TipoAsesoria p",TipoAsesoria.class);
		lista=query.getResultList();
		
		return lista;	
	}
}
