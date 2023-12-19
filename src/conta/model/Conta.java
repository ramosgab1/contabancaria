package conta.model;

public abstract class Conta {

// Atributos do objeto (pontos do template para serem preenchidos!)

	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

// Trazemos os mesmos elementos dos atributos para que possamos ter acesso a eles.
// Método construtor, o identificador após o this. faz referência aos atributos. 

	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
// Aqui vamos ter GET e SET que fazem uma ponte entre o public e o private para manipular os dados. 

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public boolean sacar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true; 
	}
	
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}

// Para que possamos visualizar os dados da conta ao chamar a classe e colocar os argumentos em outro arquivo. 

	public void visualizar() {
		
		String tipo = "";
		
		switch(this.tipo) {
		case 1: 
			tipo = "Conta Corrente";
		break;
		case 2: 
			tipo = "Conta Poupança";
		break; 
		}

		System.out.println("--------------------- INFORMAÇÕES DE CONTA ---------------------");
		System.out.println("O número da conta é: " + this.numero);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("A agência é: " + this.agencia);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("O tipo da conta é: " + this.tipo);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("O titular da conta é: " + this.titular);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("O saldo disponível na conta é de: " + this.saldo);

	}
}
