package pe.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.upc.spring.model.Alumno;

public interface IAlumnoService {

	public boolean insertar(Alumno alumno);
	public boolean modificar(Alumno alumno);
	public void eliminar(Long idAlumno);
	public Optional<Alumno> buscarId(Long idAlumno);
	public Optional<Alumno> listarId(Long idAlumno);
	public List<Alumno> listar();
	public List<Alumno> buscarAlumno(String nombreAlumno);
	
	
}
