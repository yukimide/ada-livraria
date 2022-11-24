package br.com.ada.livraria.model.administrativo;

/**
 * Classe responsável por aplicar o desconto.
 */
public class Desconto {
	private static int porcentagem = 15;
	
	public static double aplicar(double valor) {
		if (valor > 200) {
			return (valor * porcentagem) / 100;
		}
		
		return 0;
	};
}
