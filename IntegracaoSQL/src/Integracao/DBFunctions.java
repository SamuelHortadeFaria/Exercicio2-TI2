package Integracao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBFunctions {
	

    public Connection conectarBanco(String nomeBanco, String aluno, String matricula) {

        Connection conexao = null;

        try {
        	
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nomeBanco, aluno, matricula);
            
            if (conexao != null)
                System.out.println("Conexão Estabelecida");
            else
                System.out.println("Falha na Conexão");

        } catch (Exception e) {
            System.out.println(e);
        }
        return conexao;
    }

    
    
    public void criarTabela(Connection conexao, String nomeTabela) {

        Statement declaracao;
        try {

            String query = "CREATE TABLE IF NOT EXISTS " + nomeTabela
                    + "(matricula varchar(200), nome varchar(200), primary key(matricula));";
            declaracao = conexao.createStatement();
            declaracao.executeUpdate(query);
            System.out.println("Tabela Criada");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirLinha(Connection conexao, String nomeTabela, String nomeAluno, String matriculaAluno) {

        Statement declaracao;

        try {
        	
            String query = String.format("INSERT INTO %s(nome_aluno, matricula_aluno) VALUES('%s', '%s');",
                    nomeTabela, nomeAluno, matriculaAluno);
            declaracao = conexao.createStatement();
            declaracao.executeUpdate(query);
            System.out.println("Linha Inserida");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void lerDados(Connection conexao, String nomeTabela) {

        Statement declaracao;
        ResultSet rs = null;

        try {
        	
            String query = String.format("select * from %s", nomeTabela);
            declaracao = conexao.createStatement();
            rs = declaracao.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("matricula_aluno") + " ");
                System.out.println(rs.getString("nome_aluno") + " ");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void atualizarNome(Connection conexao, String nomeTabela, String matriculaAntiga, String novoNome) {

        Statement declaracao;

        try {
        	
            String query = String.format("Update %s set nome_aluno = '%s' where matricula_aluno = '%s'", nomeTabela, novoNome,
                    matriculaAntiga);
            declaracao = conexao.createStatement();
            declaracao.executeUpdate(query);
            System.out.println("Dados Atualizados");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deletarLinha(Connection conexao, String nomeTabela, String matricula) {

        Statement declaracao;

        try {
        	
            String query = String.format("delete from %s where matricula_aluno = '%s'", nomeTabela, matricula);
            declaracao = conexao.createStatement();
            declaracao.executeUpdate(query);
            System.out.println("Dados Deletados");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
