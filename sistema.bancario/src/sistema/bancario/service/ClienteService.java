package sistema.bancario.service;

import java.util.ArrayList;
import java.util.List;

import sistema.bancario.model.Cliente;
import sistema.bancario.model.Conta;

public class ClienteService {
	private List<Cliente> clientes = new ArrayList<>();
	
	public void adicionaClientes(Cliente cliente) {
		clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado com sucesso!");
	}
	
	public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
	
	public void adicionarConta(Cliente cliente, Conta conta) {
        cliente.adicionarConta(conta);
    }
	
	public void removerConta(Cliente cliente, Conta conta) {
        cliente.removerConta(conta);
    }
	
	public List<Cliente> getClientes() {
        return clientes;
    }
}
