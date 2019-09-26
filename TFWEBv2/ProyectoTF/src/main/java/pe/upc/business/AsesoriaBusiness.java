package pe.upc.business;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Asesoria;
import pe.upc.model.entity.Seccion;
import pe.upc.model.repository.AsesoriaRepository;

@Named
public class AsesoriaBusiness implements Serializable{
	

	private static final long serialVersionUID = 6L;

	@Inject
	private AsesoriaRepository asesoriaRepository;
	@Transactional
	public Long registrar(Asesoria asesoria) throws Exception{
		return asesoriaRepository.agregar(asesoria);
	}
	@Transactional
	public Long actualizar(Asesoria asesoria) throws Exception{
		return asesoriaRepository.actualizar(asesoria);
	}	
	@Transactional
	public void eliminar(Asesoria asesoria) throws Exception{
		asesoriaRepository.eliminar(asesoria);
	}
	public List<Asesoria>listarAsesoria()throws Exception{
		return asesoriaRepository.listarAsesoria();
	}
	public List<Asesoria>listarAsesoriaxSeccion(Seccion seccion)throws Exception{
		return asesoriaRepository.listarAsesoriaxSeccion(seccion);
	}
}
