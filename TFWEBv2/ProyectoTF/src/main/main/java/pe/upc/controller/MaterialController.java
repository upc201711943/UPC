package pe.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.MaterialBusiness;
import pe.upc.model.entity.Material;
import pe.upc.business.TipoMaterialBusiness;
import pe.upc.model.entity.TipoMaterial;
import pe.upc.business.SeccionBusiness;
import pe.upc.model.entity.Seccion;
import pe.upc.util.Message;

@Named
@SessionScoped
public class MaterialController implements Serializable{

	private static final long serialVersionUID = 9L;

	@Inject
	private MaterialBusiness materialBusiness;

	@Inject
	private TipoMaterialBusiness tipomaterialBusiness;

	@Inject
	private SeccionBusiness seccionBusiness;
	
	
	private Material material;
	private List<Material> materiales;
	private Material materialSelect;

	private TipoMaterial tipoMaterial;
	private List<TipoMaterial> tipoMateriales;

	private Seccion seccion;
	private List<Seccion> secciones;

	private String filterName;

	@PostConstruct
	public void init() {
		material= new Material();
		materiales = new ArrayList<Material>();

		tipoMaterial= new TipoMaterial();
		tipoMateriales = new ArrayList<TipoMaterial>();

		seccion= new Seccion();
		secciones = new ArrayList<Seccion>();

		getAllMateriales();
	}

	public void getAllMateriales() {
		try {
			materiales = materialBusiness.listarMaterial();
		} catch (Exception e) {
			Message.messageError("Error Carga de Materiales :" + e.getMessage());
		}
	}

	public String newMaterial() {

		try {
			this.tipoMateriales= tipomaterialBusiness.listarTipoMaterial();
			this.secciones=seccionBusiness.listarSeccion();

			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listMaterial() {
		return "list.xhtml";
	}

	public String saveMaterial() {
		String view = "";
		try {

			if (material.getId() != null) {
				material.setSeccion(seccion);
				material.setTipoMaterial(tipoMaterial);
				materialBusiness.actualizar(material);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				material.setSeccion(seccion);
				material.setTipoMaterial(tipoMaterial);
				materialBusiness.registrar(material);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllMateriales();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Material:" + e.getStackTrace());
		}

		return view;
	}

	public String editMaterial() {
		String view = "";
		try {
			if (this.materialSelect != null) {
				this.material= materialSelect;

				view = "/material/update";
			} else {
				Message.messageInfo("Debe seleccionar una material");
			}
		} catch (Exception e) {
			Message.messageError("Error Material:" + e.getMessage());
		}

		return view;
	}
	
	public void selectMaterial(SelectEvent e) {
		this.materialSelect = (Material) e.getObject();
	}
	public void resetForm() {
		this.filterName = "";
		this.material= new Material();
	}

	public MaterialBusiness getMaterialBusiness() {
		return materialBusiness;
	}

	public void setMaterialBusiness(MaterialBusiness materialBusiness) {
		this.materialBusiness = materialBusiness;
	}

	public TipoMaterialBusiness getTipomaterialBusiness() {
		return tipomaterialBusiness;
	}

	public void setTipomaterialBusiness(TipoMaterialBusiness tipomaterialBusiness) {
		this.tipomaterialBusiness = tipomaterialBusiness;
	}

	public SeccionBusiness getSeccionBusiness() {
		return seccionBusiness;
	}

	public void setSeccionBusiness(SeccionBusiness seccionBusiness) {
		this.seccionBusiness = seccionBusiness;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public List<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}

	public Material getMaterialSelect() {
		return materialSelect;
	}

	public void setMaterialSelect(Material materialSelect) {
		this.materialSelect = materialSelect;
	}

	public TipoMaterial getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(TipoMaterial tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public List<TipoMaterial> getTipoMateriales() {
		return tipoMateriales;
	}

	public void setTipoMateriales(List<TipoMaterial> tipoMateriales) {
		this.tipoMateriales = tipoMateriales;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public List<Seccion> getSecciones() {
		return secciones;
	}

	public void setSecciones(List<Seccion> secciones) {
		this.secciones = secciones;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	
}
