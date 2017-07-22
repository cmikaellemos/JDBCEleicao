package br.ufc.eleicao;

import java.util.List;

import br.ufc.eleicao.entity.Candidato;


public interface CandidatoDAO {

	public void save(Candidato entity, int opc);
	
	public void delete(int num_titulo);
	
	public Candidato find(int num_titulo);
	
	public List<Candidato> find();
	
	public List<Candidato> findByNumero(int num_candidato);
	
	public List<Candidato> findByCPF(String str);
}
