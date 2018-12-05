package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Adapter.FornecedorAdapter;
import br.com.pontocertosportes.pontocertoesportes.DAO.FornecedorDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Fornecedores;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ListFornecedoresActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Fornecedores> listaDeFornecedores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fornecedor);
        recyclerView = (RecyclerView)findViewById(R.id.FornecedorList);
        //listagem porodutos
        //configuração do adapter
        FornecedorDAO dao = new FornecedorDAO(this);
        FornecedorAdapter adapter = new FornecedorAdapter(dao.retornarTodos());
        //configuração do Recicle View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

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
