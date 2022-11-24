package br.com.ada.livraria.model.administrativo.repository;

import java.util.Map;

public interface Repository<K, T> {
	/**
	 * Consulta um determinado objeto.
	 * @param id Id do objeto a consultar.
	 * @return determinado objeto solicitado.
	 */
	public abstract T consultar(K id);
	
	/**
	 * Remove um determinado objeto.
	 * @param id Id do objeto a alterar.
	 */
	public abstract void remover(K id);
	
	/**
	 * Adiciona um novo objeto.
	 * @param objeto objeto a se adicionar.
	 */
	public abstract void adicionar(T objeto);
	
	/**
	 * Altera o valor de um determinado objeto.
	 * @param id Id do objeto a alterar.
	 * @param objeto objeto a se alterar.
	 */
	public abstract void alterar(K id, T objeto);

	/**
	 * Retorna todos objetos cadastrados.
	 */
	public abstract Map<K, T> getTodos();
}
