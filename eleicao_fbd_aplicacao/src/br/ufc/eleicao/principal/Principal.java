package br.ufc.eleicao.principal;

import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufc.eleicao.*;
import br.ufc.eleicao.entity.*;

public class Principal {

	public static void main(String[] args) throws ParseException {
		EleitorDAO Eleitores = new EleitorJDBCDAO();
		CandidatoDAO Candidatos = new CandidatoJDBCDAO();
		FiscalDAO Fiscais = new FiscalJDBCDAO();
		VotoDAO Votos = new VotoJDBCDAO();
		ListagemDAO listas = new ListagemJDBCDAO();
		String menu = "Escolha uma opção:\n1 - Eleitor\n2 - Candidato\n3 - Fiscal\n4 - Votos\n5 - Listagem Candidato\n6 - Sair";
		String menu1 = "Escolha uma opção:\n1 - Inserir\n2 - Atualizar por NUM_TITULO\n3 - Remover por NUM_TITULO\n4 - Exibir por NUM_TITULO\n5 - Exibir por URNA\n6 - Exibir todos\n7 - Exibir todos que contem determinado nome\n8 - Voltar";
		String menu2 = "Escolha uma opção:\n1 - Inserir\n2 - Atualizar por NUM_TITULO\n3 - Remover por NUM_TITULO\n4 - Exibir por NUM_TITULO\n5 - Exibir por CPF\n6 - Exibir por NUMERO\n7 - Exibir todos\n8 - Voltar ";
		String menu3 = "Escolha uma opção:\n1 - Inserir\n2 - Atualizar por NUM_TITULO\n3 - Remover por NUM_TITULO\n4 - Exibir por NUM_TITULO\n5 - Exibir por CPF\n6 - Exibir por urna que fiscaliza\n7 - Exibir todos\n8 - Voltar";
		String menu4 = "Escolha uma opção:\n1 - Inserir\n2 - Atualizar por NUM_VOTACAO E NUM_TITULO\n3 - Remover por NUM_VOTACAO E NUM_TITULO\n4 - Exibir por NUM_TITULO\n5 - Exibir por NUM_VOTACAO\n6 - Exibir por NUM_CANDIDATO\n7 - Exibir todos\n8 - Voltar";
		String menu5 = "Escolha uma opção:\n1 - Exibir por NOME\n2 - Exibir por NUM_VOTACAO\n3 - Exibir por ANO\n4 - Exibir por DESCRICAO\n5 - Exibir por NOME_PARTIDO\n6 - Exibir por NUM_CANDIDATO\n7 - Exibir Todos\n8 - Voltar";
		char opcao, opcao1, opcao2, opcao3, opcao4, opcao5;
		do {
			Eleitor cl;
			Candidato ca;
			Fiscal f;
			Voto v;
			int num_titulo = 0;
			int num_vot = 0;
			String str;
			opcao = JOptionPane.showInputDialog(menu).charAt(0);
			switch(opcao) {
			case '1':
				opcao1 = JOptionPane.showInputDialog(menu1).charAt(0);
				switch (opcao1) {
				case '1':     // Inserir
					cl = new Eleitor();
					obterEleitor(cl);
					Eleitores.save(cl, 1);
					break;
				case '2':     // Atualizar por NUM_TITULO
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("Digite o NUM_TITULO do eleitor a ser alterado"));
					cl = Eleitores.find(num_titulo);
					obterEleitor(cl);
					Eleitores.save(cl, 2);
					break;
				case '3':     // Remover por NUM_TITULO
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("NUM_TITULO"));
					cl = Eleitores.find(num_titulo);
					if (cl != null) {
						Eleitores.delete(cl.getNum_titulo());
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o eleitor não foi encontrado.");
					}
					break;
				case '4':     // Exibir por NUM_TITULO
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("NUM_TITULO"));
					cl = Eleitores.find(num_titulo);
					listaEleitor(cl);
					break;
				case '5':     // Exibir por urna
					int urna = Integer.parseInt(JOptionPane.showInputDialog("Urna"));
					listaEleitores(Eleitores.findByUrna(urna));
					break;
				case '6':     // Exibir todos
					listaEleitores(Eleitores.find());
					break;
				case '7':     // Exibir todos que contem determinado nome
					String nome = JOptionPane.showInputDialog("Nome");
					listaEleitores(Eleitores.findByNome(nome));
					break;
				case '8':     // Sair
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida");
					break;
				}
			case '2':
				opcao2 = JOptionPane.showInputDialog(menu2).charAt(0);
				switch(opcao2){
				case '1':
					ca = new Candidato();
					obterCandidato(ca);
					Candidatos.save(ca, 1);
					break;
				case '2':     // Atualizar por NUM_TITULO
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("Digite o NUM_TITULO do candidato a ser alterado"));
					ca = Candidatos.find(num_titulo);
					obterCandidato(ca);
					Candidatos.save(ca, 2);
					break;
				case '3':     // Remover por NUM_TITULO
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("NUM_TITULO"));
					ca = Candidatos.find(num_titulo);
					if (ca != null) {
						Candidatos.delete(ca.getNum_titulo());
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o candidato não foi encontrado.");
					}
					break;
				case '4':     // Exibir por NUM_TITULO
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("NUM_TITULO"));
					ca = Candidatos.find(num_titulo);
					listaCandidato(ca);
					break;
				case '5':     // Exibir por cpf
					String cpf = JOptionPane.showInputDialog("CPF", '0');
					listaCandidatos(Candidatos.findByCPF(cpf));
					break;
				case '6':     // Exibir por Numero
					int numero = Integer.parseInt(JOptionPane.showInputDialog("Numero Candidato", 0));
					listaCandidatos(Candidatos.findByNumero(numero));
					break;
				case '7':     // Exibir todos
					listaCandidatos(Candidatos.find());
					break;
				case '8':     // Sair
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida");
					break;
				
				}
			case '3':
				opcao3 = JOptionPane.showInputDialog(menu3).charAt(0);
				switch(opcao3){
				case '1':  //Inserir
					f = new Fiscal();
					obterFiscal(f);
					Fiscais.save(f, 1);
					break;
				case '2':     // Atualizar por NUM_TITULO
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("Digite o NUM_TITULO do fiscal a ser alterado"));
					f = Fiscais.find(num_titulo);
					obterFiscal(f);
					Fiscais.save(f, 2);
					break;
				case '3':     // Remover por NUM_TITULO
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("NUM_TITULO"));
					f = Fiscais.find(num_titulo);
					if (f != null) {
						Fiscais.delete(f.getNum_titulo());
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o candidato não foi encontrado.");
					}
					break;
				case '4':     // Exibir por NUM_TITULO
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("NUM_TITULO"));
					f = Fiscais.find(num_titulo);
					listaFiscal(f);
					break;
				case '5':     // Exibir por cpf
					String cpf = JOptionPane.showInputDialog("CPF", '0');
					listaFiscais(Fiscais.findByCpf(cpf));
					break;
				case '6':     // Exibir por Urna
					int urna = Integer.parseInt(JOptionPane.showInputDialog("Urna", 0));
					listaFiscais(Fiscais.findByUrna(urna));
					break;
				case '7':     // Exibir todos
					listaFiscais(Fiscais.find());
					break;
				case '8':     // Sair
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida");
					break;	
				}
			case '4':
				opcao4 = JOptionPane.showInputDialog(menu4).charAt(0);
				switch (opcao4) {
				case '1':     // Inserir
					v = new Voto();
					obterVoto(v);
					Votos.save(v, 1);
					break;
				case '2':     // Atualizar por NUM_VOTACAO E NUM_TITULO
					num_vot = Integer.parseInt(JOptionPane.showInputDialog("NUM_VOTACAO"));
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("NUM_TITULO"));
					v = Votos.find(num_vot, num_titulo);
					obterVoto(v);
					Votos.save(v, 2);
					break;
				case '3':     // Remover por NUM_VOTACAO E NUM_TITULO
					num_vot = Integer.parseInt(JOptionPane.showInputDialog("NUM_VOTACAO"));
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("NUM_TITULO"));
					v = Votos.find(num_vot, num_titulo);
					if (v != null) {
						Votos.delete(v.getNum_votacao(), v.getNum_titulo());
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o eleitor não foi encontrado.");
					}
					break;
				case '4':     // Exibir por NUM_TITULO
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("Numero titulo"));
					listaVotos(Votos.findByNum_titulo(num_titulo));
					break;
				case '5':     // Exibir por NUM_VOTACAO
					num_vot = Integer.parseInt(JOptionPane.showInputDialog("Numero votacao"));
					listaVotos(Votos.findByNum_vot(num_vot));
					break;
				case '6':     // Exibir por NUM_CANDIDATO
					num_vot = Integer.parseInt(JOptionPane.showInputDialog("Numero candidato"));
					listaVotos(Votos.findByNum_cand(num_vot));
					break;
				case '7':     // Exibir todos
					listaVotos(Votos.find());
					break;
				case '8':     // Sair
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida");
					break;
				}
			case '5':
				opcao5 = JOptionPane.showInputDialog(menu5).charAt(0);
				switch(opcao5){
				case '1':  //Exibir por nome
					str = JOptionPane.showInputDialog("Nome");
					listaListas(listas.findByNome(str));
					break;
				case '2':     // Exibir por num_vot
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("Numero Votacao"));
					listaListas(listas.findByNum_vot(num_titulo));
					break;
				case '3':     // Exibir por ano
					double ano = Double.parseDouble(JOptionPane.showInputDialog("Ano"));
					listaListas(listas.findByAno(ano));
					break;
				case '4':     // Exibir por descricao
					str = JOptionPane.showInputDialog("Descricao");
					listaListas(listas.findByDesc(str));
					break;
				case '5':     // Exibir por partido
					str = JOptionPane.showInputDialog("Nome partido");
					listaListas(listas.findByPartido(str));
					break;
				case '6':     // Exibir por Num_cand
					num_titulo = Integer.parseInt(JOptionPane.showInputDialog("Numero Candidato"));
					listaListas(listas.findByNum_cand(num_titulo));
					break;
				case '7':     // Exibir todos
					listaListas(listas.find());
					break;
				case '8':     // Sair
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida");
					break;	
				}
			}
			
		} while(opcao != '6');
	}
	
	
	public static void obterEleitor(Eleitor cl) {
		int num_titulo = Integer.parseInt(JOptionPane.showInputDialog("Numero Titulo", cl.getNum_titulo()));
		int urna = Integer.parseInt(JOptionPane.showInputDialog("Urna", cl.getUrna()));
		String nome = JOptionPane.showInputDialog("Nome", cl.getNome());
		String data_s = JOptionPane.showInputDialog("Data Nascimento", cl.getData_nascimento());
		java.sql.Date data = java.sql.Date.valueOf(data_s);
		String sexo = JOptionPane.showInputDialog("Sexo", cl.getSexo());
		cl.setNum_titulo(num_titulo);
		cl.setUrna(urna);
		cl.setNome(nome);
		cl.setData_nascimento(data);
		cl.setSexo(sexo);
	
	}

	public static void obterCandidato(Candidato c) {
		int num_titulo = Integer.parseInt(JOptionPane.showInputDialog("Numero Titulo", c.getNum_titulo()));
		String cpf = JOptionPane.showInputDialog("Cpf", c.getCpf());
		int cod_partido = Integer.parseInt(JOptionPane.showInputDialog("Codigo Partido", c.getCod_partido()));
		int num_candidato = Integer.parseInt(JOptionPane.showInputDialog("Numero Candidato", c.getNum_candidato()));
		c.setNum_titulo(num_titulo);
		c.setCpf(cpf);
		c.setCod_partido(cod_partido);
		c.setNum_candidato(num_candidato);
	}
	
	public static void obterFiscal(Fiscal f) {
		int num_titulo = Integer.parseInt(JOptionPane.showInputDialog("Numero Titulo", f.getNum_titulo()));
		String cpf = JOptionPane.showInputDialog("Cpf", f.getCpf());
		String cpf_super = JOptionPane.showInputDialog("Cpf_super", f.getCpf_super());
		f.setNum_titulo(num_titulo);
		f.setCpf(cpf);
		f.setCpf_super(cpf_super);
	}
	
	public static void obterVoto(Voto v) {
		int num_vot = Integer.parseInt(JOptionPane.showInputDialog("Numero Votacao", v.getNum_titulo()));
		int num_titulo = Integer.parseInt(JOptionPane.showInputDialog("Numero Titulo", v.getNum_titulo()));
		int num_cand = Integer.parseInt(JOptionPane.showInputDialog("Numero Candidato", v.getNum_titulo()));
		v.setNum_votacao(num_vot);
		v.setNum_titulo(num_titulo);
		v.setNum_candidato(num_cand);
	}
	
	public static void listaEleitores (List<Eleitor> eleitores) {
		StringBuilder listagem = new StringBuilder();
		for(Eleitor cl : eleitores) {
			listagem.append(cl).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum eleitor encontrado" : listagem);
	}

	public static void listaEleitor (Eleitor cl) {
		JOptionPane.showMessageDialog(null, cl == null ? "Nenhum eleitor encontrado" : cl);
	}
	
	public static void listaCandidatos (List<Candidato> candidatos) {
		StringBuilder listagem = new StringBuilder();
		for(Candidato ca : candidatos) {
			listagem.append(ca).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum candidato encontrado" : listagem);
	}

	public static void listaCandidato (Candidato ca) {
		JOptionPane.showMessageDialog(null, ca == null ? "Nenhum candidato encontrado" : ca);
	}
	
	public static void listaFiscais (List<Fiscal> fiscais) {
		StringBuilder listagem = new StringBuilder();
		for(Fiscal f : fiscais) {
			listagem.append(f).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum eleitor encontrado" : listagem);
	}

	public static void listaFiscal (Fiscal f) {
		JOptionPane.showMessageDialog(null, f == null ? "Nenhum fiscal encontrado" : f);
	}

	public static void listaVotos (List<Voto> votos) {
		StringBuilder listagem = new StringBuilder();
		for(Voto v : votos) {
			listagem.append(v).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum candidato encontrado" : listagem);
	}

	public static void listaVoto (Voto v) {
		JOptionPane.showMessageDialog(null, v == null ? "Nenhum candidato encontrado" : v);
	}
	
	public static void listaListas (List<Listagem> listas) {
		StringBuilder listagem = new StringBuilder();
		for(Listagem li : listas) {
			listagem.append(li).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum candidato encontrado" : listagem);
	}
}
