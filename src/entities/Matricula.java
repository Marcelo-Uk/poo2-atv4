package entities;
import java.util.Date;

import entities.enums.Status;

public class Matricula {
	
	private Date dataMatricula;
	private Aluno aluno;
	private Turma turma;
	private Disciplina disciplina;
	private Status status;
	
	public Matricula(Date dataMatricula, Aluno aluno, Turma turma, Disciplina disciplina, Status status) {
		this.dataMatricula = dataMatricula;
		this.aluno = aluno;
		this.turma = turma;
		this.disciplina = disciplina;
		this.status = Status.PENDENTE;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Matricula [dataMatricula=" + dataMatricula + ", aluno=" + aluno + ", turma=" + turma + ", disciplina="
				+ disciplina + ", status=" + status + "]";
	}
	
}
