package br.com.ada.livraria.model.administrativo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import br.com.ada.livraria.model.Cliente;
import br.com.ada.livraria.model.administrativo.estoque.Estoque;
import br.com.ada.livraria.model.produto.Produto;

public class Pedido {
	private double valor;
	private Cliente cliente;
	private List<Produto> produtos = new ArrayList<>();

	// CONSTRUTOR
	public Pedido(Cliente cliente, List<Integer> produtos) {
		this.cliente = cliente;

		// CALCULA VALOR PEDIDO E ADICIONA A LISTA DE PRODUTOS 
		produtos.forEach(id -> {
			Produto produto = Estoque.consultarProduto(id);
			
			this.produtos.add(produto);
			this.valor += produto.getPreco();
		});
	}
	
	// GETTER E SETTERS
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	@Override
	public String toString() {
		return "Pedido -> { "
					+ "valor=\"" + this.valor + "\", "
					+ "cliente=\"" + this.cliente + "\", "
					+ "produtos=\"" + this.produtos + "\""
				+ " }";
	}
}
