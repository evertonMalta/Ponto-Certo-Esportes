package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Adapter.FuncionarioAdapter;
import br.com.pontocertosportes.pontocertoesportes.Model.Funcionarios;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ListFuncionariosActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Funcionarios> listaDeFuncionarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_funcionario);

        recyclerView = (RecyclerView)findViewById(R.id.FuncionarioList);
        //listagem porodutos





        //configuração do adapter
        FuncionarioAdapter adapter = new FuncionarioAdapter(listaDeFuncionarios);



        //configuração do Recicle View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


    }


    public void openAddNewClient(View view) {
        Intent intent = new Intent(this, ConfFuncionarioActivity.class);
        startActivity(intent);
    }

}
