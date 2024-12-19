package prontuario.model;

import java.util.Objects;

public class Paciente {
	private String cpf;
	private String nome;
	private float peso;
	private float altura;
	private int idade;
	private char sexo;

	public Paciente(String cpf,String nome,float peso,float altura, int idade,char sexo ) {
		this.cpf = cpf;
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;
		this.sexo = sexo;

	}
	
	public float calcularImc() {
		 return peso/(altura*altura);
	}
	
	public float calcularMetabolismoBasal() {
		float resultado = 0f;
		if(sexo=='M') {
			if(idade>18 && idade <=30) {
				return (14.7f*peso)+486.6f;
			}else if(idade >30 && idade<=60) {
				return (8.7f*peso)+829f;
			}else {
				return (10.5f*peso)+596;
			}
		}else if(sexo=='H'){
			if(idade>18 && idade <=30) 
				return (15.057f*peso)+679f;
			else if(idade >30 && idade<=60) 
				return (11.6f*peso)+829f;
			else 
				return (13.5f*peso)+487;
			
		}
		return null;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Paciente [cpf=" + cpf + ", nome=" + nome + ", peso=" + peso + ", altura=" + altura + ", idade=" + idade
				+ ", sexo=" + sexo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	
}
