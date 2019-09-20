package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Profesor")
public class Profesor{
	
	@Id
	@Column(name="codigoProfesor", nullable=false)
	private String codigo;

	@Column(name="nombreProfesor", nullable=false)
	private String nombre;
	
	@Column(name="apellidoProfesor",nullable=false)
	private String apellido;

	@Column(name="emailProfesor", nullable=false)
	private String email;

	@Column(name="passwordProfesor", nullable=false)
	private String password;

	@Column(name="telefonoProfesor",nullable=false)
	private String telefono;
	
	
	@Column(name="notaProfesor", nullable=true)
	private int nota;
	
	@Column(name="gradoProfesor",nullable=true)
	private String grado;
	
	@Column(name="calificacionProfesor", nullable=true)
	private float calificacion;
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
