package br.com.ada.livraria.model.produto;

import br.com.ada.livraria.enumeration.GeneroJogoType;
import br.com.ada.livraria.enumeration.RestricaoType;

public class Jogo extends Produto {
	private String estudio;
	private String distribuidora;
	private GeneroJogoType genero;
	
	// CONSTRUTOR
	public Jogo(
		String nome,
		double preco,
		int quantidade,
		String estudio,
		String distribuidora,
		GeneroJogoType genero,
		RestricaoType restricao
	) {
		super(nome, preco, quantidade, restricao);
		
		this.genero = genero;
		this.estudio = estudio;
		this.distribuidora = distribuidora;
	}
	
	// GETTERS E SETTERS
	public String getEstudio() {
		return estudio;
	}
	
	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	
	public GeneroJogoType getGenero() {
		return genero;
	}
	
	public void setGenero(GeneroJogoType genero) {
		this.genero = genero;
	}
	
	public String getDistribuidora() {
		return distribuidora;
	}
	
	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}

	// METODOS
	@Override
	public String toString() {
		return "Jogo -> { "
					+ "id=\"" + this.id + "\", "
					+ "nome=\"" + this.nome + "\", "
					+ "preco=\"" + this.preco + "\", "
					+ "estudio=\"" + this.estudio + "\", "
					+ "distribuidora=\"" + this.distribuidora + "\", "
					+ "genero=\"" + this.genero + "\""
				+ " }";
	}
}
