package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAlumno",nullable=false)
	private Long id;
	
	
	@Column(name="codigoAlumno", nullable=false)
	private String codigo;

	@Column(name="nombreAlumno", nullable=false)
	private String nombre;
	
	@Column(name="apellidoAlumno",nullable=false)
	private String apellido;
	
	@Column(name="emailAlumno", nullable=false)
	private String email;
	
	@Column(name="passwordAlumno", nullable=false)
	private String password;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
}
