package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.util.Cores;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {
	
	public static void main(String[] args) {
		// Inicializar Scanner para input do usuário.
		int opcao = 0, numero, agencia, tipo, aniversario, numeroDestino;
		String titular; 
		float saldo, limite, valor; 
		Scanner leia = new Scanner(System.in);

		ContaController contas = new ContaController();
		
		System.out.println("\nCriar contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Johnnata Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Daniela Xavier", 2000f, 100.0f);
		contas.cadastrar(cc2);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Gabriel Pelo", 4000f, 12);
		contas.cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Maria Eduarda Vasconcelos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();

// Criação do Menu - do... while // switch case. Jacque comi palhacitos hoje, perdão. 

		while (true) {
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

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "                  Obrigado pela preferência! <3                  ");
				System.out.println(
						Cores.TEXT_GREEN + "                      BANCO DA GENERATION                        ");
				System.out.println(
						Cores.TEXT_YELLOW_BOLD + "-----------------------------------------------------------------");
				sobre(); 
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 1 - Criar conta                 \n");
				
				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt(); 
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do { 
					System.out.println("Digite o tipo da Conta: 1 - Conta Corrente / 2 - Conta Poupança");
					tipo = leia.nextInt(); 
				}while(tipo < 1 && tipo > 2);
				
				System.out.println("Digite o Saldo da Conta: ");
				saldo = leia.nextFloat(); 
				
				switch(tipo) { 
				case 1 -> { 
					System.out.println("Digite o limite de crédito (R$): ");
					limite = leia.nextFloat(); 
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				
				case 2 -> { 
					System.out.println("Digite o dia de aniversário da conta: ");
					aniversario = leia.nextInt(); 
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario)); 
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 2 - Listar todas as contas      \n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 3 - Buscar conta por número     \n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt(); 
				contas.procurarPorNumero(numero);
	
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 4 - Atualizar dados da conta    \n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt(); 
				var buscaConta = contas.buscarNaCollection(numero); 
				
				if (buscaConta != null) { 
					tipo = buscaConta.getTipo(); 
					
					System.out.println("Digite o número da agência: ");
					agencia = leia.nextInt(); 
					System.out.println("Digite o nome do titular: ");
					leia.skip("\\R?"); 
					titular = leia.nextLine(); 
					
					System.out.println("Digite o saldo da conta: ");
					saldo = leia.nextFloat(); 
					
					switch (tipo) { 
					case 1 -> { 
						System.out.println("Digite o limite de crédito (R$): ");
						limite = leia.nextFloat(); 
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
					case 2 -> { 
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = leia.nextInt(); 
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario)); 
					}
					default -> { 
						System.out.println("Tipo de conta inválido! Tente outra vez.");
					}
					}
				}else { 
					System.out.println("A conta não foi encontrada!");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 5 - Apagar conta                \n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt(); 
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 6 - Saque                       \n");
				
				System.out.println("Digite o número da conta: ");
				numero=leia.nextInt(); 
				
				do { 
					System.out.println("Digite o valor do saque (R$): ");
					valor = leia.nextFloat(); 
				} while (valor <= 0); 
				contas.sacar(numero, valor); 
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 7 - Depósito                    \n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt(); 
				
				do { 
					System.out.println("Digite o valor do depósito (R$): ");
					valor = leia.nextFloat(); 
				} while (valor<=0); 
				contas.depositar(numero, valor); 
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "    OPÇÃO: 8 - Transferir valor entre contas\n");
				System.out.println("Digite o número da conta de origem: ");
				numero = leia.nextInt(); 
				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = leia.nextInt(); 
				
				do { 
					System.out.println("Digite o valor da transferência: ");
					valor = leia.nextFloat(); 
				} while (valor <=0); 
				contas.transferir(numero, numeroDestino, valor); 
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "    OPÇÃO INVÁLIDA! Tente outra vez!       \n");
			}

		}
	}

    	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Gabrielle Ramos");
		System.out.println("github.com/ramosgab1");
		System.out.println("*********************************************************");
	}
    
	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
		
	
		
	}
	
	}