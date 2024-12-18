package projeto.banco.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto.banco.model.Cliente;
import projeto.banco.persistencia.Persistencia;

public class Programa {
public static void main(String[] args) {
		
		Persistencia p = new Persistencia();
		
		Scanner sc = new Scanner(System.in);
		
		boolean sair = true;
		int opcao = 0;
		System.out.println("Bem vindo ao sistema banc�rio!!");
		
		while(sair) {
			System.out.println("\n\n\nDigite a opcao desejada:\n"
					+ "\n1 - Cadastro de cliente;\n"
					+ "2 - Listar os clientes cadastrados\n"
					+ "3 - consultar clientepor CPF\n"
					+ "4 - Opcoes de cliente\n"
					+ "5 - Remover cliente\n"
					+ "6 - Para sair\n\n\n");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1: {
				cadastrarCliente(p, sc);
				break;
			}
			case 2: {
				listarClientes(p);
				break;
			}
			case 3: {
				localizarClientePorCpf(p, sc);
				break;
			}
			case 4: {
				System.out.println("Menu cliente");
				menuCliente(p, sc);
				break;
			}
			case 5: {
				removerCliente(p, sc);
				break;
			}
			case 6: {
				sair = false;
				System.out.println("Opcao 4 selecionada");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		}
	}
//-----------------------------------------------------------------------------------------------------------------------
	private static void cadastrarCliente(Persistencia p, Scanner sc) {
		sc.nextLine(); 
    	System.out.print("Insira o CPF: ");
    	String cpf = sc.nextLine();   
    	System.out.print("Insira o nome: ");
    	String nome = sc.nextLine();
    	if(Cliente.validarCPF(cpf) && Cliente.validarNome(nome)) {
    		p.adicionarCliente(new Cliente(cpf, nome));
        }
    }
	
	private static void removerCliente(Persistencia p, Scanner sc) {
        sc.nextLine(); 
        System.out.print("Insira o CPF do cliente a ser removido: ");
        String cpf = sc.nextLine();
        Cliente cliente = p.localizarClientePorCpf(cpf);
        
        if (cliente != null) {
            p.removerCliente(cliente);
        } else {
            System.out.println("Cliente não encontrado. \n");
        }
    }
	
	private static void listarClientes(Persistencia p) {
        p.listarClientes();  
    }
	
	private static void localizarClientePorCpf(Persistencia p, Scanner sc) {
		System.out.println("insira seu cpf");
		String cpf;
		cpf = sc.next();
		p.localizarClientePorCpf(cpf); 
    }
//---------------------------------------------------------------------------------------------------------------------
	private static void menuCliente(Persistencia p, Scanner sc) {
		sc.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = sc.nextLine();
        Cliente cliente = p.localizarClientePorCpf(cpf);
        
        if (cliente == null) {
            System.out.println("Cliente não encontrado. \n");
            return;
        }

        boolean voltar = false;
        while (!voltar) {
            try {
            	System.out.println("\n\n\nDigite a opcao desejada:\n"
    					+ "\n1 - Cadastro de cliente;\n"
    					+ "2 - Listar os clientes cadastrados\n"
    					+ "3 - consultar clientepor CPF\n"
    					+ "4 - Opcoes de cliente\n"
    					+ "5 - Remover cliente\n"
    					+ "6 - Para sair\n\n\n");
                       
                int opcao = sc.nextInt();

                switch (opcao) {
	                case 1 -> {
	                    //Conta novaConta = new Conta(cliente.getContas().size() + 1);
	                    //p.adicionarContaAoCliente(cpf, novaConta);
	                }                    
	                //case 2 -> depositarSaldo(cliente, sc);
                    //case 3 -> saqueSaldo(cliente, sc);
                    //case 4 -> transferirSaldo(cliente, sc);
                    //case 5 -> saldoConta(cliente, sc);
                    //case 6 -> saldoContaTotal(cliente, sc);
                    //case 7 -> System.out.println(cliente.getContas());
                    //case 8 -> removerConta(cliente, sc);
                    case 9 -> voltar = true;
                    default -> System.out.println("Opção inválida. \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. \n");
                sc.nextLine();
            }
        }
	}
	
}
