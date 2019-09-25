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
import pe.upc.model.entity.Curso;
import pe.upc.util.Message;

@Named
@SessionScoped
public class CursoController implements Serializable{

	private static final long serialVersionUID = 2L;

	@Inject
	private CursoBusiness cursoBusiness;

	private Curso curso;
	private List<Curso> cursos;
	private Curso cursoSelect;

	private String filterName;

	@PostConstruct
	public void init() {
		curso= new Curso();
		cursos = new ArrayList<Curso>();

		getAllCursos();
	}

	public void getAllCursos() {
		try {
			cursos= cursoBusiness.listarCurso();
		} catch (Exception e) {
			Message.messageError("Error Carga de Cursos :" + e.getMessage());
		}
	}

	public String newCurso() {

		try {
			this.cursos= cursoBusiness.listarCurso();

			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listCurso() {
		return "list.xhtml";
	}

	public String saveCurso() {
		String view = "";
		try {

			if (curso.getId() != null) {
				cursoBusiness.actualizar(curso);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				cursoBusiness.registrar(curso);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllCursos();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Curso :" + e.getStackTrace());
		}

		return view;
	}

	public String editCurso() {
		String view = "";
		try {
			if (this.cursoSelect != null) {
				this.curso= cursoSelect;

				view = "/curso/update";
			} else {
				Message.messageInfo("Debe seleccionar un curso");
			}
		} catch (Exception e) {
			Message.messageError("Error Curso:" + e.getMessage());
		}

		return view;
	}

	public void searchCursoByName() {
		try {

			cursos = cursoBusiness.listarCursoxNombre(this.filterName.trim());
			resetForm();
			if (cursos.isEmpty()) {
				Message.messageInfo("No se encontraron cursos");

			}

		} catch (Exception e) {
			Message.messageError("Error Curso Search :" + e.getMessage());
		}
	}

	public void selectCurso(SelectEvent e) {
		this.cursoSelect = (Curso) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.curso= new Curso();
	}

	public CursoBusiness getCursoBusiness() {
		return cursoBusiness;
	}

	public void setCursoBusiness(CursoBusiness cursoBusiness) {
		this.cursoBusiness = cursoBusiness;
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

	public Curso getCursoSelect() {
		return cursoSelect;
	}

	public void setCursoSelect(Curso cursoSelect) {
		this.cursoSelect = cursoSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}


}
