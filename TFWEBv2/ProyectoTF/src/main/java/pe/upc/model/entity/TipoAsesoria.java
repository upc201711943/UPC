package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoAsesoria")
public class TipoAsesoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigoTipo",nullable=false)
	private Long codigo;
	
	@Column(name="nombreTipo",nullable=false)
	private String nombre;
	
	@Column(name="precioTipo",nullable=false)
	private float precio;

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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

}
