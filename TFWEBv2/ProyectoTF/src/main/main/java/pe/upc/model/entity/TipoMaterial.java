package pe.upc.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipomateriales")
public class TipoMaterial {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTipo",nullable=false)
	private Long id;
	
	@Column(name="nombreTipo",nullable=false)
	private String nombre;
	
	@Column(name="precioTipo",nullable=false)
	private float precio;

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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

}
