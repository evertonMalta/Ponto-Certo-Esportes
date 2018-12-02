package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Adapter.ClientAdapter;
import br.com.pontocertosportes.pontocertoesportes.Adapter.ProductAdapter;
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
        ClientAdapter adapter = new ClientAdapter(listaDeClientes);



        //configuração do Recicle View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


    }


    public void openAddNewClient(View view) {
        Intent intent = new Intent(this, ConfClienteActivity.class);
        startActivity(intent);
    }

}
