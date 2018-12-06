package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.pontocertosportes.pontocertoesportes.Model.Product;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ViewProdutoActivity extends AppCompatActivity {

    TextView Nome;
    TextView DtaCompra;
    TextView Categoria;
    TextView Descricao;
    TextView Tamanho;
    TextView Quantidade;
    TextView Preco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_view_produto);
        Nome = (TextView) findViewById(R.id.nameTxtProduct);
        DtaCompra = (TextView) findViewById(R.id.DateBuyTextProduct);
        Categoria = (TextView) findViewById(R.id.CategoriaTextProduto);
        Descricao = (TextView) findViewById(R.id.DescricaoTextProduct);
        Tamanho = (TextView) findViewById(R.id.TamanhoTextProduto);
        Quantidade = (TextView) findViewById(R.id.QuantidadeTextProduto);
        Preco = (TextView) findViewById(R.id.PrecoTextProduto);
        Intent intent = getIntent();



        produtoEditado = (Product) getIntent().getExtras().get("cliente");
        Nome.setText(produtoEditado.getName());
        DtaCompra.setText(produtoEditado.getDataCompra());
        Categoria.setText(produtoEditado.getCategoria());
        Descricao.setText(produtoEditado.getDescricao());
        Tamanho.setText(produtoEditado.getTamanho());
        Quantidade.setText(produtoEditado.getQuantidade());
        Preco.setText("" + produtoEditado.getPreco());

    }

    public Product produtoEditado = null;

    private int getIndex(Spinner spinner, String myString){
        int index = 0;
        for (int i = 0;i < spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
                break;
            }
        }
        return index;
    }

    private void alterarCliente(View view){
        Intent intent = new Intent(this, ConfClienteActivity.class);
        startActivity(intent);
    }
}
