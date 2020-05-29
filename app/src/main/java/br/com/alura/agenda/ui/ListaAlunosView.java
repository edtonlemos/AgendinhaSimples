package br.com.alura.agenda.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {

    private ListaAlunosAdapter adapter;
    private Context contexto;
    private final AlunoDAO dao = new AlunoDAO();

    public ListaAlunosView(Context contexto) {
        this.contexto = contexto;
    }

    public void confirmaRemocao(final MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.activity_lista_alunos_menu_remover) {

            new AlertDialog.Builder(contexto)
                    .setTitle("Removendo aluno")
                    .setMessage("Tem certeza que deseja remover o aluno da lista?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AdapterView.AdapterContextMenuInfo
                                    menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                            Aluno alunoSelecionado = adapter.getItem(menuInfo.position);
                            remove(alunoSelecionado);
                        }
                    })
                    .setNegativeButton("Não", null)
                    .show();
        }
    }

    public void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    public void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
        Toast.makeText(contexto, "Aluno removido!", Toast.LENGTH_SHORT).show();
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        adapter = new ListaAlunosAdapter(contexto);
        listaDeAlunos.setAdapter(adapter);
    }

}
