package br.com.ada.livraria.model.produto;

import java.util.List;
import java.util.Collections;

import br.com.ada.livraria.enumeration.GeneroMusicaType;
import br.com.ada.livraria.enumeration.RestricaoType;

public class Album extends Produto {
	private List<String> selos;
	private List<String> bandas;
	private List<String> musicos;
	private List<GeneroMusicaType> generos;
	
	// CONSTRUTOR
	public Album(
		String nome,
		double preco,
		int quantidade,
		List<String> selos,
		List<String> bandas,
		List<String> musicos,
		List<GeneroMusicaType> generos,
		RestricaoType restricao
	) {
		super(nome, preco, quantidade, restricao);
		
		this.selos = selos;
		this.bandas = bandas;
		this.musicos = musicos;
		this.generos = generos;
	}

	// GETTERS E SETTERS
	public List<String> getSelos() {
		return Collections.unmodifiableList(selos);
	}
	
	public List<String> getBandas() {
		return Collections.unmodifiableList(bandas);
	}
	
	public List<String> getMusicos() {
		return Collections.unmodifiableList(musicos);
	}
	
	public List<GeneroMusicaType> getGeneros() {
		return Collections.unmodifiableList(generos);
	}

	// METODOS
	@Override
	public String toString() {
		return "Album -> { "
					+ "id=\"" + this.id + "\", "
					+ "nome=\"" + this.nome + "\", "
					+ "preco=\"" + this.preco + "\", "
					+ "selos=\"" + this.selos + "\", "
					+ "bandas=\"" + this.bandas + "\", "
					+ "musicos=\"" + this.musicos + "\", "
					+ "generos=\"" + this.generos + "\""
				+ " }";
	}
}
