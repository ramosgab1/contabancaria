package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.IContaRepository;

public class ContaController implements IContaRepository {

	// Implementar CRUD (tá na INTERFACE ICRepository) // Primeiro importa, depois
	// implementa.

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.println("A conta número " + numero + " não foi encontrada.");

	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta número " + conta.getNumero() + " foi criada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta, conta));
			System.out.println("A conta número " + conta.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("A conta número " + conta.getNumero() + " não foi encontrada.");

	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (listaContas.remove(conta) == true)
				System.out.println("A conta número " + numero + " foi apagada com sucesso.");
		} else
			System.out.println("A conta numero " + numero + " não foi encontrada.");

	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero); 
		
		if (conta != null) { 
			if (conta.sacar(valor) == true)
				System.out.println("O Saque na conta de número " + numero + " foi efetuado com sucesso.");
		} else 
			System.out.println("A conta de número " + numero + " não foi encontrada."); 

	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero); 
		if (conta != null) { 
			conta.depositar(valor);
			System.out.println("O depósito na conta de número: " + numero + " foi efetuado com sucesso!");
		} else 
			System.out.println(" A conta numero " + numero + " não foi encontrada ou a conta destino não é uma conta corrente.");

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem); 
		var contaDestino = buscarNaCollection(numeroDestino); 
		
		if (contaOrigem != null && contaDestino != null) { 
			if (contaOrigem.sacar(valor) == true ) { 
				contaDestino.depositar(valor);
				System.out.println("A transferência foi concluída com sucesso.");
			}
		} else 
			System.out.println("A conta de Origem e/ou destino não foram encontradas.");

	}

	public int gerarNumero() {
		int numero = 0;
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}

		return null;

	}
}
