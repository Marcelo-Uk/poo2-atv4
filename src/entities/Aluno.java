package entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import entities.enums.Status;

public class Aluno {
	
	private String cpf;
	private String nome;
	private List<Matricula> listaMatricula = new ArrayList<>();
	private Status status;
	
	public Aluno(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Aluno [cpf=" + cpf + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(nome, other.nome);
	}
	
	public void listarMatriculas() {
		
		if (this.listaMatricula.isEmpty()) {
			System.out.println("Aluno(a)" + this.nome + "não possui matrículas!");
		}
		
		if (!this.listaMatricula.isEmpty()){
			
			for (Matricula m : this.listaMatricula) {
				System.out.println("\tDisciplina: " + m.getDisciplina().getNome()
						+"Turma: " + m.getTurma().getNome()
						+"Status: " + m.getStatus()
						);
			}
		}
	}
	
	public boolean addMatriculaAluno(Matricula m) {
		//verificar se m não é null
		//verificar se o aluno já não está matriculado
		
		if (m != null && !listaMatricula.contains(m)) {
			this.listaMatricula.add(m);
			return true;
		}
		return false;		
	}
	
	public boolean removeMatriculaAluno(Matricula m) {
		if (m != null || listaMatricula.size() > 0 || listaMatricula.contains(m)) {
			this.listaMatricula.remove(m);
			return true;
		}
		return false;
	}
	
	public void confirmarPagamento() {
		if (this.status == Status.PENDENTE || this.status == Status.TRANCADO)
		this.status = Status.CURSANDO;
	}
	
	public void trancar() {
		if (this.status == Status.CURSANDO)
		this.status = Status.TRANCADO;
	}
	
	public void aprovar() {
		if (this.status == Status.CURSANDO)
		this.status = Status.CONCLUIDO;
	}
	
	public void reprovar() {
		if (this.status == Status.CURSANDO)
		this.status = Status.REPROVADO;
	}
}
