package br.com.ada.livraria.model.administrativo.repository.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import br.com.ada.livraria.model.produto.Jogo;
import br.com.ada.livraria.model.administrativo.estoque.Estoque;
import br.com.ada.livraria.model.administrativo.repository.Repository;

public class EstoqueJogo extends Estoque implements Repository<Integer, Jogo> {
	private Map<Integer, Jogo> jogos = new HashMap<>();
	
	public void remover(Integer id) {
		jogos.remove(id);
	}

	public void adicionar(Jogo jogo) {
		jogo.setId(contadorId);
		jogos.put(contadorId++, jogo);
	}
	
	public Jogo consultar(Integer id) {
		return jogos.get(id);
	}
	
	public void alterar(Integer id, Jogo jogo) {
		jogos.replace(id, jogo);
	}

	public Map<Integer, Jogo> getTodos() {
		return Collections.unmodifiableMap(jogos);
	}
}
