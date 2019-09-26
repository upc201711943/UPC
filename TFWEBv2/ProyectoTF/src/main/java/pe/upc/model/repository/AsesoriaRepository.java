package pe.upc.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Asesoria;
import pe.upc.model.entity.Seccion;

@Named
public class AsesoriaRepository implements Serializable{
	private static final long serialVersionUID = 6L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public Long agregar(Asesoria asesoria) throws Exception{
		em.persist(asesoria);
		return asesoria.getId();
	}
	
	public Long actualizar(Asesoria asesoria) throws Exception{
		em.merge(asesoria);
		return asesoria.getId();
	}
	
	
	public void eliminar(Asesoria asesoria) throws Exception{
		em.remove(asesoria);		
	}

	public List<Asesoria>listarAsesoria() throws Exception{
		List<Asesoria>asesorias=new ArrayList<>();
		
		TypedQuery<Asesoria> query=em.createQuery("FROM Asesoria p",Asesoria.class);
		asesorias=query.getResultList();
		
		return asesorias;	
	}
		public List<Asesoria> listarAsesoriaxSeccion(Seccion seccion) throws Exception {
		List<Asesoria> asesorias= new ArrayList<>();

		TypedQuery<Asesoria> query = em.createQuery("FROM Asesoria p WHERE p.seccion LIKE ?1", Asesoria.class);
		query.setParameter(1, seccion);
		asesorias= query.getResultList();

		return asesorias;
	}
}
