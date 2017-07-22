package br.ufc.eleicao.entity;

public class Candidato {

	private int num_titulo;
	private String cpf;
	private int cod_partido;
	private int num_candidato;
	
	public Candidato() {}

	public Candidato(int num_titulo, String cpf, int cod_partido, int num_candidato){
		this.num_titulo = num_titulo;
		this.cpf = cpf;
		this.cod_partido = cod_partido;
		this.num_candidato = num_candidato;
	}

	public int getNum_titulo() {
		return num_titulo;
	}

	public void setNum_titulo(int num_titulo) {
		this.num_titulo = num_titulo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getCod_partido() {
		return cod_partido;
	}

	public void setCod_partido(int cod_partido) {
		this.cod_partido = cod_partido;
	}

	public int getNum_candidato() {
		return num_candidato;
	}

	public void setNum_candidato(int num_candidato) {
		this.num_candidato = num_candidato;
	}

	@Override
	public String toString() {
		return "Candidato [num_titulo=" + num_titulo + ", cpf=" + cpf
				+ ", cod_partido=" + cod_partido + ", num_candidato="
				+ num_candidato + "]";
	}
	
}
