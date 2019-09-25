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
import pe.upc.business.MatriculaBusiness;
import pe.upc.business.SeccionBusiness;
import pe.upc.model.entity.Matricula;
import pe.upc.model.entity.Alumno;
import pe.upc.model.entity.Seccion;
import pe.upc.util.Message;

@Named
@SessionScoped
public class MatriculaController implements Serializable {
	private static final long serialVersionUID = 7L;

	@Inject
	private MatriculaBusiness matriculaBusiness;
	@Inject
	private SeccionBusiness seccionBusiness;
	@Inject
	private AlumnoBusiness alumnoBusiness;

	private Matricula matricula;
	private List<Matricula> matriculas;
	private Matricula matriculaSelect;

	private Seccion seccion;
	private List<Seccion> secciones;
	
	private Alumno alumno;
	private List<Alumno> alumnos;
	
	private String filterName;

	@PostConstruct
	public void init() {
		seccion= new Seccion();
		secciones= new ArrayList<Seccion>();

		alumno= new Alumno();
		alumnos = new ArrayList<Alumno>();

		matricula= new Matricula();
		matriculas = new ArrayList<Matricula>();

		getAllMatriculas();
	}

	public void getAllMatriculas() {
		try {
			matriculas= matriculaBusiness.listarMatricula();
		} catch (Exception e) {
			Message.messageError("Error Carga de Matriculas :" + e.getMessage());
		}
	}

	public String newMatricula() {

		try {
			this.secciones= seccionBusiness.listarSeccion();
			this.alumnos= alumnoBusiness.listarAlumno();
			
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listMatricula() {
		return "list.xhtml";
	}

	public String saveMatricula() {
		String view = "";
		try {

			if (matricula.getId() != null) {
				matricula.setSeccion(seccion);
				matricula.setAlumno(alumno);
				matriculaBusiness.actualizar(matricula);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				matricula.setSeccion(seccion);
				matricula.setAlumno(alumno);
				matriculaBusiness.registrar(matricula);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllMatriculas();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Matricula :" + e.getStackTrace());
		}

		return view;
	}

	public String editMatricula() {
		String view = "";
		try {
			if (this.matriculaSelect != null) {
				this.matricula= matriculaSelect;

				view = "/matricula/update";
			} else {
				Message.messageInfo("Debe seleccionar una matricula");
			}
		} catch (Exception e) {
			Message.messageError("Error Matricula :" + e.getMessage());
		}

		return view;
	}
	public void selectMatricula(SelectEvent e) {
		this.matriculaSelect = (Matricula) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.seccion = new Seccion();
	}

	public MatriculaBusiness getMatriculaBusiness() {
		return matriculaBusiness;
	}

	public void setMatriculaBusiness(MatriculaBusiness matriculaBusiness) {
		this.matriculaBusiness = matriculaBusiness;
	}

	public SeccionBusiness getSeccionBusiness() {
		return seccionBusiness;
	}

	public void setSeccionBusiness(SeccionBusiness seccionBusiness) {
		this.seccionBusiness = seccionBusiness;
	}

	public AlumnoBusiness getAlumnoBusiness() {
		return alumnoBusiness;
	}

	public void setAlumnoBusiness(AlumnoBusiness alumnoBusiness) {
		this.alumnoBusiness = alumnoBusiness;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Matricula getMatriculaSelect() {
		return matriculaSelect;
	}

	public void setMatriculaSelect(Matricula matriculaSelect) {
		this.matriculaSelect = matriculaSelect;
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

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
