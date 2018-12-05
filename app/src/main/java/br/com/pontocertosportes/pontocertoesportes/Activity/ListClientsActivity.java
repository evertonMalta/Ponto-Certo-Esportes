package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Adapter.ClientAdapter;
import br.com.pontocertosportes.pontocertoesportes.Adapter.ProductAdapter;
import br.com.pontocertosportes.pontocertoesportes.DAO.ClientDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Clients;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ListClientsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Clients> listaDeClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_clients);
        recyclerView = (RecyclerView)findViewById(R.id.ClientsList);
        //listagem porodutos
        //configuração do adapter
        ClientDAO dao = new ClientDAO(this);
        ClientAdapter adapter = new ClientAdapter(dao.retornarTodos());
        //configuração do Recicle View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


    }

    public void abrirVisualizacao(View view){
        Intent intent = new Intent(this, ViewClientActivity.class);
        startActivity(intent);
    }

    public void openAddNewClient(View view) {
        Intent intent = new Intent(this, ConfClienteActivity.class);
        startActivity(intent);
    }

}
