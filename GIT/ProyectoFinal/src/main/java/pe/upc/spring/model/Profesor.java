package pe.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Profesor")
public class Profesor implements Serializable{
	
	private static final long serialVersionUID=4L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idProfesor",nullable=false)
	private Long idProfesor;
	
	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="codigoProfesor", nullable=false)
	private String codigoProfesor;

	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="nombreProfesor", nullable=false)
	private String nombreProfesor;
	
	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="apellidoProfesor",nullable=false)
	private String apellidoProfesor;
	
	@Email
	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="emailProfesor", nullable=false)
	private String emailProfesor;
	
	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="passwordProfesor", nullable=false)
	private String passwordProfesor;

	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="telefonoProfesor",nullable=false)
	private String telefonoProfesor;

	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="gradoProfesor",nullable=false)
	private String gradoProfesor;

	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="descripcionProfesor",nullable=false)
	private String descripcionProfesor;

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(Long idProfesor,String codigoProfesor,	String nombreProfesor,String apellidoProfesor,String emailProfesor,
			String passwordProfesor,String telefonoProfesor,String gradoProfesor,String descripcionProfesor) {
		super();
		this.idProfesor = idProfesor;
		this.codigoProfesor = codigoProfesor;
		this.nombreProfesor = nombreProfesor;
		this.apellidoProfesor = apellidoProfesor;
		this.emailProfesor = emailProfesor;
		this.passwordProfesor = passwordProfesor;
		this.telefonoProfesor = telefonoProfesor;
		this.gradoProfesor = gradoProfesor;
		this.descripcionProfesor = descripcionProfesor;
	}

	public Long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getCodigoProfesor() {
		return codigoProfesor;
	}

	public void setCodigoProfesor(String codigoProfesor) {
		this.codigoProfesor = codigoProfesor;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public String getApellidoProfesor() {
		return apellidoProfesor;
	}

	public void setApellidoProfesor(String apellidoProfesor) {
		this.apellidoProfesor = apellidoProfesor;
	}

	public String getEmailProfesor() {
		return emailProfesor;
	}

	public void setEmailProfesor(String emailProfesor) {
		this.emailProfesor = emailProfesor;
	}

	public String getPasswordProfesor() {
		return passwordProfesor;
	}

	public void setPasswordProfesor(String passwordProfesor) {
		this.passwordProfesor = passwordProfesor;
	}

	public String getTelefonoProfesor() {
		return telefonoProfesor;
	}

	public void setTelefonoProfesor(String telefonoProfesor) {
		this.telefonoProfesor = telefonoProfesor;
	}

	public String getGradoProfesor() {
		return gradoProfesor;
	}

	public void setGradoProfesor(String gradoProfesor) {
		this.gradoProfesor = gradoProfesor;
	}

	public String getDescripcionProfesor() {
		return descripcionProfesor;
	}

	public void setDescripcionProfesor(String descripcionProfesor) {
		this.descripcionProfesor = descripcionProfesor;
	}
	

	
}
