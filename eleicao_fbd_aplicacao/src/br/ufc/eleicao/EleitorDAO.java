package br.ufc.eleicao;

import java.util.List;

import br.ufc.eleicao.entity.Eleitor;

public interface EleitorDAO {
	
	public void save(Eleitor entity, int opc);
	
	public void delete(int num_titulo);
	
	public Eleitor find(int num_titulo);
	
	public List<Eleitor> find();
	
	public List<Eleitor> findByUrna(int urna);
	
	public List<Eleitor> findByNome(String str);
}
