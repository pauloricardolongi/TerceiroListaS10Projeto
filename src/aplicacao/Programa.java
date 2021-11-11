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
			while(hasId(list, id)) {
				System.out.println("Este Id já existe! Tente novamente!");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();
			
			Funcionario func = new Funcionario(id, nome, salario);//instanciar funcionario
			list.add(func);//adicionar funcionario na lista
			
		}
		System.out.println();
		System.out.print("Entre com Id do salário do funcionário que receberá aumento: ");
		int idSalario = sc.nextInt();
		
		Funcionario func = list.stream().filter(x -> x.getId()== idSalario).findFirst().orElse(null);
		
		//Integer pos = posicao(list, idSalario);
		if (func == null) {
			System.out.println("Este id não existe!");
		}
		else {
			System.out.print("Entre com o valor da porcentagem!");
			double porcento = sc.nextDouble();
			func.aumentoSalario(porcento);
			
		}
		System.out.println();
		System.out.println("Lista de Funcionários: ");
		for (Funcionario e : list) {
			System.out.println(e);
			
		}
		
		sc.close();

	}
	public static Integer posicao (List<Funcionario> list, int id) {
		for (int i=0; i < list.size(); i++) {
			if(list.get(i).getId()== id) {
				return i;
			}
		}
		return null;
	}//funcao auxiliar: para ver se id existe
	public static boolean hasId(List <Funcionario>list, int id) {
		Funcionario func = list.stream().filter(x -> x.getId()== id).findFirst().orElse(null);
		return func != null;
	}

}
