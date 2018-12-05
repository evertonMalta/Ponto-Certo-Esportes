package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import br.com.pontocertosportes.pontocertoesportes.Model.Product;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ConfEstoqueActivity extends AppCompatActivity {

    public static EditText Nome;
    public static EditText Categoria;
    public static EditText DataCompra;
    public static EditText Tamanho;
    public static EditText Preco;
    public static EditText Quantidade;
    public static EditText Descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Nome = (EditText) findViewById(R.id.EditTextNomeProduto);
        Categoria = (EditText) findViewById(R.id.EditTextCategoriaProduto);
        DataCompra = (EditText) findViewById(R.id.editTextDataCompraProduto);
        Tamanho = (EditText) findViewById(R.id.EditTextTamanhoProduto);
        Preco = (EditText) findViewById(R.id.EditTextPrecoProduto);
        Quantidade = (EditText) findViewById(R.id.EditTextQuantidadeProduto);
        Descricao = (EditText) findViewById(R.id.editTextDescricaoProduto);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_estoque);
    }


}
