package br.ufc.eleicao;

import java.util.List;

import br.ufc.eleicao.entity.Fiscal;
public interface FiscalDAO {

	public void save(Fiscal entity, int opc);
	
	public void delete(int num_titulo);
	
	public Fiscal find(int num_titulo);
	
	public List<Fiscal> find();
	
	public List<Fiscal> findByCpf(String str);
	
	public List<Fiscal> findByNum_titulo(int num);
	
	public List<Fiscal> findByUrna(int urna);
}
