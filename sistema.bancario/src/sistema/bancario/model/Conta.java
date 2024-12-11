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
}
