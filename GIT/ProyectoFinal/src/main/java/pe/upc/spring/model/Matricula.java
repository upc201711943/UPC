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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Matricula")
public class Matricula implements Serializable {

	private static final long serialVersionUID=3L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMatricula", nullable=false)
	private Long idMatricula;
	
	@ManyToOne
	@JoinColumn(name="idAlumno",nullable=false)
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name="idSeccion",nullable=false)
	private Seccion seccion;

	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="calificacion",nullable=true)
	private int calificacion;

	
	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matricula(Long idMatricula, Alumno alumno, Seccion seccion, int calificacion) {
		super();
		this.idMatricula = idMatricula;
		this.alumno = alumno;
		this.seccion = seccion;
		this.calificacion = calificacion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
}
