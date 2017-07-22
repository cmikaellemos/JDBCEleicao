package br.ufc.eleicao.entity;

public class Eleitor {

	private int num_titulo;
	private int urna;
	private String nome;
	private java.sql.Date data_nascimento;
	private String sexo;
	
	public Eleitor() {
		// TODO Auto-generated constructor stub
	}
	public Eleitor(int urna, String nome,java.sql.Date data_nascimento, String sexo) {
		this.urna = urna;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.sexo = sexo;
	}

	public int getNum_titulo() {
		return num_titulo;
	}

	public void setNum_titulo(int num_titulo) {
		this.num_titulo = num_titulo;
	}
	
	public int getUrna() {
		return urna;
	}

	public void setUrna(int urna) {
		this.urna = urna;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public java.sql.Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(java.sql.Date data) {
		this.data_nascimento = data;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Eleitor [num_titulo=" + num_titulo + ", urna=" + urna
				+ ", nome=" + nome + ", data_nascimento=" + data_nascimento
				+ ", sexo=" + sexo + "]";
	}


}
