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
@Table(name = "matriculas")
public class Matricula {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMatricula", nullable=false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="codigoAlumno",nullable=false)
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name="codigoSeccion",nullable=false)
	private Seccion seccion;

	@Column(name="calificacion",nullable=true)
	private int calificacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id= id;
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
