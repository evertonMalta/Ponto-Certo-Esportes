package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Adapter.ProductAdapter;
import br.com.pontocertosportes.pontocertoesportes.DAO.ProdutoDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Product;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ListProductActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public static List<Product> listaProdutos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);


        recyclerView = (RecyclerView)findViewById(R.id.ProductList);
        //listagem porodutos



        //configuração do adapter
        ProductAdapter adapter = new ProductAdapter(this.listaProdutos);



        //configuração do Recicle View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }



    public void openAddNewProduct(View view) {
        Intent intent = new Intent(this, ConfEstoqueActivity.class);
        startActivity(intent);

    }

    public void AdcProduct(){
        Product product = new Product(ConfEstoqueActivity.Nome.getText().toString(), 0,ConfEstoqueActivity.Categoria.getText().toString(),ConfEstoqueActivity.DataCompra.getText().toString(), Integer.parseInt(ConfEstoqueActivity.Tamanho.getText().toString()), Double.parseDouble(ConfEstoqueActivity.Preco.getText().toString()) , Integer.parseInt(ConfEstoqueActivity.Quantidade.getText().toString()), ConfEstoqueActivity.Descricao.getText().toString());
        ListProductActivity.listaProdutos.add(product);
        Intent intent = new Intent(this, ListProductActivity.class);
        startActivity(intent);
    }

}