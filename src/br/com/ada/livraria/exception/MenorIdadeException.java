package br.com.ada.livraria.exception;

import br.com.ada.livraria.model.Cliente;
import br.com.ada.livraria.model.produto.Produto;

public class MenorIdadeException extends Exception {
	public String mensagem;
	private static final long serialVersionUID = 1L;
	
	public MenorIdadeException(Cliente cliente, Produto produto) {
		super(String.format(
			"O Cliente %s não pode comprar o produto %s por ser menor de idade!",
			cliente.getNome(), produto.getNome()
		));
	}
}
