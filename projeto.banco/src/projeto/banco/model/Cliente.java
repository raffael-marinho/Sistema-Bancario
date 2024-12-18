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
	
	public void adicionarConta(Conta novaConta) {
		if(contas.contains(novaConta)) {
			System.out.println("Conta já cadastrada");
		} else {
			System.out.println("Conta cadastrada com sucesso");
		}
	}
	
	public void removerConta(Conta velhaConta) {
		if(contas.contains(velhaConta)) {
			contas.remove(velhaConta);
			System.out.println("Conta removida com sucesso!");
		} else {
			System.out.println("Conta nao localizada");
		}
	}
	
	public Conta localizarContaPorNumero(Integer numero) {
		Conta temp = new Conta(numero);
		
		if(contas.contains(temp)) {
			int index = contas.indexOf(temp);
			temp = contas.get(index);
			return temp;
		}
		return null;
	}
	
	
}
