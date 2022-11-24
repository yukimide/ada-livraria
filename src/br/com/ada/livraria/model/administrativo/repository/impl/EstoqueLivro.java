package br.com.ada.livraria.model.administrativo.repository.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import br.com.ada.livraria.model.produto.Livro;
import br.com.ada.livraria.model.administrativo.estoque.Estoque;
import br.com.ada.livraria.model.administrativo.repository.Repository;

public class EstoqueLivro extends Estoque implements Repository<Integer, Livro> {
	private Map<Integer, Livro> livros = new HashMap<>();
	
	public void remover(Integer id) {
		livros.remove(id);
	}

	public void adicionar(Livro livro) {
		livro.setId(contadorId);
		livros.put(contadorId++, livro);
	}
	
	public Livro consultar(Integer id) {
		return livros.get(id);
	}
	
	public void alterar(Integer id, Livro livro) {
		livros.replace(id, livro);
	}

	public Map<Integer, Livro> getTodos() {
		return Collections.unmodifiableMap(livros);
	}
}
