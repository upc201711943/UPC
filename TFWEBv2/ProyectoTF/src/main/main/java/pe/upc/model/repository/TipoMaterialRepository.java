package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.TipoMaterial;

@Named
public class TipoMaterialRepository implements Serializable{

private static final long serialVersionUID = 8L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public Long registrar(TipoMaterial tipo) throws Exception{
		em.persist(tipo);
		return tipo.getId();
	}
	
	public Long actualizar(TipoMaterial tipo) throws Exception{
		em.merge(tipo);
		return tipo.getId();	
	}
	
	public void eliminar(TipoMaterial tipo) throws Exception{
		em.remove(tipo);		
	}
	
	public List<TipoMaterial>listarTipoMaterial() throws Exception{
		List<TipoMaterial>lista=new ArrayList<>();
		
		TypedQuery<TipoMaterial> query=em.createQuery("FROM TipoMaterial p",TipoMaterial.class);
		lista=query.getResultList();
		
		return lista;	
	}
}