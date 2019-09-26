package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.upc.model.entity.TipoAsesoria;
import pe.upc.model.repository.TipoAsesoriaRepository;

@Named
public class TipoAsesoriaBusiness implements Serializable{

	private static final long serialVersionUID = 5L;
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;

	@Inject
	private TipoAsesoriaRepository tipoasesoriaRepository;
	
	@Transactional
	public Long registrar(TipoAsesoria tipo_asesoria) throws Exception{
		return tipoasesoriaRepository.registrar(tipo_asesoria);
	}
	
	@Transactional
	public Long actualizar(TipoAsesoria tipo_asesoria) throws Exception{
		return tipoasesoriaRepository.actualizar(tipo_asesoria);
	}
	@Transactional
	public void eliminar(TipoAsesoria tipo_asesoria) throws Exception{
		tipoasesoriaRepository.eliminar(tipo_asesoria);
	}
	public List<TipoAsesoria>listarTipoAsesoria()throws Exception{
		return tipoasesoriaRepository.listarTipoAsesoria();
	}
	
	
}