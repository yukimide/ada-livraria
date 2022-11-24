package br.com.ada.livraria.exception;

import br.com.ada.livraria.model.produto.Produto;

public class QuantidadeException extends Exception {
	private static final long serialVersionUID = 1L;

	public QuantidadeException(Produto produto) {
		super(String.format("Não foi possível concluir a compra por falta do produto %s em estoque.", produto.getNome()));
	}
}
