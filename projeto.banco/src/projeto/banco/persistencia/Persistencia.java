package projeto.banco.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import projeto.banco.model.Cliente;
import projeto.banco.model.Conta;

public class Persistencia {
	
	private static final String arquivo = "clientes.dat";
	private ArrayList<Cliente> clientes;
	

	public Persistencia() {
		clientes = carregarClientes();
	}
	
	public void adicionarCliente(Cliente novoCliente) {
		if(clientes.contains(novoCliente)) {
			System.out.println("Cliente já cadastrada");
		}else {
			clientes.add(novoCliente);
			salvarClientes();
			System.out.println("Cliente cadastrado com sucesso");
		}
	}
	
	public void removerCliente(Cliente removerSelecionado) {
		if(clientes.contains(removerSelecionado)) {
			clientes.remove(removerSelecionado);
			salvarClientes();
			System.out.println("Cliente removido com sucesso");
		}else
			System.out.println("Cliente não localizada");
	}
	
	public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
        	System.out.println("lista de Clientes");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }
	
	public Cliente localizarClientePorCpf(String cpf) {
		for (Cliente objetoDeBusca : clientes) {
            if (objetoDeBusca.getCpf().equals(cpf)) {
            	System.out.println(objetoDeBusca);
                return objetoDeBusca;
            }
        }
		System.out.println("Cliente não encontrado");
        return null;
	}
	
	public void atualizarCliente(Cliente c) {
		if(clientes.contains(c)) {
			int index = clientes.indexOf(c);
			clientes.set(index, c);
			salvarClientes();
			System.out.println("Cliente atualizado com sucesso");
		}else
			System.out.println("Cliente não localizado");
	}
//----------------------------------------------------------------------------------------------------------------------
	
	public void adicionarContaAoCliente(String cpf, Conta conta) {
        Cliente cliente = localizarClientePorCpf(cpf);
        if (cliente != null) {
            cliente.adicionarConta(conta);
            atualizarCliente(cliente); 
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
    
    public void removerContaDoCliente(String cpf, int numeroConta) {
        Cliente cliente = localizarClientePorCpf(cpf);
        if (cliente != null) {
            Conta conta = cliente.localizarContaPorNumero(numeroConta);
            if (conta != null) {
                cliente.removerConta(conta);
                atualizarCliente(cliente); 
            } else {
                System.out.println("Conta não encontrada.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void atualizarContaDoCliente(String cpf, Conta contaAtualizada) {
        Cliente cliente = localizarClientePorCpf(cpf);
        if (cliente != null) {
            cliente.atualizarConta(contaAtualizada);
            atualizarCliente(cliente); 
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
    
    private void salvarClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            System.err.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Cliente> carregarClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ArrayList<Cliente>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de clientes não encontrado. Criando uma nova lista.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
