package model.vo.vacinas;

public class Pessoa {

	private int id;
	private String nome;
	private String dtNascimento;
	private String sexo;
	private String cpf;
	private TipoPessoa tipoPessoa;
	private double notaVacina;
	
	public Pessoa() {
		super();
	}

	
	
	public Pessoa(String nome, String dtNascimento, String sexo, String cpf, TipoPessoa tipoPessoa, double notaVacina) {
		super();
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.tipoPessoa = tipoPessoa;
		this.notaVacina = notaVacina;
	}



	public Pessoa(int id, String nome, String dtNascimento, String sexo, String cpf, TipoPessoa tipoPessoa,
			double notaVacina) {
		super();
		this.id = id;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.tipoPessoa = tipoPessoa;
		this.notaVacina = notaVacina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public double getNotaVacina() {
		return notaVacina;
	}

	public void setNotaVacina(double notaVacina) {
		this.notaVacina = notaVacina;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", dtNascimento=" + dtNascimento + ", sexo=" + sexo + ", cpf="
				+ cpf + ", tipoPessoa=" + tipoPessoa + ", notaVacina=" + notaVacina + "]";
	}
	
	
}
