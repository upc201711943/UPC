package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.upc.model.entity.TipoMaterial;
import pe.upc.model.repository.TipoMaterialRepository;

@Named
public class TipoMaterialBusiness implements Serializable{
	
	private static final long serialVersionUID = 8L;
	@PersistenceContext(unitName="pwTF")
	private EntityManager em;

	@Inject
	private TipoMaterialRepository tipomaterialRepository;
	
	@Transactional
	public Long registrar(TipoMaterial tipo_material) throws Exception{
		return tipomaterialRepository.registrar(tipo_material);
	}
	
	@Transactional
	public Long actualizar(TipoMaterial tipo_material) throws Exception{
		return tipomaterialRepository.actualizar(tipo_material);
	}
	@Transactional
	public void eliminar(TipoMaterial tipo_material) throws Exception{
		tipomaterialRepository.eliminar(tipo_material);
	}
	public List<TipoMaterial>listarTipoMaterial()throws Exception{
		return tipomaterialRepository.listarTipoMaterial();
	}
	
}
