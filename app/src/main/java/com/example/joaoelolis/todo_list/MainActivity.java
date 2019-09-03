package com.example.joaoelolis.todo_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.joaoelolis.todo_list.adapter.TarefaActivity;
import com.example.joaoelolis.todo_list.adapter.TarefaAdapter;
import com.example.joaoelolis.todo_list.modelos.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Tarefa> tarefas = new ArrayList<>();
    private ArrayAdapter<Tarefa> arrayAdapterTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listViewTarefas);
        criarTarefas();
        arrayAdapterTarefa = new TarefaAdapter
                (MainActivity.this, (ArrayList<Tarefa>) tarefas);
        listView.setAdapter(arrayAdapterTarefa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,
                        TarefaActivity.class);
                intent.putExtra("TITULO",tarefas.get(position).getNome());

                Intent intent1 = new Intent(MainActivity.this,
                        TarefaActivity.class);
                intent.putExtra("DESCRICAO",tarefas.get(position).getDescricao());

                startActivity(intent);

                /*Toast toast = Toast.makeText(getApplicationContext(),
                        tarefas.get(position).getNome(),
                        Toast.LENGTH_SHORT);
                toast.show();*/
            }
        });
    }

    public void criarTarefas(){
        tarefas.add(new Tarefa("1","Estudar android",
                "Estudar no site W3school.com os metodos Android",false));

        tarefas.add(new Tarefa("2","Estudar Phyton",
                "Estudar no site W3school.com a linguagem phyton",false));

        tarefas.add(new Tarefa("3","Estudar PHP",
                "Estudar no site W3school.com PHP Front-end",false));

        tarefas.add(new Tarefa("4","Estudar sqlServer",
                "Estudar no SqlServer no SENAC",false));

        tarefas.add(new Tarefa("5","Jogar PUBG",
                "Jogar até vencer 3",false));
    }
}
