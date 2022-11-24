package br.com.ada.livraria;

import java.util.List;
import java.util.Calendar;
import java.util.ArrayList;

import br.com.ada.livraria.model.Cliente;
import br.com.ada.livraria.model.produto.Jogo;
import br.com.ada.livraria.model.produto.Livro;
import br.com.ada.livraria.model.produto.Album;
import br.com.ada.livraria.model.produto.Filme;
import br.com.ada.livraria.model.produto.Brinquedo;
import br.com.ada.livraria.enumeration.RestricaoType;
import br.com.ada.livraria.model.administrativo.Caixa;
import br.com.ada.livraria.enumeration.GeneroJogoType;
import br.com.ada.livraria.model.administrativo.Pedido;
import br.com.ada.livraria.model.administrativo.estoque.Estoque;
import br.com.ada.livraria.enumeration.GeneroFilmeType;
import br.com.ada.livraria.enumeration.GeneroLivroType;
import br.com.ada.livraria.enumeration.GeneroMusicaType;

public class Livraria {
	private static List<Pedido> pedidos = new ArrayList<>();
	private static List<Cliente> clientes = new ArrayList<>();
	
	public static void main(String[] args) {
		// POPULAR DADOS
		popularDados();

		// CONSULTA PRODUTO ID 2
		System.out.println("CONSULTA PRODUTO ID 2");
		System.out.println(Estoque.consultarProduto(2));
		
		// CONSULTA QUANTIDADE PRODUTO ID 2
		System.out.println("\nCONSULTA QUANTIDADE PRODUTO 2");
		System.out.println(String.format("Quantidade: %s", Estoque.getQuantidadeProduto(2)));
		
		// CONSULTA TODOS PRODUTO CADASTRADOS
		System.out.println("\nCONSULTA TODOS PRODUTO CADASTRADOS");
		Estoque.getProdutos().forEach((id, produto) -> System.out.println(produto));

		// COMPRA PEDIDO 0
		System.out.println("\nCOMPRAR PEDIDO 0");
		Caixa.comprar(pedidos.get(0));
		
		// COMPRA PEDIDO 1 COM RESTRICAO IDADE
		System.out.println("\nCOMPRAR PEDIDO 1");
		Caixa.comprar(pedidos.get(1));
		
		// VERIFICA VALOR NO CAIXA
		System.out.println("\nVERIFICA VALOR NO CAIXA");
		System.out.println("Valor no caixa: " + Caixa.valor);
	}
	
	// METODOS PRIVATE	
	private static void popularDados() {
		// POPULA CLIENTES
		populaClientes();
		
		// POPULA JOGOS
		populaEstoqueJogos();
		
		// POPULA ALBUMS
		populaEstoqueAlbums();
		
		// POPULA FILMES
		populaEstoqueFilmes();
		
		// POPULA LIVROS
		populaEstoqueLivros();
		
		// POPULA BRINQUEDOS
		populaEstoqueBrinquedos();
		
		// POPULA PEDIDOS
		populaPedidos();
	}
	
	private static void populaPedidos() {
		Cliente clienteAdulto = clientes.get(0);
		List<Integer> produtos1 = new ArrayList<>();
		
		// ADICIONA ITENS GTA 5 E CALL OF DUTY
		produtos1.add(2);
		produtos1.add(5);
		pedidos.add(new Pedido(clienteAdulto, produtos1));
		
		// CALCULA
		Cliente clienteCrianca = clientes.get(1);
		List<Integer> produtos2 = new ArrayList<>();
		
		// ADICIONA ITENS GTA 5 E SIM SENHOR
		
		produtos2.add(1);
		produtos2.add(2);
		pedidos.add(new Pedido(clienteCrianca, produtos2));
	}
	
	private static void populaClientes() {
		Calendar cal = Calendar.getInstance();
		
		// CLIENTE 1 ADULTO
		cal.set(Calendar.YEAR, 1997);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		clientes.add(new Cliente("11.111.111-X", "111.111.111-11", "Jeffrey", cal.getTime()));
		
		// CLIENTE 2 CRIANCA
		cal.set(Calendar.YEAR, 2010);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		clientes.add(new Cliente("22.222.222-X", "222.222.222-22", "Zezinho", cal.getTime()));
	}
	
	private static void populaEstoqueJogos() {
		// ADICIONA JOGO 1
		Estoque.jogo.adicionar(new Jogo(
			"Call of Duty", 250, 10, "Sledgehammer Games",
			"Activision", GeneroJogoType.FPS, RestricaoType.ADULTO
		));
		
		// ADICIONA JOGO 2
		Estoque.jogo.adicionar(new Jogo(
			"GTA V", 200, 5, "Rockstar", "Take-Two Interactive",
			GeneroJogoType.ACAO_AVENTURA, RestricaoType.ADULTO
		));
	}
	
