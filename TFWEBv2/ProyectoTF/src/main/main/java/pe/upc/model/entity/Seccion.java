package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seccions")
public class Seccion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSeccion",nullable=false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="codigoCurso",nullable=false)
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="codigoProfesor",nullable=false)
	private Profesor profesor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id= id;
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