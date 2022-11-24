package br.com.ada.livraria.model.produto;

import java.util.Collections;
import java.util.List;

import br.com.ada.livraria.enumeration.GeneroLivroType;
import br.com.ada.livraria.enumeration.RestricaoType;

public class Livro extends Produto {
	private String estudio;
	private List<String> diretores;
	private List<String> produtores;
	private List<GeneroLivroType> generos;

	// CONSTRUTOR
	public Livro(
		String nome,
		double preco,
		int quantidade,
		List<String> diretores,
		List<String> produtores,
		List<GeneroLivroType> generos,
		RestricaoType restricao
	) {
		super(nome, preco, quantidade, restricao);
		
		this.generos = generos;
		this.diretores = diretores;
		this.produtores = produtores;
	}
	
	// GETTERS AND SETTERS
	public String getEstudio() {
		return estudio;
	}

	public List<String> getDiretores() {
		return Collections.unmodifiableList(diretores);
	}

	public List<String> getProdutores() {
		return Collections.unmodifiableList(produtores);
	}

	public List<GeneroLivroType> getGeneros() {
		return Collections.unmodifiableList(generos);
	}

	// METODOS
	@Override
	public String toString() {
		return "Livro -> { "
					+ "id=\"" + this.id + "\", "
					+ "nome=\"" + this.nome + "\", "
					+ "preco=\"" + this.preco + "\", "
					+ "estudio=\"" + this.estudio + "\", "
					+ "diretores=\"" + this.diretores + "\", "
					+ "produtores=\"" + this.produtores + "\", "
					+ "generos=\"" + this.generos + "\""
				+ " }";
	}
}
