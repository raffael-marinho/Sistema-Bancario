package projeto.banco.model;

import java.time.LocalDateTime;

public class Conta {
	private Integer numeroDaConta;
	private float saldo;
	private LocalDateTime dataAbertura;
	private boolean status;
	
	public Conta() {
		
	}
	
	public Conta(Integer numero) {
		this.numeroDaConta = numeroDaConta;
		this.saldo = 0f;
		this.dataAbertura = LocalDateTime.now();
		this.status = true;
	}
	

}