	private static void populaEstoqueAlbums() {
		// PRIMEIRO ALBUM 1
		List<String> selos1 = new ArrayList<>(); 
		List<String> bandas1 = new ArrayList<>();
		List<String> musicos1 = new ArrayList<>();
		List<GeneroMusicaType> generos1 = new ArrayList<>();
		
		// SELOS
		selos1.add("EMI");
		
		// BANDAS
		bandas1.add("Legião Urbana");
		
		// MUSICOS
		musicos1.add("Renato Russo");
		musicos1.add("Renato Rocha");
		musicos1.add("Marcelo Bonfá");
		musicos1.add("Eduardo Paraná");
		musicos1.add("Ico Ouro-Preto");
		musicos1.add("Dado Villa-Lobos");
		
		// GENEROS
		generos1.add(GeneroMusicaType.POP);
		generos1.add(GeneroMusicaType.ROCK);
		
		Estoque.album.adicionar(new Album(
			"A Tempestade", 20, 10, selos1, bandas1,
			musicos1, generos1, RestricaoType.LIVRE
		));
		
		// SEGUNDO ALBUM
		List<String> selos2 = new ArrayList<>(); 
		List<String> bandas2 = new ArrayList<>();
		List<String> musicos2 = new ArrayList<>();
		List<GeneroMusicaType> generos2 = new ArrayList<>();
		
		// SELOS
		selos2.add("Som Livre");
		
		// BANDAS
		bandas2.add("Jorge & Mateus");
		
		// MUSICOS
		musicos2.add("Jorge");
		musicos2.add("Mateus");
		
		generos2.add(GeneroMusicaType.SERTANEJO);
		
		Estoque.album.adicionar(new Album(
			"Os Anjos Cantam", 15, 20, selos2, bandas2,
			musicos2, generos2, RestricaoType.LIVRE
		));
	}

	private static void populaEstoqueFilmes() {
		// PRIMEIRO FILME
		List<String> diretores1 = new ArrayList<>();
		List<String> produtores1 = new ArrayList<>();
		List<GeneroFilmeType> generos1 = new ArrayList<>();
		
		// DIRETORES
		diretores1.add("Peyton Reed");
		
		// PRODUTORES
		produtores1.add("Nicholas Stoller");

		// GENEROS
		generos1.add(GeneroFilmeType.COMEDIA);
		
		Estoque.filme.adicionar(new Filme(
			"Sim Senhor", 30, 5, "", diretores1,
			produtores1, generos1, RestricaoType.LIVRE
		));
		
		// SEGUNDO FILME
		List<String> diretores2 = new ArrayList<>();
		List<String> produtores2 = new ArrayList<>();
		List<GeneroFilmeType> generos2 = new ArrayList<>();
		
		// DIRETORES
		diretores2.add("Joe Russo");
		diretores2.add("Anthony Russo");
		
		// PRODUTORES
		produtores2.add("Kevin Feige");

		// GENEROS
		generos2.add(GeneroFilmeType.FANTASIA);
		generos2.add(GeneroFilmeType.ACAO_AVENTURA);
		
		Estoque.filme.adicionar(new Filme(
			"Vingadores: Ultimato", 30, 5, "", diretores1,
			produtores1, generos1, RestricaoType.LIVRE
		));
	}

	private static void populaEstoqueLivros() {
		// PRIMEIRO LIVRO
		List<String> diretores1 = new ArrayList<>();
		List<String> produtores1 = new ArrayList<>();
		List<GeneroLivroType> generos1 = new ArrayList<>();
		
		// DIRETORES
		diretores1.add("William P. Young");
		
		// PRODUTORES
		produtores1.add("Windblown Media");
		
		// GENEROS
		generos1.add(GeneroLivroType.FICCIONAL);
		
		Estoque.livro.adicionar(new Livro(
			"A Cabana", 60, 70, diretores1,
			produtores1, generos1, RestricaoType.LIVRE
		));
		
		// SEGUNDO LIVRO
		List<String> diretores2 = new ArrayList<>();
		List<String> produtores2 = new ArrayList<>();
		List<GeneroLivroType> generos2 = new ArrayList<>();
		
		// DIRETORES
		diretores2.add("J. K. Rowling");
		
		// PRODUTORES
		produtores2.add("Bloomsbury Publishing");
		
		// GENEROS
		generos2.add(GeneroLivroType.FICCIONAL);
		generos2.add(GeneroLivroType.ACAO_AVENTURA);

		Estoque.livro.adicionar(new Livro(
			"A Cabana", 60, 70, diretores2,
			produtores2, generos2, RestricaoType.ADULTO
		));
	}
	
	private static void populaEstoqueBrinquedos() {
		// PRIMEIRO BRINQUEDO
		Estoque.brinquedo.adicionar(new Brinquedo(
			"Barbie", 50, 30, "Boneca", RestricaoType.LIVRE)
		);

		// SEGUNDO BRINQUEDO
		Estoque.brinquedo.adicionar(new Brinquedo(
			"Hot Wheels", 10, 50, "Carro", RestricaoType.LIVRE)
		);
	}
}
