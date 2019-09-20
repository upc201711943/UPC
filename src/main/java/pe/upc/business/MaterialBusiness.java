package pe.upc.business;
import java.util.List;
import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Seccion;
import pe.upc.model.entity.Material;
import pe.upc.model.repository.MaterialRepository;

@Named
public class MaterialBusiness implements Serializable{


	private static final long serialVersionUID = 4L;
	
	@Inject
	private MaterialRepository materialRepository;
	
	@Transactional
	public Long registrar(Material material) throws Exception{
		return materialRepository.registrar(material);
	}
	
	@Transactional
	public Long actualizar(Material material) throws Exception{
		return materialRepository.actualizar(material);
	}
	@Transactional
	public void eliminar(Material material) throws Exception{
		materialRepository.eliminar(material);
	}
		
	public List<Material>listarMaterialxSeccion(Seccion seccion)throws Exception{
		return materialRepository.ListarMaterialxSeccion(seccion);
	}
	
	public List<Material>listarMaterialCotizar()throws Exception{
		return materialRepository.ListarMaterialCotizar();
	}
}
