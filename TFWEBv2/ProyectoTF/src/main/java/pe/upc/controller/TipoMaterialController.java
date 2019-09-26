package pe.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.TipoMaterialBusiness;
import pe.upc.model.entity.TipoMaterial;
import pe.upc.util.Message;

@Named
@SessionScoped
public class TipoMaterialController implements Serializable{

	private static final long serialVersionUID = 8L;

	@Inject
	private TipoMaterialBusiness tipomaterialBusiness;

	private TipoMaterial tipoMaterial;
	private List<TipoMaterial> tipoMateriales;
	private TipoMaterial tipoMaterialSelect;

	private String filterName;

	@PostConstruct
	public void init() {
		tipoMaterial= new TipoMaterial();
		tipoMateriales= new ArrayList<TipoMaterial>();

		getAllTipoMateriales();
	}

	public void getAllTipoMateriales() {
		try {
			tipoMateriales = tipomaterialBusiness.listarTipoMaterial();
		} catch (Exception e) {
			Message.messageError("Error Carga de Tipos de Materiales:" + e.getMessage());
		}
	}

	public String newTipoMaterial() {
		try {
			this.tipoMateriales = tipomaterialBusiness.listarTipoMaterial();

			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listTipoMaterial() {
		return "list.xhtml";
	}

	public String saveTipoMaterial() {
		String view = "";
		try {

			if (tipoMaterial.getId() != null) {
				tipomaterialBusiness.actualizar(tipoMaterial);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				tipomaterialBusiness.registrar(tipoMaterial);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllTipoMateriales();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error TipoMaterial:" + e.getStackTrace());
		}

		return view;
	}

	public String editTipoMaterial() {
		String view = "";
		try {
			if (this.tipoMaterialSelect != null) {
				this.tipoMaterial= tipoMaterialSelect;

				view = "/tipomaterial/update";
			} else {
				Message.messageInfo("Debe seleccionar un tipo de material");
			}
		} catch (Exception e) {
			Message.messageError("Error TipoMaterial:" + e.getMessage());
		}

		return view;
	}

	public void selectTipoMaterial(SelectEvent e) {
		this.tipoMaterialSelect= (TipoMaterial) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.tipoMaterial= new TipoMaterial();
	}

	public TipoMaterialBusiness getTipomaterialBusiness() {
		return tipomaterialBusiness;
	}

	public void setTipomaterialBusiness(TipoMaterialBusiness tipomaterialBusiness) {
		this.tipomaterialBusiness = tipomaterialBusiness;
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

	public TipoMaterial getTipoMaterialSelect() {
		return tipoMaterialSelect;
	}

	public void setTipoMaterialSelect(TipoMaterial tipoMaterialSelect) {
		this.tipoMaterialSelect = tipoMaterialSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	
}
