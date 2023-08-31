package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends DAO{

	public AlunoDAO(){
		
		super();
		conectar();
	}
	
	public void finalizar() {
		
		close();
	}
	
	/*----------INSERINDO ALUNO------------------------*/
	public boolean inserirAluno(Aluno aluno) {
		
		boolean status = false;
		try {
			
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO Aluno (nome, matricula) " + "VALUES ('"+aluno.getNome()+ "', '" + aluno.getMatricula() + "');";
			
			System.out.println(sql);
			st.executeUpdate(sql);
			
			st.close();
			status = true;
			
		} catch (SQLException u) {
			
			throw new RuntimeException(u);
		}
		
		return status;
		}
	/*------------------------------------------------*/
	
	/*--------IMPRIMINDO ALUNOS-----------------------*/
	
	public List<Aluno> getAll(){
		
		List<Aluno> alunos = new ArrayList<>();
		
		try {
			
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			String sql = "SELECT * FROM aluno";
			System.out.println(sql);
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				Aluno aluno = new Aluno(rs.getString("nome"), rs.getInt("matricula"));
				alunos.add(aluno);
			}
			
			st.close();
			} 
			catch(Exception e) {
				
				System.out.println(e.getMessage());
		}
		return alunos;
	}
	
	/*------------------------------------------------*/
	
	/*---------------EXCLUINDO UM ALUNO---------------*/

	public boolean delete(int matricula) {
		
		boolean status = false;
		
			try {
				
				Statement st = conexao.createStatement();

				String sql = "DELETE FROM aluno WHERE matricula = " + matricula;
				System.out.println(sql);
				
				st.executeUpdate(sql);
				st.close();
				status = true;
				
			} 
			catch (SQLException u) {
				throw new RuntimeException(u);
			}
			
			return status;
		}
	
	/*------------------------------------------------*/
	
	/*-------------RETORNANDO POR MATRICULA-----------*/
	
	public Aluno getByMatricula(int matricula) {
		
		Aluno aluno = null;
			try {
				
				Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				String sql = "SELECT * FROM aluno where matricula = " + matricula;
				
				System.out.println(sql);
				ResultSet rs = st.executeQuery(sql);
				
				if (rs.next()) {
					aluno = new Aluno(rs.getString("nome"), rs.getInt("matricula"));
				}
				
				st.close();
			} 
			catch (Exception e) {
				
				System.err.println(e.getMessage());
			}
		return aluno;
	}
	
	/*------------------------------------------------*/
	
	/*-----------------ATUALIZANDO ALUNO--------------*/
	
	public boolean update(Aluno aluno) {
		
		boolean status = false;
		
			try {
				
			Statement st = conexao.createStatement();
			
			String sql = "UPDATE aluno SET nome = '" + aluno.getNome() + "', matricula = '"
			+ aluno.getMatricula() + "'" + " WHERE matricula = " + aluno.getMatricula();
			
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} 
		catch (SQLException u) {
			
			throw new RuntimeException(u);
		}
		return status;
	}
	
	/*------------------------------------------------*/
}
