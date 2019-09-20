package pe.upc.model.repository;


import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import pe.upc.model.entity.TipoMaterial;

@Named
public class TipoMaterialRepository implements Serializable{
private static final long serialVersionUID = 9L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public Long registrar(TipoMaterial tipo) throws Exception{
		em.persist(tipo);
		return tipo.getCodigo();
	}
	
	public Long actualizar(TipoMaterial tipo) throws Exception{
		em.merge(tipo);
		return tipo.getCodigo();	
	}
	
	public void eliminar(TipoMaterial tipo) throws Exception{
		em.remove(tipo);		
	}
}
