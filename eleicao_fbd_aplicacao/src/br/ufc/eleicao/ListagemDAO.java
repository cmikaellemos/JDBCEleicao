package br.ufc.eleicao;

import java.util.List;

import br.ufc.eleicao.entity.Listagem;

public interface ListagemDAO {
	
	public List<Listagem> find();
	
	public List<Listagem> findByNum_vot(int num);
	
	public List<Listagem> findByAno(double num);
	
	public List<Listagem> findByDesc(String str);
	
	public List<Listagem> findByPartido(String str);
	
	public List<Listagem> findByNum_cand(int num);
	
	public List<Listagem> findByNome(String str);
}
