package pe.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.spring.model.Matricula;
import pe.upc.spring.repository.IMatriculaDAO;
import pe.upc.spring.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaDAO dMatricula;
	
	@Override
	@Transactional
	public boolean insertar(Matricula matricula){
		Matricula objMatricula=dMatricula.save(matricula);
		if(objMatricula==null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public boolean modificar(Matricula matricula){
		boolean flag=false;
		try {
			dMatricula.save(matricula);
			flag=true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
	
	@Override
	@Transactional
	public void eliminar(Long idMatricula){
		dMatricula.deleteById(idMatricula);
	}
	@Override
	public Optional<Matricula> buscarId(Long idMatricula){
		return dMatricula.findById(idMatricula);
	}
	@Override
	public Optional<Matricula> listarId(Long idMatricula){
		return dMatricula.findById(idMatricula);
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Matricula> listar(){
		return dMatricula.findAll();
	}
	/*
	@Override
	@Transactional
	public List<Matricula> buscarCurso(String nombreCurso){
		return dMatricula.buscarCurso(nombreCurso);
	}
	
	@Override
	@Transactional
	public List<Matricula> buscarProfesor(String nombreProfesor){
		return dMatricula.buscarProfesor(nombreProfesor);
	}*/
}
