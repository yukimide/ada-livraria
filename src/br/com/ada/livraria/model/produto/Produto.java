package br.com.ada.livraria.model.produto;

import br.com.ada.livraria.enumeration.RestricaoType;

public class Produto {
	protected int id;
	protected String nome;
	protected double preco;
	protected int quantidade;
	protected RestricaoType restricao = RestricaoType.LIVRE;
	
	// CONSTRUTOR	
	public Produto(String nome, double preco, int quantidade, RestricaoType restricao) {
		this.nome = nome;
		this.preco = preco;
		this.restricao = restricao;
		this.quantidade = quantidade;
	}

	// GETTERS E SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public RestricaoType getRestricao() {
		return restricao;
	}

	public void setRestricao(RestricaoType restricao) {
		this.restricao = restricao;
	}
	
	// METODOS
	@Override
	public String toString() {
		return "Produto -> { "
					+ "id=\"" + this.id + "\", "
					+ "nome=\"" + this.nome + "\", "
					+ "preco=\"" + this.preco + "\", "
					+ "quantidade=\"" + this.quantidade + "\""
				+ " }";
	}
}
