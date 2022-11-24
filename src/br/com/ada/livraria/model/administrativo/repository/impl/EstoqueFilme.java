package br.com.ada.livraria.model.administrativo.repository.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import br.com.ada.livraria.model.produto.Filme;
import br.com.ada.livraria.model.administrativo.estoque.Estoque;
import br.com.ada.livraria.model.administrativo.repository.Repository;

public class EstoqueFilme extends Estoque implements Repository<Integer, Filme> {
	private Map<Integer, Filme> filmes = new HashMap<>();
	
	public void remover(Integer id) {
		filmes.remove(id);
	}

	public void adicionar(Filme filme) {
		filme.setId(contadorId);
		filmes.put(contadorId++, filme);
	}
	
	public Filme consultar(Integer id) {
		return filmes.get(id);
	}
	
	public void alterar(Integer id, Filme filme) {
		filmes.replace(id, filme);
	}

	public Map<Integer, Filme> getTodos() {
		return Collections.unmodifiableMap(filmes);
	}
}
