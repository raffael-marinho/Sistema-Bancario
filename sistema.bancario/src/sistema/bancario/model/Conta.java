package sistema.bancario.model;

public class Conta {
	
	private String numeroConta;
	private double saldo;
	
	public Conta() {
	}
	
	public Conta(String numeroConta, double saldoInicial) {
		this.numeroConta = numeroConta;
		this.saldo = saldoInicial;
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double valor) {
		if(valor>0) {
			saldo += valor;
	        System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
		}else {
	        System.out.println("O valor do depósito invalido.");
		}
	}
	
	public boolean sacar(double valor) {
		if(valor>0 && valor<=saldo) {
			saldo -= valor;
	        System.out.println("Saque de R$" + valor + " realizado com sucesso!");
	        return true;
		}else {
	        System.out.println("Saque não realizado. Saldo insuficiente ou valor inválido.");
	        return false;
		}
	}
	
	public boolean transferir(double valor, Conta contaDestino) {
	    if (this.sacar(valor)) {
	        contaDestino.depositar(valor);
	        System.out.println("Transferência de R$" + valor + " realizada para a conta " + contaDestino.getNumeroConta());
	        return true;
	    } else {
	        System.out.println("Transferência não realizada.");
	        return false;
	    }
	}

}
