package pe.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.AsesoriaBusiness;
import pe.upc.model.entity.Asesoria;
import pe.upc.business.TipoAsesoriaBusiness;
import pe.upc.model.entity.TipoAsesoria;
import pe.upc.business.SeccionBusiness;
import pe.upc.model.entity.Seccion;
import pe.upc.util.Message;

@Named
@SessionScoped
public class AsesoriaController implements Serializable{
	private static final long serialVersionUID = 6L;

	@Inject
	private AsesoriaBusiness asesoriaBusiness;

	@Inject
	private TipoAsesoriaBusiness tipoasesoriaBusiness;

	@Inject
	private SeccionBusiness seccionBusiness;
	
	
	private Asesoria asesoria;
	private List<Asesoria> asesorias;
	private Asesoria asesoriaSelect;

	private TipoAsesoria tipoAsesoria;
	private List<TipoAsesoria> tipoAsesorias;

	private Seccion seccion;
	private List<Seccion> secciones;

	private String filterName;

	@PostConstruct
	public void init() {
		asesoria= new Asesoria();
		asesorias = new ArrayList<Asesoria>();

		tipoAsesoria= new TipoAsesoria();
		tipoAsesorias = new ArrayList<TipoAsesoria>();

		seccion= new Seccion();
		secciones = new ArrayList<Seccion>();

		getAllAsesorias();
	}

	public void getAllAsesorias() {
		try {
			asesorias = asesoriaBusiness.listarAsesoria();
		} catch (Exception e) {
			Message.messageError("Error Carga de Asesorias :" + e.getMessage());
		}
	}

	public String newAsesoria() {

		try {
			this.tipoAsesorias= tipoasesoriaBusiness.listarTipoAsesoria();
			this.secciones=seccionBusiness.listarSeccion();

			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listAsesoria() {
		return "list.xhtml";
	}

	public String saveAsesoria() {
		String view = "";
		try {

			if (asesoria.getId() != null) {
				asesoria.setSeccion(seccion);
				asesoria.setTipoAsesoria(tipoAsesoria);
				asesoriaBusiness.actualizar(asesoria);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				asesoria.setSeccion(seccion);
				asesoria.setTipoAsesoria(tipoAsesoria);
				asesoriaBusiness.registrar(asesoria);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllAsesorias();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Asesoria :" + e.getStackTrace());
		}

		return view;
	}

	public String editAsesoria() {
		String view = "";
		try {
			if (this.asesoriaSelect != null) {
				this.asesoria= asesoriaSelect;

				view = "/asesoria/update";
			} else {
				Message.messageInfo("Debe seleccionar una asesoria");
			}
		} catch (Exception e) {
			Message.messageError("Error Asesoria:" + e.getMessage());
		}

		return view;
	}

	/*public void searchProductByName() {
		try {

			products = productBusiness.getProductsByName(this.filterName.trim());
			resetForm();
			if (products.isEmpty()) {
				Message.messageInfo("No se encontraron productos");

			}

		} catch (Exception e) {
			Message.messageError("Error Product Search :" + e.getMessage());
		}
	}*/
	
	

	public void selectAsesoria(SelectEvent e) {
		this.asesoriaSelect = (Asesoria) e.getObject();
	}

	public TipoAsesoriaBusiness getTipoasesoriaBusiness() {
		return tipoasesoriaBusiness;
	}

	public void setTipoasesoriaBusiness(TipoAsesoriaBusiness tipoasesoriaBusiness) {
		this.tipoasesoriaBusiness = tipoasesoriaBusiness;
	}

	public SeccionBusiness getSeccionBusiness() {
		return seccionBusiness;
	}

	public void setSeccionBusiness(SeccionBusiness seccionBusiness) {
		this.seccionBusiness = seccionBusiness;
	}

	public void resetForm() {
		this.filterName = "";
		this.asesoria= new Asesoria();
	}

	public AsesoriaBusiness getAsesoriaBusiness() {
		return asesoriaBusiness;
	}

	public void setAsesoriaBusiness(AsesoriaBusiness asesoriaBusiness) {
		this.asesoriaBusiness = asesoriaBusiness;
	}

	public Asesoria getAsesoria() {
		return asesoria;
	}

	public void setAsesoria(Asesoria asesoria) {
		this.asesoria = asesoria;
	}

	public List<Asesoria> getAsesorias() {
		return asesorias;
	}

	public void setAsesorias(List<Asesoria> asesorias) {
		this.asesorias = asesorias;
	}

	public Asesoria getAsesoriaSelect() {
		return asesoriaSelect;
	}

	public void setAsesoriaSelect(Asesoria asesoriaSelect) {
		this.asesoriaSelect = asesoriaSelect;
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
