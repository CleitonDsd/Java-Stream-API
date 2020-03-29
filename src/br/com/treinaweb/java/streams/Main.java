package br.com.treinaweb.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Empregado> empregados = new ArrayList<Empregado>();

		empregados.add(new Empregado(1, "Jo�o", 2000, "Producao"));
		empregados.add(new Empregado(2, "Maria", 3000, "RH"));
		empregados.add(new Empregado(3, "Jos�", 5000, "Controladoria"));
		empregados.add(new Empregado(4, "Josefina", 7000, "CTO"));
		System.out.println(" == LISTA DE EMPREGADOS ==");

		/*
		 * for (Empregado emp : empregados) { System.out.println(emp.getNome()); }
		 * double salarioTotal = 0; for (Empregado emp : empregados) { salarioTotal +=
		 * emp.getSalario();
		 * 
		 * }
		 */

		// Stream API
		/**
		 * 1� fonte de dados = empregados 2� m�todo Stream() que lida com um Stream de
		 * <Empregados que vem da nossa List> 3� realizo o m�todo forEach() 4� Tenho o
		 * Consumer que recebe como parametro um empregado, no caso 5� Declaro o
		 * empregado como "emp" 6� emp = empregados 7� O que vamos fazer com esse
		 * empregado dentro de nosso Consumer utilizo o "->" 8� No caso pedimos para
		 * imprimir pegando o nome emp.getNome();
		 * 
		 */
		empregados.stream().forEach(emp -> {
			System.out.println(emp.getNome());
		});
		/**
		 * minha var = minha lista de empregados + fun��o Stream() + capturar Algo que
		 * no caso � double (mapToDouble) + como � uma fun��o aguarda o retorno que no
		 * caso tem que ser double + no caso � o empregado "emp" + lambda "->"
		 * getSalario() + um m�todo para somar que � o "sum()";
		 */
		double salarioTotal = empregados.stream().mapToDouble(emp -> emp.getSalario()).sum();
		System.out.println("Sal�rio Total (R$): " + salarioTotal);

		Mensageiro mensageiro = (mensagem) -> System.out.println("Mensagem da Express�o Lambda: " + mensagem);
		mensageiro.emitirMensagem("Ol�, mundo!");

		// ===============================================
		// Consumert <tipo de dado>
		// Entra uma parametro e n�o retorna nada
		System.out.println("Execu��o do CONSUMER");
		Consumer<Empregado> consumer = (emp) -> {
			System.out.println(emp.getNome() + " , R$ " + emp.getSalario());
		};
		consumer.accept(new Empregado(10, "Cleiton", 1000, "TI"));

		// Functions
		System.out.println("Execu��o da Function");
		Function<Empregado, Double> function = (emp) -> emp.getSalario() * 10;
		double novoSalario = function.apply(new Empregado(1000, "Cleiton", 1000, "TI"));
		System.out.println(novoSalario);

		// BinaryOperator
		System.out.println("Execu��o do BinaryOperator: ");
		BinaryOperator<Empregado> binaryOperator = (emp1, emp2) -> new Empregado(6, emp1.getNome() + emp2.getNome(),
				emp1.getSalario(), "Jun��o");
		Empregado novoEmpregado = binaryOperator.apply(new Empregado(0, "Cleiton", 1000, ""),
				new Empregado(1, " Dsd", 10000, "TI"));
		System.out.println(novoEmpregado.getNome() + ", R$ " + novoEmpregado.getSalario());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
