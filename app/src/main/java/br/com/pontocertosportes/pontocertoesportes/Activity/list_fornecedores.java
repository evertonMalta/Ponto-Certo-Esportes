package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.pontocertosportes.pontocertoesportes.Adapter.FornecedorAdapter;
import br.com.pontocertosportes.pontocertoesportes.DAO.FornecedorDAO;
import br.com.pontocertosportes.pontocertoesportes.R;

public class list_fornecedores extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_list_fornecedores);
        recyclerView = (RecyclerView)findViewById(R.id.FornecedorList1);
        //listagem porodutos
        //configuração do adapter
        FornecedorDAO dao = new FornecedorDAO(this);
        FornecedorAdapter adapter = new FornecedorAdapter(dao.retornarTodos());
        //configuração do Recicle View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    public void abrirVisualizacaoFornecedor(View view){
        Intent intent = new Intent(this, ViewFornecedorActivity.class);
        startActivity(intent);
    }

    public void openAddNewFornecedor(View view) {
        Intent intent = new Intent(this, ConfFornecedorActivity.class);
        startActivity(intent);
    }
}
