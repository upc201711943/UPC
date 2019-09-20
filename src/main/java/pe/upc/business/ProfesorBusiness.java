package pe.upc.business;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Profesor;
import pe.upc.model.repository.ProfesorRepository;

@Named
public class ProfesorBusiness implements Serializable{

	private static final long serialVersionUID = 6L;
	
	@Inject
	private ProfesorRepository profesorRepository;
	
	@Transactional
	public String registrar(Profesor profesor) throws Exception{
		return profesorRepository.registrar(profesor);
	}
	
	@Transactional
	public String actualizar(Profesor profesor) throws Exception{
		return profesorRepository.actualizar(profesor);
	
	}
}