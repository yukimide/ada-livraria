package br.com.ada.livraria.model.administrativo.repository.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import br.com.ada.livraria.model.produto.Album;
import br.com.ada.livraria.model.administrativo.estoque.Estoque;
import br.com.ada.livraria.model.administrativo.repository.Repository;

public class EstoqueAlbum extends Estoque implements Repository<Integer, Album> {
	private Map<Integer, Album> albums = new HashMap<>();
	
	public void remover(Integer id) {
		albums.remove(id);
	}

	public void adicionar(Album album) {
		album.setId(contadorId);
		albums.put(contadorId++, album);
	}
	
	public Album consultar(Integer id) {
		return albums.get(id);
	}
	
	public void alterar(Integer id, Album album) {
		albums.replace(id, album);
	}

	public Map<Integer, Album> getTodos() {
		return Collections.unmodifiableMap(albums);
	}
}
