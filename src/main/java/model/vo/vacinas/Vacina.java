package model.vo.vacinas;

public class Vacina {

	private int id;
	private String estagio;
	private String dtinicio;
	private String nomepesquisador;
	
	public Vacina() {
		super();
	}

	
	public Vacina(String estagio, String dtinicio, String nomepesquisador) {
		super();
		this.estagio = estagio;
		this.dtinicio = dtinicio;
		this.nomepesquisador = nomepesquisador;
	}


	public Vacina(int id, String estagio, String dtinicio, String nomepesquisador) {
		super();
		this.id = id;
		this.estagio = estagio;
		this.dtinicio = dtinicio;
		this.nomepesquisador = nomepesquisador;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEstagio() {
		return estagio;
	}


	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}


	public String getDtinicio() {
		return dtinicio;
	}


	public void setDtinicio(String dtinicio) {
		this.dtinicio = dtinicio;
	}


	public String getNomepesquisador() {
		return nomepesquisador;
	}


	public void setNomepesquisador(String nomepesquisador) {
		this.nomepesquisador = nomepesquisador;
	}


	@Override
	public String toString() {
		return "Vacina [id=" + id + ", estagio=" + estagio + ", dtinicio=" + dtinicio + ", nomepesquisador="
				+ nomepesquisador + "]";
	}
	
	
	
}
