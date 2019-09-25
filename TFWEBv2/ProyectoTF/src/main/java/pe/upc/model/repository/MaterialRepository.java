package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Material;
import pe.upc.model.entity.Seccion;
@Named
public class MaterialRepository implements Serializable{
	
private static final long serialVersionUID = 4L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public Long registrar(Material material) throws Exception{
		em.persist(material);
		return material.getCodigo();
	}
	public Long actualizar(Material material) throws Exception{
		em.merge(material);
		return material.getCodigo();
	}
	
	public void eliminar(Material material) throws Exception{
		em.remove(material);		
	}
	

	public List<Material> ListarMaterialxSeccion(Seccion seccion) throws Exception {
		List<Material> materiales= new ArrayList<>();

		TypedQuery<Material> query = em.createQuery("FROM Material p WHERE p.seccion LIKE ?1", Material.class);
		query.setParameter(1, "%" + seccion + "%");
		materiales= query.getResultList();

		return materiales;
	}


	public List<Material> ListarMaterialCotizar() throws Exception {
		List<Material> materiales= new ArrayList<>();

		TypedQuery<Material > query = em.createQuery("FROM Material p WHERE p.disponibilidad is false", Material.class);
		materiales= query.getResultList();

		return materiales;
	}
}
