package pe.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.upc.spring.model.Curso;

public interface ICursoService {

	public boolean insertar(Curso curso);
	public boolean modificar(Curso curso);
	public void eliminar(Long idCurso);
	public Optional<Curso> listarId(Long idCurso);
	public Optional<Curso> buscarId(Long idCurso);
	public List<Curso>listar();
	public List<Curso>buscarCurso(String nombreCurso);
}
