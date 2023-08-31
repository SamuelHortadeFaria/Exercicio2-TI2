package models;

public class Aluno {

	private String nome;
	private int matricula;
	
	public Aluno() {
		
		super();
		this.nome = "";
		this.matricula = -1;
	}
	
	public Aluno(String nome, int matricula) {
		
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
		return "Aluno [nome " + nome + ", matricula " + matricula + "]";
	}
}
