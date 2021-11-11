package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<>(); //instanciar a lista
		System.out.print("Quantos funcionários serão registrados?");
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			System.out.println();
			System.out.println("Funcionário #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();
			
			Funcionario func = new Funcionario(id, nome, salario);//instanciar funcionario
			list.add(func);//adicionar funcionario na lista
			
		}
		System.out.print("Entre com Id do salário do funcionário que receberá aumento: ");
		int idSalario = sc.nextInt();
		
		
		
		sc.close();

	}//funcao auxiliar: para procurar a posição do  elemento na lista
	public Integer posicao (List<Funcionario> list, int id) {
		for (int i=0; i < list.size(); i++) {
			if(list.get(i).getId()== id) {
				return i;
			}
		}
		return null;
	}

}
