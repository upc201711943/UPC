package pe.upc.business;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Profesor;
import pe.upc.model.repository.ProfesorRepository;

@Named
public class ProfesorBusiness implements Serializable{

	private static final long serialVersionUID = 3L;
	
	@Inject
	private ProfesorRepository profesorRepository;
	@Transactional
	public Long registrar(Profesor profesor) throws Exception {
		return profesorRepository.registrar(profesor);
	}

	@Transactional
	public Long actualizar(Profesor profesor) throws Exception{
		return profesorRepository.actualizar(profesor);
	}
		
	public List<Profesor> listarProfesor() throws Exception {
		return profesorRepository.listarProfesor();
	}
	public List<Profesor> listarProfesorxEmail(String email)throws Exception{
		return profesorRepository.listarProfesorxEmail(email);
	}
	public List<Profesor> listarProfesorxCodigo(String codigo)throws Exception{
		return profesorRepository.listarProfesorxCodigo(codigo);
	}
	

}
