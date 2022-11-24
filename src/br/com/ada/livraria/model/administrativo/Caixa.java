package br.com.ada.livraria.model.administrativo;

import br.com.ada.livraria.exception.MenorIdadeException;
import br.com.ada.livraria.exception.QuantidadeException;
import br.com.ada.livraria.model.administrativo.estoque.Estoque;
import br.com.ada.livraria.model.administrativo.validacao.ValidarIdade;
import br.com.ada.livraria.model.administrativo.validacao.ValidarQuantidadeEstoque;

/**
 * Classe responsável por gerenciar o caixa.
 */
public class Caixa {
	public static double valor;
	
	public static void comprar(Pedido pedido) {
		try {
			// VALIDA IDADE CLIENTE
			ValidarIdade.validar(pedido.getCliente(), pedido.getProdutos());
			
			// APLICA DESCONTO CASO ELEGIVEL
			double valorDesconto = Desconto.aplicar(pedido.getValor());
			double valorComDesconto = pedido.getValor() - valorDesconto;
			
			// REMOVE QUANTIDADE DE PRODUTOS DO ESTOQUE
			pedido.getProdutos().forEach(produto -> {
				
				try {
					ValidarQuantidadeEstoque.validar(produto);

				} catch(QuantidadeException e) {
					Estoque.removerQuantidadeProduto(produto.getId());
				}

			});
			
			// ADICIONA VALOR AO CAIXA
			valor += valorComDesconto;

			System.out.println("Compra efetuada no valor de: " + valorComDesconto);
		} catch(MenorIdadeException e) {
			System.out.println(e.getMessage());
		}
	}
}
