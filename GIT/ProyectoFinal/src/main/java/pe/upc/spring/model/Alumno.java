package pe.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Alumno")
public class Alumno implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAlumno",nullable=false)
	private Long idAlumno;
	
	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="codigoAlumno", nullable=false)
	private String codigoAlumno;

	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="nombreAlumno", nullable=false)
	private String nombreAlumno;
	
	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="apellidoAlumno",nullable=false)
	private String apellidoAlumno;

	@Email
	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="emailAlumno", nullable=false)
	private String emailAlumno;
	
	@NotEmpty(message="No puedo estar vacío")
	@NotBlank(message="No puedo estar en blanco")
	@Column(name="passwordAlumno", nullable=false)
	private String passwordAlumno;

	@NotNull
	@Past(message="No puedes seleccionar un día que todavía NO EXISTE")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaAlumno",nullable=false)
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date fechaAlumno;

	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alumno(Long idAlumno,String codigoAlumno,String nombreAlumno,String apellidoAlumno,String emailAlumno,String passwordAlumno,Date fechaAlumno) {
		super();
		this.idAlumno = idAlumno;
		this.codigoAlumno = codigoAlumno;
		this.nombreAlumno = nombreAlumno;
		this.apellidoAlumno = apellidoAlumno;
		this.emailAlumno = emailAlumno;
		this.passwordAlumno = passwordAlumno;
		this.fechaAlumno = fechaAlumno;
	}

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getCodigoAlumno() {
		return codigoAlumno;
	}

	public void setCodigoAlumno(String codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getApellidoAlumno() {
		return apellidoAlumno;
	}

	public void setApellidoAlumno(String apellidoAlumno) {
		this.apellidoAlumno = apellidoAlumno;
	}

	public String getEmailAlumno() {
		return emailAlumno;
	}

	public void setEmailAlumno(String emailAlumno) {
		this.emailAlumno = emailAlumno;
	}

	public String getPasswordAlumno() {
		return passwordAlumno;
	}

	public void setPasswordAlumno(String passwordAlumno) {
		this.passwordAlumno = passwordAlumno;
	}

	public Date getFechaAlumno() {
		return fechaAlumno;
	}

	public void setFechaAlumno(Date fechaAlumno) {
		this.fechaAlumno = fechaAlumno;
	}
		
	
}
