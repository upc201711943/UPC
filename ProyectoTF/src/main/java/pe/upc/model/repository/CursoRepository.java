package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Curso;


@Named
public class CursoRepository implements Serializable {

	private static final long serialVersionUID = 2L;
	
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;
	
	public Long registrar(Curso curso) throws Exception{
		em.persist(curso);
		return curso.getId();
	}
	
	public Long actualizar(Curso curso) throws Exception{
		em.merge(curso);
		return curso.getId();	
	}
	
	public void eliminar(Curso curso) throws Exception{
		em.remove(curso);		
	}
	public List<Curso> listarCurso() throws Exception {
		List<Curso> cursos= new ArrayList<>();

		TypedQuery<Curso> query = em.createQuery("FROM Curso p", Curso.class);
		cursos= query.getResultList();

		return cursos;
	}

	public List<Curso> ListarCursoxNombre(String nombre) throws Exception {
		List<Curso> cursos = new ArrayList<>();

		TypedQuery<Curso> query = em.createQuery("FROM Curso p WHERE p.nombre LIKE ?1", Curso.class);
		query.setParameter(1, "%" + nombre + "%");
		cursos = query.getResultList();

		return cursos;
	}
}
