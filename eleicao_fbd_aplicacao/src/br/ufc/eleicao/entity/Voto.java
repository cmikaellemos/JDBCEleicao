package br.ufc.eleicao.entity;

public class Voto {

	private int num_votacao;
	private int num_titulo;
	private int num_candidato;
	
	public Voto() {
		// TODO Auto-generated constructor stub
	}
	
	public Voto(int num_votacao, int num_titulo, int num_candidato){
		this.num_votacao = num_votacao;
		this.num_titulo = num_titulo;
		this.num_candidato = num_candidato;
	}

	public int getNum_votacao() {
		return num_votacao;
	}

	public void setNum_votacao(int num_votacao) {
		this.num_votacao = num_votacao;
	}

	public int getNum_titulo() {
		return num_titulo;
	}

	public void setNum_titulo(int num_titulo) {
		this.num_titulo = num_titulo;
	}

	public int getNum_candidato() {
		return num_candidato;
	}

	public void setNum_candidato(int num_candidato) {
		this.num_candidato = num_candidato;
	}

	@Override
	public String toString() {
		return "Voto [num_votacao=" + num_votacao + ", num_titulo="
				+ num_titulo + ", num_candidato=" + num_candidato + "]";
	}
	

}
