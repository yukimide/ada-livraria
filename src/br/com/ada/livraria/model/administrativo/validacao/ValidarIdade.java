package br.com.ada.livraria.model.administrativo.validacao;

import java.util.List;

import br.com.ada.livraria.enumeration.RestricaoType;
import br.com.ada.livraria.exception.MenorIdadeException;
import br.com.ada.livraria.model.Cliente;
import br.com.ada.livraria.model.produto.Produto;

/**
 * Classe responsável por validar a idade do cliente.
 */
public class ValidarIdade {
	public static void validar(Cliente cliente, List<Produto> produtos) throws MenorIdadeException {
		for (Produto produto : produtos) {
			if (cliente.getIdade() < 18 && produto.getRestricao() == RestricaoType.ADULTO) {
				throw new MenorIdadeException(cliente, produto);
			}
		}
	}
}
