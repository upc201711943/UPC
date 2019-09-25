package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profesors")
public class Profesor{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idProfesor",nullable=false)
	private Long id;
	
	@Column(name="codigoProfesor", nullable=false)
	private String codigo;

	@Column(name="nombreProfesor", nullable=false)
	private String nombre;
	
	@Column(name="apellidoProfesor",nullable=false)
	private String apellido;
	
	@Column(name="notaProfesor", nullable=true)
	private int nota;
	
	@Column(name="gradoProfesor",nullable=true)
	private String grado;
	
	@Column(name="calificacionProfesor", nullable=true)
	private double calificacion;
	
	@Column(name="telefonoProfesor",nullable=false)
	private String telefono;
	
	@Column(name="emailProfesor", nullable=false)
	private String email;

	@Column(name="passwordProfesor", nullable=false)
	private String password;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
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
