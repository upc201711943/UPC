package pe.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.ProfesorBusiness;
import pe.upc.model.entity.Profesor;
import pe.upc.util.Message;

@Named
@SessionScoped
public class ProfesorController implements Serializable{

	private static final long serialVersionUID = 3L;

	@Inject
	private ProfesorBusiness profesorBusiness;

	private Profesor profesor;
	private List<Profesor> profesores;
	private Profesor profesorSelect;

	private String filterName;

	@PostConstruct
	public void init() {
		profesor= new Profesor();
		profesores= new ArrayList<Profesor>();

		getAllProfesores();
	}

	public void getAllProfesores() {
		try {
			profesores= profesorBusiness.listarProfesor();
		} catch (Exception e) {
			Message.messageError("Error Carga de Profesores :" + e.getMessage());
		}
	}

	public String newProfesor() {

		try {
			this.profesores= profesorBusiness.listarProfesor();

			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listProfesor() {
		return "list.xhtml";
	}

	public String saveProfesor() {
		String view = "";
		try {

			if (profesor.getId() != null) {
				profesorBusiness.actualizar(profesor);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				profesorBusiness.registrar(profesor);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllProfesores();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Profesor :" + e.getStackTrace());
		}

		return view;
	}

	public String editProfesor() {
		String view = "";
		try {
			if (this.profesorSelect != null) {
				this.profesor= profesorSelect;

				view = "/profesor/update";
			} else {
				Message.messageInfo("Debe seleccionar un profesor");
			}
		} catch (Exception e) {
			Message.messageError("Error Profesor:" + e.getMessage());
		}

		return view;
	}


	public void selectProfesor(SelectEvent e) {
		this.profesorSelect = (Profesor) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.profesor= new Profesor();
	}

	public ProfesorBusiness getProfesorBusiness() {
		return profesorBusiness;
	}

	public void setProfesorBusiness(ProfesorBusiness profesorBusiness) {
		this.profesorBusiness = profesorBusiness;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Profesor getProfesorSelect() {
		return profesorSelect;
	}

	public void setProfesorSelect(Profesor profesorSelect) {
		this.profesorSelect = profesorSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	
	
}
