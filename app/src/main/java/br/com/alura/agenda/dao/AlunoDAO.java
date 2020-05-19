package br.com.alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadoDeId = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadoDeId);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contadoDeId++;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPelaId(aluno);

        if (alunoEncontrado != null) {
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno, aluno);
        }

    }

    private Aluno buscaAlunoPelaId(Aluno aluno) {
        for (Aluno a : alunos) {
            if (aluno.getId() == a.getId()) {
                return a;
            }
        }
        return null;
    }
}
