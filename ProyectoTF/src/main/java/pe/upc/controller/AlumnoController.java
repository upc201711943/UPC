package pe.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.AlumnoBusiness;
import pe.upc.model.entity.Alumno;
import pe.upc.util.Message;

@Named
@SessionScoped
public class AlumnoController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private AlumnoBusiness alumnoBusiness;

	private Alumno alumno;
	private List<Alumno> alumnos;
	private Alumno alumnoSelect;

	private String filterName;

	@PostConstruct
	public void init() {
		alumno= new Alumno();
		alumnos = new ArrayList<Alumno>();

		getAllAlumnos();
	}

	public void getAllAlumnos() {
		try {
			alumnos = alumnoBusiness.listarAlumno();
		} catch (Exception e) {
			Message.messageError("Error Carga de Alumnos :" + e.getMessage());
		}
	}

	public String newAlumno() {

		try {
			this.alumnos= alumnoBusiness.listarAlumno();

			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listAlumno() {
		return "list.xhtml";
	}

	public String saveAlumno() {
		String view = "";
		try {

			if (alumno.getId() != null) {
				alumnoBusiness.actualizar(alumno);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				alumnoBusiness.registrar(alumno);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllAlumnos();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Alumno :" + e.getStackTrace());
		}

		return view;
	}

	public String editAlumno() {
		String view = "";
		try {
			if (this.alumnoSelect != null) {
				this.alumno= alumnoSelect;

				view = "/alumno/update";
			} else {
				Message.messageInfo("Debe seleccionar un alumno");
			}
		} catch (Exception e) {
			Message.messageError("Error Alumno:" + e.getMessage());
		}

		return view;
	}


	public void selectAlumno(SelectEvent e) {
		this.alumnoSelect = (Alumno) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.alumno= new Alumno();
	}

	public AlumnoBusiness getAlumnoBusiness() {
		return alumnoBusiness;
	}

	public void setAlumnoBusiness(AlumnoBusiness alumnoBusiness) {
		this.alumnoBusiness = alumnoBusiness;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno getAlumnoSelect() {
		return alumnoSelect;
	}

	public void setAlumnoSelect(Alumno alumnoSelect) {
		this.alumnoSelect = alumnoSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}



}
