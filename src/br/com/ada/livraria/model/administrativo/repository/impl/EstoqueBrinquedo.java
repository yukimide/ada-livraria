package br.com.ada.livraria.model.administrativo.repository.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import br.com.ada.livraria.model.produto.Brinquedo;
import br.com.ada.livraria.model.administrativo.estoque.Estoque;
import br.com.ada.livraria.model.administrativo.repository.Repository;

public class EstoqueBrinquedo extends Estoque implements Repository<Integer, Brinquedo> {
	private Map<Integer, Brinquedo> brinquedos = new HashMap<>();
	
	public void remover(Integer id) {
		brinquedos.remove(id);
	}

	public void adicionar(Brinquedo brinquedo) {
		brinquedo.setId(contadorId);
		brinquedos.put(contadorId++, brinquedo);
	}
	
	public Brinquedo consultar(Integer id) {
		return brinquedos.get(id);
	}
	
	public void alterar(Integer id, Brinquedo brinquedo) {
		brinquedos.replace(id, brinquedo);
	}

	public Map<Integer, Brinquedo> getTodos() {
		return Collections.unmodifiableMap(brinquedos);
	}
}
