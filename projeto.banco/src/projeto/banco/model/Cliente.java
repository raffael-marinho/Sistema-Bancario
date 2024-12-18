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
	
	public void adicionarConta(Conta outraConta) {
		if(contas.contains(outraConta)) {
			System.out.println("Conta já cadastrada");
		} else {
			System.out.println("Conta cadastrada com sucesso");
		}
	}
	
	public void removerConta(Conta outraConta) {
		if(contas.contains(outraConta)) {
			contas.remove(outraConta);
			System.out.println("Conta removida com sucesso!");
		} else {
			System.out.println("Conta nao localizada");
		}
	}
	
	
}
