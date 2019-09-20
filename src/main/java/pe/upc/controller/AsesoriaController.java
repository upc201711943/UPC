package pe.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.TipoAsesoriaBusiness;
import pe.upc.business.AsesoriaBusiness;
import pe.upc.model.entity.Asesoria;
import pe.upc.model.entity.Seccion;
import pe.upc.model.entity.TipoAsesoria;
import pe.upc.util.Message;

@Named
@SessionScoped
public class AsesoriaController {

	private static final long serialVersionUID = 1L;

	@Inject
	private AsesoriaBusiness asesoriaBusiness;

	@Inject
	private TipoAsesoriaBusiness tipoAsesoriaBusiness;

	private Asesoria asesoria;
	private List<Asesoria> asesorias;
	private Asesoria productSelect;

	private TipoAsesoria tipoAsesoria;
	private List<TipoAsesoria> tipoAsesorias;

	private Seccion seccion;
	private List<Seccion> secciones;

	private String filterName;

	@PostConstruct
	public void init() {
		asesoria=new Asesoria();
		asesorias=new ArrayList<Asesoria>();
		
		tipoAsesoria=new TipoAsesoria();
		tipoAsesorias=new ArrayList<TipoAsesoria>();
		
		seccion=new Seccion();
		secciones =new ArrayList<Seccion>();
		
	}
	public void ListarAsesoriasxSeccion(Seccion seccion) {
		
		try {
			asesorias=asesoriaBusiness.listarAsesoriaxSeccion(seccion);
		}catch(Exception e){
			Message.messageError("Error Carga de Asesorias:" + e.getMessage());
		}
		
	}
	
	
	
}
