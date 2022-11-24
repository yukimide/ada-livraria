package br.com.ada.livraria.model.administrativo.validacao;

import br.com.ada.livraria.model.produto.Produto;
import br.com.ada.livraria.exception.QuantidadeException;

/**
 * Classe responsável por validar a se
 * existe quantiade suficiente do produto.
 */
public class ValidarQuantidadeEstoque {
	public static void validar(Produto produto) throws QuantidadeException {
		if (produto.getQuantidade() == 0) {
			throw new QuantidadeException(produto);
		}
	}
}
