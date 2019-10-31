package pe.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Seccion")
public class Seccion implements Serializable{
	
	private static final long serialVersionUID=5L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSeccion",nullable=false)
	private Long idSeccion;
	
	@ManyToOne
	@JoinColumn(name="idCurso",nullable=false)
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="idProfesor",nullable=false)
	private Profesor profesor;

	public Long getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Long idSeccion) {
		this.idSeccion= idSeccion;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
}