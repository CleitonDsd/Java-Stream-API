package br.com.treinaweb.java.streams;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Empregado> empregados = new ArrayList<Empregado>();

		empregados.add(new Empregado(1, "João", 2000, "Producao"));
		empregados.add(new Empregado(2, "Maria", 3000, "RH"));
		empregados.add(new Empregado(3, "José", 5000, "Controladoria"));
		empregados.add(new Empregado(4, "Josefina", 7000, "CTO"));
		System.out.println(" == LISTA DE EMPREGADOS ==");

		/*
		 * for (Empregado emp : empregados) { System.out.println(emp.getNome()); }
		 * double salarioTotal = 0;
		 * for (Empregado emp : empregados) { salarioTotal += emp.getSalario();
		 * 
		 * }
		 */
		
		//Stream API
		/**
		 * 1° fonte de dados = empregados
		 * 2° método Stream() que lida com um Stream de <Empregados que vem da nossa List>
		 * 3° realizo o método forEach()
		 * 4° Tenho o Consumer que recebe como parametro um empregado, no caso
		 * 5° Declaro o empregado como "emp"
		 * 6° emp = empregados
		 * 7° O que vamos fazer com esse empregado dentro de nosso Consumer utilizo o "->" 
		 * 8° No caso pedimos para imprimir pegando o nome emp.getNome();
		 * 
		 */	
		empregados.stream().forEach(emp -> {
			System.out.println(emp.getNome());
		});
		
		/**
		 * minha var = minha lista de empregados + função Stream() + capturar Algo que 
		 * no caso é double (mapToDouble) + como é uma função aguarda o retorno que no
		 *  caso tem que ser double + no caso é o empregado "emp" + lambda "->" getSalario() +
		 *  um método para somar que é o "sum()";
		 */
		double salarioTotal = empregados.stream().mapToDouble(emp -> emp.getSalario()).sum();

		System.out.println("Salário Total (R$): " + salarioTotal);
	}

}
