package br.ufc.eleicao.entity;

public class Fiscal {

	private int num_titulo;
	private String cpf;
	private String cpf_super;
	private int urna;
	
	public Fiscal() {}
	
	public Fiscal(int num_titulo, String cpf, String cpf_super, int urna){
		this.num_titulo = num_titulo;
		this.cpf = cpf;
		this.cpf_super = cpf_super;
		this.urna = urna;
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

	public String getCpf_super() {
		return cpf_super;
	}

	public void setCpf_super(String cpf_super) {
		this.cpf_super = cpf_super;
	}
	
	public int getUrna() {
		return urna;
	}

	public void setUrna(int urna) {
		this.urna = urna;
	}

	@Override
	public String toString() {
		return "Fiscal [num_titulo=" + num_titulo + ", urna=" + urna + ", cpf="
				+ cpf + ", cpf_super=" + cpf_super + "]";
	}
	

	


	
}
