package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Adapter.ProductAdapter;
import br.com.pontocertosportes.pontocertoesportes.DAO.ProdutoDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Product;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ConfEstoqueActivity extends AppCompatActivity {

    EditText NomeProduto;
    EditText CategoriaProduto;
    EditText DataCompraProduto;
    EditText TamanhoProduto;
    EditText PrecoProduto;
    EditText QuantidadeProduto;
    EditText DescricaoProduto;

    int id = 0;
    private List<Product> listaProduto = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //declarando as EditTexts

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_estoque);
        NomeProduto = (EditText) findViewById(R.id.EditTextNomeProduto);
        CategoriaProduto = (EditText) findViewById(R.id.EditTextCategoriaProduto);
        DataCompraProduto = (EditText) findViewById(R.id.editTextDataCompraProduto);
        TamanhoProduto = (EditText) findViewById(R.id.EditTextTamanhoProduto);
        PrecoProduto = (EditText) findViewById(R.id.EditTextPrecoProduto);
        QuantidadeProduto = (EditText) findViewById(R.id.EditTextQuantidadeProduto);
        DescricaoProduto = (EditText) findViewById(R.id.editTextDescricaoProduto);


        Intent intent = getIntent();
        if (intent.hasExtra("Produto")) {
            produtoEditado = (Product) intent.getSerializableExtra("Produto");
            NomeProduto.setText(produtoEditado.getName());
            CategoriaProduto.setText(produtoEditado.getCategoria());
            DataCompraProduto.setText(produtoEditado.getDataCompra());
            TamanhoProduto.setText(produtoEditado.getTamanho());
            PrecoProduto.setText("" + produtoEditado.getPreco());
            QuantidadeProduto.setText(produtoEditado.getQuantidade());
            DescricaoProduto.setText(produtoEditado.getDescricao());
        }
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

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, HomeActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    public void salvar(View view){
        //Pegando os valores
        String Nome = NomeProduto.getText().toString();
        String Categoria = CategoriaProduto.getText().toString();
        String DataCompra = DataCompraProduto.getText().toString();
        int Tamanho = Integer.parseInt(TamanhoProduto.getText().toString());
        float Preco = Float.parseFloat(PrecoProduto.getText().toString());
        int Quantidade = Integer.parseInt(QuantidadeProduto.getText().toString());
        String Descricao = DescricaoProduto.getText().toString();

        //Salvando os dados
        ProdutoDAO dao = new ProdutoDAO(getBaseContext());
        ProdutoDAO produtoDAO = new ProdutoDAO(this);
        ProductAdapter adapter = new ProductAdapter(produtoDAO.retornarTodos());

        boolean sucesso;
        if (produtoEditado != null)
            sucesso = dao.salvar(produtoEditado.getID(),Nome,DataCompra,Categoria,Descricao,Tamanho,Quantidade,Preco);
        else
            sucesso = dao.salvar(Nome,DataCompra,Categoria,Descricao,Tamanho,Quantidade,Preco);

        if (sucesso){
            Product product = dao.retornarUltimo();
            if (produtoEditado != null) {
                adapter.atualizarProduto(product);
                produtoEditado = null;
            }else
                adapter.adicionarProdutos(product);

            //limpa os campos
            NomeProduto.setText("");
            CategoriaProduto.setText("");
            DataCompraProduto.setText("");
            DescricaoProduto.setText("");
            TamanhoProduto.setText("");
            QuantidadeProduto.setText("");
            PrecoProduto.setText("");

            Snackbar.make(view, "Salvou!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            startActivity(new Intent(this, ListProductActivity.class));
        }else{
            Snackbar.make(view, "Erro ao salvar, consulte os logs!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }

        //inseriri no banco aqui

    }

    public void cancelar(View view){
        finish();
    }

}
