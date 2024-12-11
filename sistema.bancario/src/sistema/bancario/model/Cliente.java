package sistema.bancario.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String cpf;
	private List<Conta> contas;

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void adicionarConta(Conta conta) {
		contas.add(conta);
	    System.out.println("Conta " + conta.getNumeroConta() + " adicionada ao cliente " + nome);
	}
	
	public void removerConta(Conta conta) {
		if (contas.remove(conta)) {
	        System.out.println("Conta " + conta.getNumeroConta() + " removida do cliente " + nome);
	    } else {
	        System.out.println("Conta não encontrada para o cliente " + nome);
	    }
	}
	
	
}
