package com.example.joaoelolis.todo_list.adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.joaoelolis.todo_list.R;

public class TarefaActivity extends AppCompatActivity {

    private TextView textViewTituloTarefa;
    private TextView textViewDescricaoTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);

        textViewTituloTarefa = findViewById(R.id.textViewTituloTarefa);
        textViewDescricaoTarefa = findViewById(R.id.textViewDescricaoTarefa);

        Intent intent =  getIntent();
        String titulo = intent.getStringExtra("TITULO");
        String descricao = intent.getStringExtra("DESCRICAO");

        textViewTituloTarefa.setText(titulo);
        textViewDescricaoTarefa.setText(descricao);
    }
}
