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
@Table(name="Asesoria")
public class Asesoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigoAsesoria",nullable=false)
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name="codigoTipoAsesoria",nullable=false)
	private TipoAsesoria tipo_asesoria;
	
	@ManyToOne
	@JoinColumn(name="codigoSeccion",nullable=false)
	private Seccion seccion;

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoAsesoria getTipo_asesoria() {
		return tipo_asesoria;
	}

	public void setTipo_asesoria(TipoAsesoria tipo_asesoria) {
		this.tipo_asesoria = tipo_asesoria;
	}

	
}
