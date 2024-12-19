package projeto.banco.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDaConta;
	private float saldo;
	private LocalDateTime dataAbertura;
	private boolean status;
	
	public Conta() {
		
	}
	
	public Conta(Integer numero) {
		this.numeroDaConta = numero;
		this.saldo = 0f;
		this.dataAbertura = LocalDateTime.now();
		this.status = true;
	}


	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(Integer numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroDaConta);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(numeroDaConta, other.numeroDaConta);
	}
	
	@Override
	public String toString() {
		return "Conta [numeroDaConta=" + numeroDaConta + ", saldo=" + saldo + ", dataAbertura=" + dataAbertura
				+ ", status=" + status + "]";
	}
	
	public void depositar(float quantia) {
		if(status) {
			if(quantia>0) {
				this.saldo += quantia;
				System.out.println("Deposito realizado com sucesso.");
			} else {
				System.err.println("Valor invalido para deposito.");
			}
		} else {
			System.err.println("Operação não permitida. Não existe conta.");
		}
	}

	public void sacar(float quantia) {
		if(status) {
			if(quantia>0) {
				if(this.saldo >= quantia) {
					this.saldo -= quantia;
					System.out.println("Saque realizado com sucesso!");
				} else {
					System.err.println("Saldo insuficiente.");
				}
			} else {
				System.err.println("Valor invalido para sacar.");
			}
		} else {
			System.err.println("Operação não permitida. Não existe conta.");
		}
	}
	
	public void transferir(Conta outraConta, float quantia) {
		if(status && outraConta.isStatus()) {
			if(quantia <= 0) {
				System.err.println("Valor invalido para transferencia.");
			} else if(quantia <= saldo) {
				this.saldo -= quantia;
				outraConta.saldo += quantia;
				System.out.println("Transferencia realizada com sucesso!");
			} else {
				System.err.println("Saldo insuficiente para realizar a transferencia.");
			}
		} else {
			System.err.println("Operacao nao pode ser realizada, uma das contas ou as duas estão inativas");
		}
	}
	
	public void saldoTotal(Conta consultaSaldo, float quantia) {    	
   	 if (status && consultaSaldo.isStatus()) {
   		 saldo += quantia;
   	 } else {
   	        System.out.println("Operação não pode ser realizada entre contas desativadas.");
   	 }
   }
}
