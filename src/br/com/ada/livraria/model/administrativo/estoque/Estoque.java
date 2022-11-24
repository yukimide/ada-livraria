package br.com.ada.livraria.model.administrativo.estoque;

import java.util.Map;
import java.util.HashMap;

import br.com.ada.livraria.model.produto.Produto;
import br.com.ada.livraria.model.administrativo.repository.impl.EstoqueJogo;
import br.com.ada.livraria.model.administrativo.repository.impl.EstoqueAlbum;
import br.com.ada.livraria.model.administrativo.repository.impl.EstoqueFilme;
import br.com.ada.livraria.model.administrativo.repository.impl.EstoqueLivro;
import br.com.ada.livraria.model.administrativo.repository.impl.EstoqueBrinquedo;

/**
 * Classe responsável por gerenciar o estoque.
 */
public abstract class Estoque {
	public static int contadorId = 1;
	private static Map<Integer, Produto> produtos;

	// ESTOQUES
	public static EstoqueJogo jogo = new EstoqueJogo();
	public static EstoqueLivro livro = new EstoqueLivro();
	public static EstoqueAlbum album = new EstoqueAlbum();
	public static EstoqueFilme filme = new EstoqueFilme();
	public static EstoqueBrinquedo brinquedo = new EstoqueBrinquedo();

	// METODOS
	public static int getQuantidadeProduto(int id) {
		return consultarProduto(id).getQuantidade();
	}
	
	public static Produto consultarProduto(int id) {
		return getProdutos().get(id);
	}

	public static void removerQuantidadeProduto(int id) {
		Produto produto = getProdutos().get(id);
		
		int quantidade = produto.getQuantidade();
		getProdutos().get(id).setQuantidade(--quantidade);
	}
	
	public static Map<Integer, Produto> getProdutos() {
		produtos = new HashMap<>();
		
		produtos.putAll(jogo.getTodos());
		produtos.putAll(livro.getTodos());
		produtos.putAll(album.getTodos());
		produtos.putAll(filme.getTodos());
		produtos.putAll(brinquedo.getTodos());

		return produtos;
	}
}
