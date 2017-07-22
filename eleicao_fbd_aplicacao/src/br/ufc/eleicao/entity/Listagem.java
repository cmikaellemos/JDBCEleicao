package br.ufc.eleicao.entity;

public class Listagem {
	private int num_votacao;
	private double ano;
	private String descricao;
	private String nome_partido;
	private int num_cand;
	private String nome;
	
	public Listagem() {
		// TODO Auto-generated constructor stub
	}
	

	public Listagem(int num_votacao, double ano, String descricao,
			String nome_partido, int num_cand, String nome) {
		this.num_votacao = num_votacao;
		this.ano = ano;
		this.descricao = descricao;
		this.nome_partido = nome_partido;
		this.num_cand = num_cand;
		this.nome = nome;
	}


	public int getNum_votacao() {
		return num_votacao;
	}

	public void setNum_votacao(int num_votacao) {
		this.num_votacao = num_votacao;
	}

	public double getAno() {
		return ano;
	}

	public void setAno(double ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome_partido() {
		return nome_partido;
	}

	public void setNome_partido(String nome_partido) {
		this.nome_partido = nome_partido;
	}

	public int getNum_cand() {
		return num_cand;
	}

	public void setNum_cand(int num_cand) {
		this.num_cand = num_cand;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Listagem [num_votacao=" + num_votacao + ", ano=" + ano
				+ ", descricao=" + descricao + ", nome_partido=" + nome_partido
				+ ", num_cand=" + num_cand + ", nome=" + nome + "]";
	}


}
