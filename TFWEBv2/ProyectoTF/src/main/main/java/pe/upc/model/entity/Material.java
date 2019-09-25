package pe.upc.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="materiales")
public class Material {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMaterial",nullable=false)
	private Long id;
	
	@Column(name="nombreMaterial",nullable=false)
	private String nombre;
	
	@Column(name="contenidoMaterial",nullable=false)
	private String contenido;

	private boolean disponibilidad;
	
	@ManyToOne
	@JoinColumn(name="codigoTipoMaterial",nullable=false)
	private TipoMaterial tipoMaterial;


	@ManyToOne
	@JoinColumn(name="codigoSeccion",nullable=false)
	private Seccion seccion;
	
	

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id= id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public TipoMaterial getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(TipoMaterial tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}
	
}