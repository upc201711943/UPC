package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Curso;
import pe.upc.model.repository.CursoRepository;

@Named
public class CursoBusiness implements Serializable{
	private static final long serialVersionUID = 2L;
	
	@Inject
	private CursoRepository cursoRepository;
	@Transactional
	public Long registrar(Curso curso) throws Exception {
		return cursoRepository.registrar(curso);
	}

	@Transactional
	public Long actualizar(Curso curso) throws Exception{
		return cursoRepository.actualizar(curso);
	}
	@Transactional
	public void Eliminar(Curso curso)throws Exception{
		cursoRepository.eliminar(curso);
	}
	
	public List<Curso> listarCurso() throws Exception {
		return cursoRepository.listarCurso();
	}
	
	public List<Curso> listarCursoxNombre(String nombre)throws Exception{
		return cursoRepository.ListarCursoxNombre(nombre);
	}
	public List<Curso> listarCursoxCodigo(String nombre)throws Exception{
		return cursoRepository.ListarCursoxCodigo(nombre);
	}
	public Curso CursoxNombre(String nombre)throws Exception{
		return cursoRepository.CursoxNombre(nombre);
	}
	
	
	
}
