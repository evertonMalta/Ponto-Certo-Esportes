package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.com.pontocertosportes.pontocertoesportes.Adapter.ProductAdapter;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ProductActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        recyclerView = (RecyclerView)findViewById(R.id.ProductList);

        //configuração do adapter
        ProductAdapter adapter = new ProductAdapter();


        //configuração do Recicle View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }
}
