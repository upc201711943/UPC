package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.TipoAsesoriaBusiness;
import pe.upc.model.entity.TipoAsesoria;
import pe.upc.util.Message;

@Named
@SessionScoped
public class TipoAsesoriaController implements Serializable {

	private static final long serialVersionUID = 5L;

	@Inject
	private TipoAsesoriaBusiness tipoasesoriaBusiness;

	private TipoAsesoria tipoAsesoria;
	private List<TipoAsesoria> tipoAsesorias;
	private TipoAsesoria tipoAsesoriaSelect;

	private String filterName;

	@PostConstruct
	public void init() {
		tipoAsesoria= new TipoAsesoria();
		tipoAsesorias= new ArrayList<TipoAsesoria>();

		getAllTipoAsesorias();
	}

	public void getAllTipoAsesorias() {
		try {
			tipoAsesorias = tipoasesoriaBusiness.listarTipoAsesoria();
		} catch (Exception e) {
			Message.messageError("Error Carga de Tipos de Asesorias:" + e.getMessage());
		}
	}

	public String newTipoAsesoria() {

		try {
			this.tipoAsesorias = tipoasesoriaBusiness.listarTipoAsesoria();

			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listTipoAsesoria() {
		return "list.xhtml";
	}

	public String saveTipoAsesoria() {
		String view = "";
		try {

			if (tipoAsesoria.getId() != null) {
				tipoasesoriaBusiness.actualizar(tipoAsesoria);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				tipoasesoriaBusiness.registrar(tipoAsesoria);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllTipoAsesorias();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error TipoAsesoria:" + e.getStackTrace());
		}

		return view;
	}

	public String editTipoAsesoria() {
		String view = "";
		try {
			if (this.tipoAsesoriaSelect != null) {
				this.tipoAsesoria= tipoAsesoriaSelect;

				view = "/tipoasesoria/update";
			} else {
				Message.messageInfo("Debe seleccionar un tipo de asesoria");
			}
		} catch (Exception e) {
			Message.messageError("Error TipoAsesoria:" + e.getMessage());
		}

		return view;
	}

	public void selectTipoAsesoria(SelectEvent e) {
		this.tipoAsesoriaSelect= (TipoAsesoria) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.tipoAsesoria= new TipoAsesoria();
	}

	public TipoAsesoriaBusiness getTipoasesoriaBusiness() {
		return tipoasesoriaBusiness;
	}

	public void setTipoasesoriaBusiness(TipoAsesoriaBusiness tipoasesoriaBusiness) {
		this.tipoasesoriaBusiness = tipoasesoriaBusiness;
	}

	public TipoAsesoria getTipoAsesoria() {
		return tipoAsesoria;
	}

	public void setTipoAsesoria(TipoAsesoria tipoAsesoria) {
		this.tipoAsesoria = tipoAsesoria;
	}

	public List<TipoAsesoria> getTipoAsesorias() {
		return tipoAsesorias;
	}

	public void setTipoAsesorias(List<TipoAsesoria> tipoAsesorias) {
		this.tipoAsesorias = tipoAsesorias;
	}

	public TipoAsesoria getTipoAsesoriaSelect() {
		return tipoAsesoriaSelect;
	}

	public void setTipoAsesoriaSelect(TipoAsesoria tipoAsesoriaSelect) {
		this.tipoAsesoriaSelect = tipoAsesoriaSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
