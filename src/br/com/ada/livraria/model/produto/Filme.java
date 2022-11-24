package br.com.ada.livraria.model.produto;

import java.util.List;
import java.util.Collections;

import br.com.ada.livraria.enumeration.GeneroFilmeType;
import br.com.ada.livraria.enumeration.RestricaoType;

public class Filme extends Produto {
	private String estudio;
	private List<String> diretores;
	private List<String> produtores;
	private List<GeneroFilmeType> generos;

	// CONSTRUTOR
	public Filme(
		String nome,
		double preco,
		int quantidade,
		String estudio,
		List<String> diretores,
		List<String> produtores,
		List<GeneroFilmeType> generos,
		RestricaoType restricao
	) {
		super(nome, preco, quantidade, restricao);
		
		this.estudio = estudio;
		this.generos = generos;
		this.diretores = diretores;
		this.produtores = produtores;
	}

	// GETTERS E SETTERS
	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	public List<String> getDiretores() {
		return Collections.unmodifiableList(diretores);
	}

	public List<String> getProdutores() {
		return Collections.unmodifiableList(produtores);
	}

	public List<GeneroFilmeType> getGeneros() {
		return Collections.unmodifiableList(generos);
	}

	// METODOS
	@Override
	public String toString() {
		return "Filme -> { "
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
