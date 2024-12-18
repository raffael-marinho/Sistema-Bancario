package projeto.banco.app;

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
					+ "2 - Remover cliente\n"
					+ "3 - Opcoes de cliente\n"
					+ "4 - Para sair\n\n\n");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1: {
				cadastrarCliente(p, sc);
				break;
			}
			case 2: {
				Cliente temp;
				String cpf;
				System.out.println("Insira o seu CPF: ");
				cpf = sc.next();
				if(Cliente.validarCPF(cpf)){
					temp = new Cliente();
					temp.setCpf(cpf);
					p.removerCliente(temp);
				}
				break;
			}
			case 3: {
				System.out.println("insira seu cpf");
				String cpf;
				cpf = sc.next();
				p.localizarClientePorCpf(cpf);
				break;
			}
			case 4: {
				sair = false;
				System.out.println("Opcao 4 selecionada");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		}
	}

	private static void cadastrarCliente(Persistencia p, Scanner sc) {
		sc.nextLine(); 
    	System.out.print("Insira o CPF: ");
    	String cpf = sc.nextLine();
   
    	if(Cliente.validarCPF(cpf) == true) {
    		System.out.print("Insira o nome: ");
    		String nome = sc.nextLine();
    		p.adicionarCliente(new Cliente(cpf, nome));
        }
    }
	
}
