package pe.upc.business;
import java.util.List;
import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Curso;
import pe.upc.model.repository.CursoRepository;

@Named
public class CursoBusiness implements Serializable{

	private static final long serialVersionUID = 3L;
	
	@Inject
	private CursoRepository cursoRepository;
	
	@Transactional
	public String registrar(Curso curso) throws Exception{
		return cursoRepository.registrar(curso);
	}
	
	@Transactional
	public String actualizar(Curso curso) throws Exception{
		return cursoRepository.actualizar(curso);
	}
	@Transactional
	public void eliminar(Curso curso) throws Exception{
		cursoRepository.eliminar(curso);
	}
	
	public List<Curso>listarCurso()throws Exception{
		return cursoRepository.listarCursos();
	}
	
	public List<Curso>listarCursoxNombre(String nombre)throws Exception{
		return cursoRepository.listarCursoxNombre(nombre);
	}
}
