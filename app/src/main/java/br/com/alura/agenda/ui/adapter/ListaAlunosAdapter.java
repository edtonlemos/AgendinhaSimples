package br.com.alura.agenda.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter {

    private final ArrayList<Aluno> alunos = new ArrayList<>();
    private Context contexto;

    public ListaAlunosAdapter(Context contexto) {
        this.contexto = contexto;
    }


    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int posicao) {
        return alunos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return alunos.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") View viewCriada = LayoutInflater
                .from(contexto)
                .inflate(R.layout.item_aluno, viewGroup, false);

        TextView nome = viewCriada.findViewById(R.id.item_aluno_nome);
        nome.setText(alunos.get(posicao).getNome());
        TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);
        telefone.setText(alunos.get(posicao).getTelefone());
        return viewCriada;
    }

    public void remove(Aluno aluno) {
        this.alunos.remove(aluno);
        notifyDataSetChanged();
    }

    public void atualiza(List<Aluno> alunos) {
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }
}

