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


    String NomeProduct;
    String DtaCompraProduct;
    String CategoriaProduct;
    String DescricaoProduct;
    int TamanhoProduct;
    int QuantidadeProduct;
    Double PrecoProduct;

    Product produto;

    public ViewProdutoActivity(Product productSelecionado) {


        NomeProduct = productSelecionado.getName();
        DtaCompraProduct = productSelecionado.getDataCompra();
        CategoriaProduct = productSelecionado.getCategoria();
        DescricaoProduct = productSelecionado.getDescricao();
        TamanhoProduct = productSelecionado.getTamanho();
        QuantidadeProduct = productSelecionado.getQuantidade();
        PrecoProduct = productSelecionado.getPreco() ;

        produto = productSelecionado;


    }
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

        Nome.setText(NomeProduct);
        DtaCompra.setText(DtaCompraProduct);
        Categoria.setText(CategoriaProduct);
        Descricao.setText(DescricaoProduct);
        Tamanho.setText(TamanhoProduct);
        Quantidade.setText(QuantidadeProduct);
        Preco.setText("" + PrecoProduct);

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
