package br.ufc.eleicao;

import java.util.List;

import br.ufc.eleicao.entity.Voto;

public interface VotoDAO {

	public void save(Voto entity, int opc);
	
	public void delete(int num_votacao, int num_titulo);
	
	public Voto find(int num_votacao, int num_titulo);
	
	public List<Voto> find();
	
	public List<Voto> findByNum_vot(int num);
	
	public List<Voto> findByNum_titulo(int num);
	
	public List<Voto> findByNum_cand(int num);
}
