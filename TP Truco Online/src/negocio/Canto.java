package negocio;

import dao.CantoDAO;
import dto.CantoDTO;
import enumeraciones.TipoCanto;
import excepciones.ComunicacionException;

public class Canto {
	private int id;
	private Boolean querido; //TODO Inicializarlo en null.
	private TipoCanto tipoCanto;
	private int cantante;
	
	public Canto(int cantante) {
		this.cantante = cantante;
		this.querido = null;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setQuerido(Boolean querido) {
		this.querido = querido;
	}

	public void setTipoCanto(TipoCanto tipoCanto) {
		this.tipoCanto = tipoCanto;
	}

	public void setCantante(int cantante) {
		this.cantante = cantante;
	}

	public int getId() {
		return id;
	}

	public Boolean isQuerido() {
		return querido;
	}

	public TipoCanto getTipoCanto() {
		return tipoCanto;
	}

	public int getCantante() {
		return cantante;
	}

	public void grabar() {
		CantoDAO.getInstancia().grabar(this);
	}
	
	public void crear() throws ComunicacionException {
		Integer id = CantoDAO.getInstancia().crear(this);
		if (id != null) this.id = id;
		else throw new ComunicacionException("Hubo un error al crear el canto");
	}

	public CantoDTO toDTO() {
		if (this.querido == null) return (new CantoDTO(this.getId(),
				this.getTipoCanto().getId(),this.getTipoCanto().getNombre(),this.getTipoCanto().getValor(),
				this.getCantante()));
		else return (new CantoDTO(this.getId(),this.querido,
				this.getTipoCanto().getId(),this.getTipoCanto().getNombre(),this.getTipoCanto().getValor(),
				this.getCantante()));
	}
}
