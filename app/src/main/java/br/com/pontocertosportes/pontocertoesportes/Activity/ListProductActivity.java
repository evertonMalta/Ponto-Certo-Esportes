package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Adapter.ProductAdapter;
import br.com.pontocertosportes.pontocertoesportes.Model.Product;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ListProductActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Product> listaProdutos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);


        recyclerView = (RecyclerView)findViewById(R.id.ProductList);
        //listagem porodutos
        this.CriarProdutos();




        //configuração do adapter
        ProductAdapter adapter = new ProductAdapter(listaProdutos);



        //configuração do Recicle View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public void CriarProdutos(){
        //Product product = new Product("Julio Cesar","01","12345678988");
        //this.listaProdutos.add(product);

        //product = new Product("Fernando Fernandinho","02","54544848125");
        //this.listaProdutos.add(product);

        //product = new Product("Ademir Damasciano","03","25541521533");
        //this.listaProdutos.add(product);

        //product = new Product("Julio Correia","04","25556123632");
        //this.listaProdutos.add(product);

        //product = new Product("Felipe Smith","05","14523354888");
        //this.listaProdutos.add(product);
    }



}
