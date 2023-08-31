package models;

import java.util.*;
import java.util.List;

import models.DAO;
import models.Aluno;
import models.AlunoDAO;

public class Aplicacao {
	
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);	
		AlunoDAO alunodao = new AlunoDAO();
		
		int escolha = 0;
		
		while(escolha != 5) {
			
			System.out.println("\n------BEM VINDO AO CRUD DE ALUNOS------\n");
			System.out.println("1 - Inserir Aluno");
			System.out.println("2 - Listar Alunos");
			System.out.println("3 - Excluir Aluno");
			System.out.println("4 - Atualizar Aluno");
			System.out.println("5 - Sair do Programa\n");
			System.out.print("Digite o número correspondente ao que deseja");
			
			escolha = scanner.nextInt();
			
			switch(escolha) {
				
			case(1):
				
				System.out.println("\n---INSIRA UM ALUNO---");
			
				System.out.println("Nome");
				String nome = scanner.nextLine();
				
				scanner.nextLine();
				
				System.out.println("Matricula");
				int matricula = scanner.nextInt();
				
				Aluno aluno = new Aluno(nome, matricula);
				alunodao.inserirAluno(aluno);
				
				break;
				
				
			case(2):
				
				System.out.println("\n---ALUNOS REGISTRADOS---\n");
				
				List<Aluno> alunos = alunodao.getAll();
				System.out.println(alunos);
				break;
				
				
			case(3):
				
				System.out.println("\n---DELETANDO UM ALUNO---\n");
				
				System.out.print("Digite a matricula do Aluno: ");
				int matriculaDelete = scanner.nextInt();
				
				alunodao.delete(matriculaDelete);
				break;
				
			case(4):
				
				System.out.println("\n---ATUALIZANDO UM ALUNO---\n");
				
				System.out.println("Digite a matricula do Aluno para que seja atualizado seu nome");
				int matriculaAtualizar = scanner.nextInt();
				
				System.out.println("Novo nome");
				String newNome = scanner.nextLine();
				
				Aluno oldAluno = alunodao.getByMatricula(matriculaAtualizar);
				Aluno newAluno = new Aluno(newNome, oldAluno.getMatricula());
				
				alunodao.update(newAluno);
				
				break;
				
			default:
				System.out.println("Digite um numero valido...\n");
				break;
			}
						
		}
		
		System.out.println("Finalizando...");
		scanner.close();
	}
}
