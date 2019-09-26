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
@Table(name = "asesorias")
public class Asesoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAsesoria",nullable=false)
	private Long id;
	
	@JoinColumn(name="nombreAsesoria",nullable=false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="codigoTipoAsesoria",nullable=false)
	private TipoAsesoria tipoAsesoria;
	
	@ManyToOne
	@JoinColumn(name="codigoSeccion",nullable=false)
	private Seccion seccion;
	

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

	public TipoAsesoria getTipoAsesoria() {
		return tipoAsesoria;
	}

	public void setTipoAsesoria(TipoAsesoria tipoAsesoria) {
		this.tipoAsesoria = tipoAsesoria;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	

	
}
