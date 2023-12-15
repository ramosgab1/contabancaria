package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		
		//Teste de Conta. 
		Conta c1 = new Conta(123456, 123, 1, "Laura", 10000.0f);
		c1.visualizar();
		c1.sacar(11000.0f);
		c1.visualizar();
		c1.depositar(6000.0f);
		c1.visualizar();
		
		//Teste de Conta Corrente 
		ContaCorrente cc1 = new ContaCorrente(223456, 123, 1, "Diogo", 16000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(14000.0f);
		cc1.visualizar();
		cc1.depositar(6000.0f);
		cc1.visualizar();
		
		//Teste de Conta. 
		ContaPoupanca cp1 = new ContaPoupanca(323456, 123, 2, "Breno", 10000.0f,15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

// Inicializar Scanner para input do usuário.
		int opcoes = 0;
		Scanner leia = new Scanner(System.in);

// Criação do Menu - do... while // switch case. Jacque comi palhacitos hoje, perdão. 

		do {
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "-----------------------------------------------------------------");
			System.out.println("                                                                 ");
			System.out.println("                      BANCO DA GENERATION                        ");
			System.out.println("                      sempre com você! <3                        ");
			System.out.println("                                                                 ");
			System.out.println("-----------------------------------------------------------------");
			System.out.println("                                                                 ");
			System.out.println("            1 - Criar conta                                      ");
			System.out.println("            2 - Listar todas as contas                           ");
			System.out.println("            3 - Buscar conta por número                          ");
			System.out.println("            4 - Atualizar dados da conta                         ");
			System.out.println("            5 - Apagar conta                                     ");
			System.out.println("            6 - Sacar                                            ");
			System.out.println("            7 - Depositar                                        ");
			System.out.println("            8 - Transferir valores entre contas                  ");
			System.out.println("            9 - Sair                                             ");
			System.out.println("                                                                 ");
			System.out.println("-----------------------------------------------------------------");
			System.out.println("ENTRE COM A OPCÃO DESEJADA:                                      " + Cores.TEXT_RESET);
			opcoes = leia.nextInt();

			switch (opcoes) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 1 - Criar conta                 \n");
				
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 2 - Listar todas as contas      \n");
				
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 3 - Buscar conta por número     \n");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 4 - Atualizar dados da conta    \n");
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 5 - Apagar conta                \n");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 6 - Saque                       \n");
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 7 - Depósito                    \n");
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 8 - Transferir valor entre contas\n");
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 9 - Sair                          \n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "    OPÇÃO INVÁLIDA! Tente outra vez!       \n");
			}

		} while (opcoes != 9);

		if (opcoes == 9) {
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "                  Obrigado pela preferência! <3                  ");
			System.out.println(Cores.TEXT_GREEN + "                      BANCO DA GENERATION                        ");
			System.out.println(Cores.TEXT_YELLOW_BOLD + "-----------------------------------------------------------------");
		}

	}
	
}
