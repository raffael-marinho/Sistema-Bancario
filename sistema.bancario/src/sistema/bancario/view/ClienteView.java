package sistema.bancario.view;

import java.util.Scanner;

import sistema.bancario.model.Cliente;
import sistema.bancario.model.Conta;
import sistema.bancario.service.ClienteService;

public class ClienteView {

    private Scanner scanner = new Scanner(System.in);
    private ClienteService clienteService = new ClienteService();

    public void exibirMenu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Adicionar Conta");
            System.out.println("4. Remover Conta");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    adicionarConta();
                    break;
                case 4:
                    removerConta();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarCliente() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);
        clienteService.adicionaClientes(cliente);
    }

    private void listarClientes() {
        clienteService.listarClientes();
    }

    private void adicionarConta() {
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = buscarClientePorCpf(cpf);
        if (cliente != null) {
            System.out.print("Número da Conta: ");
            String numero = scanner.nextLine();
            System.out.print("Saldo inicial: ");
            double saldo = scanner.nextDouble();
            Conta conta = new Conta(numero, saldo);
            clienteService.adicionarConta(cliente, conta);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void removerConta() {
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = buscarClientePorCpf(cpf);
        if (cliente != null) {
            System.out.print("Número da Conta: ");
            String numero = scanner.nextLine();
            Conta conta = buscarContaPorNumero(cliente, numero);
            if (conta != null) {
                clienteService.removerConta(cliente, conta);
            } else {
                System.out.println("Conta não encontrada.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clienteService.getClientes()) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    private Conta buscarContaPorNumero(Cliente cliente, String numero) {
        for (Conta conta : cliente.getContas()) {
            if (conta.getNumeroConta().equals(numero)) {
                return conta;
            }
        }
        return null;
    }
}
