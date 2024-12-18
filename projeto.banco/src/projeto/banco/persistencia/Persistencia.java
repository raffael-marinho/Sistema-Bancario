package projeto.banco.persistencia;

import java.util.ArrayList;

import projeto.banco.model.Cliente;

public class Persistencia {
private ArrayList<Cliente> clientes;
	
	public Persistencia() {
		clientes = new ArrayList<>();
	}
	
	public void adicionarCliente(Cliente c) {
		if(clientes.contains(c)) {
			System.out.println("Cliente já cadastrada");
		}else {
			clientes.add(c);
			System.out.println("Cliente cadastrado com sucesso");
		}
	}
	
	public void removerCliente(Cliente c) {
		if(clientes.contains(c)) {
			clientes.remove(c);
			System.out.println("Cliente removido com sucesso");
		}else
			System.out.println("Cliente n�o localizada");
	}
	
	public Cliente localizarClientePorCpf(String cpf) {
		for (Cliente objetoDeBusca : clientes) {
            if (objetoDeBusca.getCpf().equals(cpf)) {
            	System.out.println(objetoDeBusca);
                return objetoDeBusca;
            }
        }
		System.out.println("cliente não encontrado");
        return null;
	}
	
	public void atualizarCliente(Cliente c) {
		if(clientes.contains(c)) {
			int index = clientes.indexOf(c);
			clientes.set(index, c);
			System.out.println("Cliente atualizado com sucesso");
		}else
			System.out.println("Cliente n�o localizado");
	}

}
