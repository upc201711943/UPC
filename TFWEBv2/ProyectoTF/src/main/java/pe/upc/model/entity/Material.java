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
@Table(name="Material")
public class Material {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigoMaterial",nullable=false)
	private Long codigo;
	
	@Column(name="nombreMaterial",nullable=false)
	private String nombre;
	
	@Column(name="contenidoMaterial",nullable=false)
	private String contenido;

	private boolean disponibilidad;
	
	@Column(name="codigoTipoMaterial",nullable=false)
	private TipoMaterial tipo_material;


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

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public TipoMaterial getTipo_material() {
		return tipo_material;
	}

	public void setTipo_material(TipoMaterial tipo_material) {
		this.tipo_material = tipo_material;
	}
	
}
