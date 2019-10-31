package pe.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.upc.spring.model.Profesor;

public interface IProfesorService{

	public boolean insertar(Profesor profesor);
	public boolean modificar(Profesor profesor);
	public void eliminar(Long idProfesor);
	public Optional<Profesor> listarId(Long idProfesor);
	public Optional<Profesor> buscarId(Long idProfesor);
	public List<Profesor>listar();
	public List<Profesor>buscarProfesor(String nombreProfesor);
}