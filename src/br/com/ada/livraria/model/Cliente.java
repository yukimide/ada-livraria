package br.com.ada.livraria.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cliente {
	private int idade;
	private String rg;
	private String cpf;
	private String nome;
	private Date dataNascimento;
	
	// CONSTRUCTOR
	public Cliente(String rg, String cpf, String nome, Date dataNascimento) {
		this.rg = rg;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		
		this.calcularIdade();
	}
	
	// GETTERS E SETTERS
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	// METODOS
	@Override
	public String toString() {
		return "Cliente -> { "
					+ "rg=\"" + this.rg + "\", "
					+ "nome=\"" + this.nome + "\", "
					+ "idade=\"" + this.idade + "\", "
					+ "dataNascimento=\"" + this.dataNascimento + "\""
				+ " }";
	}

	private void calcularIdade() {
		Calendar cal = Calendar.getInstance();
		Calendar dataNascimento = new GregorianCalendar();
		
		dataNascimento.setTime(this.dataNascimento);
		
		this.idade = cal.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
	}
}
