package com.example.joaoelolis.todo_list.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.joaoelolis.todo_list.R;
import com.example.joaoelolis.todo_list.modelos.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaAdapter extends ArrayAdapter<Tarefa> {

    private Context context;
    private List<Tarefa> tarefas;

    public TarefaAdapter(Context context, ArrayList<Tarefa> tarefas){

        super(context, 0, tarefas);
        this.tarefas =tarefas;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listaItem = convertView;

        if (listaItem == null){
            listaItem = LayoutInflater.from(context).
                    inflate(R.layout.layout_lista_tarefas,parent ,false);
        }

        Tarefa tarefaAtual = tarefas.get(position);

        TextView textViewNome = listaItem.findViewById(R.id.textViewNomeTarefa);
        TextView textViewStatus = listaItem.findViewById(R.id.textViewStatusTarefa);

        textViewNome.setText(tarefaAtual.getNome());
        textViewStatus.setText(tarefaAtual.getStatus().toString());


        return listaItem;
    }
}
