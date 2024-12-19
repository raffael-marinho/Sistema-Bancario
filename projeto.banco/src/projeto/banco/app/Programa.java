package projeto.banco.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto.banco.model.Cliente;
import projeto.banco.model.Conta;
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
				System.out.println("Saindo...");
				break;
			}
			default:
				System.out.println("Opção invalida!");
				
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
    					+ "\n1 - Criar conta bancaria;\n"
    					+ "2 - Realizar deposito\n"
    					+ "3 - Sacar\n"
    					+ "4 - Transferir para outras contas\n"
    					+ "5 - consultar saldo em conta\n"
    					+ "6 - consultar saldo em todas as contas\n"
    					+ "7 - Consultar contas\n"
    					+ "8 - Remover contas\n"
    					+ "9 - Para sair\n\n\n");
                       
                int opcao = sc.nextInt();

                switch (opcao) {
	                case 1: {
	                    Conta novaConta = new Conta(cliente.getContas().size() + 1);
	                    p.adicionarContaAoCliente(cpf, novaConta);
	                    break;
	                }                    
	                case 2: {
	                	depositarSaldo(cliente, sc);
	                	break;
	                }
                    case 3: {
                    	saqueSaldo(cliente, sc);
                    	break;
                    }
                    case 4: {
                    	transferirSaldo(cliente,p , sc);
                    	break;
                    }
                    case 5: {
                    	saldoConta(cliente, sc);
                    	break;
                    }
                    case 6: {
                    	saldoContaTotal(cliente, sc);
                    	break;
                    }
                    case 7: {
                    	System.out.println(cliente.getContas());
                    	break;
                    }
                    case 8: {
                    	removerConta(cliente, sc);
                    	break;
                    }
                    case 9: { 
                    	voltar = true;
                    	break;
                    }
                    default: System.out.println("Opção inválida. \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. \n");
                sc.nextLine();
            }
        }
	}
	//----------------------------------------------------------------------------------------------------------
	private static void depositarSaldo(Cliente cliente, Scanner scanner) {
        System.out.print("Digite o número da conta: ");
       	int numeroConta = scanner.nextInt();       	
       	Conta conta = cliente.localizarContaPorNumero(numeroConta);
       	if (conta != null) {
       		System.out.print("Digite o valor do depósito: \n");
       		float valor = scanner.nextFloat();
       		conta.depositar(valor);
       	} else {
       		System.out.println("Conta não encontrada. \n");
       	}
    }
	
	private static void saqueSaldo(Cliente cliente, Scanner scanner) {
        System.out.print("Digite o número da conta: "); 
        int numeroConta = scanner.nextInt();
        Conta conta = cliente.localizarContaPorNumero(numeroConta);
        if (conta != null) {
        	System.out.print("Digite o valor do saque: ");
        	float valor = scanner.nextFloat();
        	conta.sacar(valor);
        } else {
        	System.out.println("Conta não encontrada. \n");
        }
    }
	
	private static void transferirSaldo(Cliente cliente, Persistencia p, Scanner scanner) {
	    System.out.print("Digite o número da sua conta: ");
	    int numeroContaOrigem = scanner.nextInt();
	    System.out.print("Digite o CPF do destinatário: ");
	    String cpfDestinatario = scanner.next();  

	    Conta contaOrigem = cliente.localizarContaPorNumero(numeroContaOrigem);

	    Cliente destinatario = p.localizarClientePorCpf(cpfDestinatario);  
	    if (destinatario != null) {
	        System.out.print("Digite o número da conta do destinatário: ");
	        int numeroContaDestino = scanner.nextInt();
	        Conta contaDestino = destinatario.localizarContaPorNumero(numeroContaDestino);

	        if (contaOrigem != null && contaDestino != null) {
	            System.out.print("Digite o valor da transferência: ");
	            float valor = scanner.nextFloat();
	            contaOrigem.transferir(contaDestino, valor);
	        } else {
	            System.out.println("Conta(s) não encontrada(s).");
	        }
	    } else {
	        System.out.println("Cliente destinatário não encontrado.");
	    }
	}


	
	private static void saldoConta(Cliente cliente, Scanner scanner) {
        System.out.print("Digite o número da conta: "); 
        int numeroConta = scanner.nextInt();
        Conta conta = cliente.localizarContaPorNumero(numeroConta);
        System.out.println("O saldo da conta " + conta.getNumeroDaConta() + " é de :" +  conta.getSaldo());
   }
	
	private static void saldoContaTotal(Cliente cliente, Scanner scanner) {
   	 float saldoTotal = 0;
   	    for (Conta conta : cliente.getContas()) {
   	        saldoTotal += conta.getSaldo(); 
   	    }
   	    System.out.println("Saldo total de todas as contas de: " + saldoTotal);
   }
	
	private static void removerConta(Cliente cliente, Scanner scanner) {
   	 System.out.print("Digite o número da conta: "); 
        int numeroConta = scanner.nextInt();
        Conta conta = cliente.localizarContaPorNumero(numeroConta);
        cliente.removerConta(conta);
   }
}
