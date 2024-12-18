package projeto.banco.model;

import java.util.ArrayList;

public class Cliente {
	private String cpf;
	private String nome;
	
	private ArrayList<Conta> contas;
	
	public Cliente() {
		
	}
	
	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
		contas = new ArrayList<>();
	}
}
