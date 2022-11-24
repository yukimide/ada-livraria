package br.com.ada.livraria.model.produto;

import br.com.ada.livraria.enumeration.RestricaoType;

public class Brinquedo extends Produto {
	private String tipo;
	
	// CONSTRUTOR
	public Brinquedo(
		String nome,
		double preco,
		int quantidade,
		String tipo,
		RestricaoType restricao
	) {
		super(nome, preco, quantidade, restricao);
		
		this.setTipo(tipo);
	}

	// GETTERS E SETTERS
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	// METODOS
	@Override
	public String toString() {
		return "Brinquedo -> { "
					+ "id=\"" + this.id + "\", "
					+ "nome=\"" + this.nome + "\", "
					+ "preco=\"" + this.preco + "\", "
					+ "tipo=\"" + this.tipo + "\", "
					+ "quantidade=\"" + this.quantidade + "\""
				+ " }";
	}
}
