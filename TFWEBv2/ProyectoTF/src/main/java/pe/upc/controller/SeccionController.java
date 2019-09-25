package pe.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.CursoBusiness;
import pe.upc.business.ProfesorBusiness;
import pe.upc.business.SeccionBusiness;
import pe.upc.model.entity.Profesor;
import pe.upc.model.entity.Curso;
import pe.upc.model.entity.Seccion;
import pe.upc.util.Message;

@Named
@SessionScoped
public class SeccionController implements Serializable{
	private static final long serialVersionUID = 4L;

	@Inject
	private CursoBusiness cursoBusiness;
	@Inject
	private SeccionBusiness seccionBusiness;
	@Inject
	private ProfesorBusiness profesorBusiness;

	private Seccion seccion;
	private List<Seccion> secciones;
	private Seccion seccionSelect;

	private Profesor profesor;
	private List<Profesor> profesores;
	private Profesor profesorParametro;
	
	private Curso curso;
	private List<Curso> cursos;
	private Curso cursoParametro;
	
	private String filterName;

	@PostConstruct
	public void init() {
		seccion= new Seccion();
		secciones= new ArrayList<Seccion>();

		profesor= new Profesor();
		profesores = new ArrayList<Profesor>();

		curso= new Curso();
		cursos = new ArrayList<Curso>();

		getAllSecciones();
	}

	public void getAllSecciones() {
		try {
			secciones = seccionBusiness.listarSeccion();
		} catch (Exception e) {
			Message.messageError("Error Carga de Secciones :" + e.getMessage());
		}
	}

	public String newSeccion() {

		try {
			this.profesores = profesorBusiness.listarProfesor();
			this.cursos= cursoBusiness.listarCurso();
			
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listSeccion() {
		return "list.xhtml";
	}

	public String saveSeccion() {
		String view = "";
		try {

			if (seccion.getId() != null) {
				seccion.setProfesor(profesor);
				seccion.setCurso(curso);
				seccionBusiness.actualizar(seccion);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				seccion.setProfesor(profesor);
				seccion.setCurso(curso);
				seccionBusiness.registrar(seccion);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllSecciones();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Seccion :" + e.getStackTrace());
		}

		return view;
	}

	public String editSeccion() {
		String view = "";
		try {
			if (this.seccionSelect != null) {
				this.seccion = seccionSelect;

				view = "/seccion/update";
			} else {
				Message.messageInfo("Debe seleccionar una seccion");
			}
		} catch (Exception e) {
			Message.messageError("Error Seccion :" + e.getMessage());
		}

		return view;
	}

	public void searchSeccionByName() {
		try {

			secciones = seccionBusiness.listarSeccionxCurso(this.cursoParametro);
			if (secciones.isEmpty()) {
				secciones = seccionBusiness.listarSeccionxProfesor(this.profesorParametro);
				resetForm();
				if (secciones.isEmpty()) {
						
				Message.messageInfo("No se encontraron secciones");
				}
			}

		} catch (Exception e) {
			Message.messageError("Error Seccion Search :" + e.getMessage());
		}
	}
	public void selectSeccion(SelectEvent e) {
		this.seccionSelect = (Seccion) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.cursoParametro=null;
		this.profesorParametro=null;
		this.seccion = new Seccion();
	}

	public CursoBusiness getCursoBusiness() {
		return cursoBusiness;
	}

	public void setCursoBusiness(CursoBusiness cursoBusiness) {
		this.cursoBusiness = cursoBusiness;
	}

	public SeccionBusiness getSeccionBusiness() {
		return seccionBusiness;
	}

	public void setSeccionBusiness(SeccionBusiness seccionBusiness) {
		this.seccionBusiness = seccionBusiness;
	}

	public ProfesorBusiness getProfesorBusiness() {
		return profesorBusiness;
	}

	public void setProfesorBusiness(ProfesorBusiness profesorBusiness) {
		this.profesorBusiness = profesorBusiness;
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

	public Seccion getSeccionSelect() {
		return seccionSelect;
	}

	public void setSeccionSelect(Seccion seccionSelect) {
		this.seccionSelect = seccionSelect;
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

	public Profesor getProfesorParametro() {
		return profesorParametro;
	}

	public void setProfesorParametro(Profesor profesorParametro) {
		this.profesorParametro = profesorParametro;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso getCursoParametro() {
		return cursoParametro;
	}

	public void setCursoParametro(Curso cursoParametro) {
		this.cursoParametro = cursoParametro;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
