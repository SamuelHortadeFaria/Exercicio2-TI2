package Integracao;

import java.sql.Connection;
import java.util.Scanner;

public class IntegracaoSQL_TI2_Ex2 {

    public static void main(String[] args) {

        DBFunctions db = new DBFunctions();
        Connection conexao = db.conectarBanco("postgres", "postgres", "07Samuel!");
        Scanner scanner = new Scanner(System.in);

        // Inicia a tabela alunos
        db.criarTabela(conexao, "alunos");

        while (true) {

            System.out.println("Escolha uma opção: ");

            System.out.println("1 - Inserir novo aluno");
            System.out.println("2 - Ler tabela");
            System.out.println("3 - Atualizar dados da tabela");
            System.out.println("4 - Deletar um elemento da tabela");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
            
            	case 1:
            	
	            	System.out.println("Digite o nome do novo aluno: ");
	            	String novoNome1 = scanner.next();
	            	System.out.println("Digite a matrícula do novo aluno: ");
	            	String novaMatriculaAluno = scanner.next();
	            	db.inserirLinha(conexao, "alunos", novoNome1, novaMatriculaAluno);
	            	break;

                case 2:
                    db.lerDados(conexao, "alunos");
                    break;

                case 3:
                	
                    System.out.println("Digite a matrícula do aluno a ser atualizado: ");
                    String matriculaAntiga = scanner.next();
                    System.out.println("Digite o novo nome do aluno: ");
                    String novoNome = scanner.next();
                    db.atualizarNome(conexao, "alunos", matriculaAntiga, novoNome);
                    
                    break;

                case 4:
                	
                    System.out.println("Digite a matrícula do aluno a ser deletado: ");
                    String matricula = scanner.next();
                    db.deletarLinha(conexao, "alunos", matricula);
                    
                    break;


                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}