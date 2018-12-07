package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.pontocertosportes.pontocertoesportes.DAO.ClientDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Clients;
import br.com.pontocertosportes.pontocertoesportes.R;

public class realizarVendas extends AppCompatActivity {

    public Clients clients;

    public EditText NomeClient;
    public EditText CpfClient;
    public EditText CodProduto;
    public EditText NomeProduto;
    public EditText PrecoProduto;
    public EditText QuantidadeProduto;
    public TextView TextCarrinho;
    public TextView TextTotal;

    public Double Total = 0.0;
    public String Carrinho = "";

    Context contexto ;
    String texto;
    int duracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_vendas);
        contexto = getApplicationContext();
        texto = "Venda Realizada com Sucesso";
        duracao = Toast.LENGTH_SHORT;
        NomeClient = (EditText) findViewById(R.id.editTextNomeClienteVenda);
        CpfClient = (EditText) findViewById(R.id.EditTextCPFClienteVenda);
        CodProduto = (EditText) findViewById(R.id.editTextCodProdutoVenda);
        NomeProduto = (EditText) findViewById(R.id.editTextNomeProdutoVenda);
        PrecoProduto = (EditText) findViewById(R.id.editTextPrecoProdutoVenda);
        QuantidadeProduto = (EditText) findViewById(R.id.editTextQuantidadeProdutoVenda);
        TextCarrinho = (TextView) findViewById(R.id.textViewCarrinhoVendas);
        TextTotal = (TextView) findViewById(R.id.textViewTotalVendas);
    }

    public void AdicionouProduto(View view){

        Carrinho = Carrinho + ", " + QuantidadeProduto.getText().toString() + "x " + NomeProduto.getText().toString();
        Total = Total + (Double.parseDouble(PrecoProduto.getText().toString())*Integer.parseInt(QuantidadeProduto.getText().toString()));
        TextCarrinho.setText(Carrinho.toString());
        TextTotal.setText("Total: R$" + Total.toString());
        CodProduto.setText("");
        NomeProduto.setText("");
        PrecoProduto.setText("");
        QuantidadeProduto.setText("");

    }

    public void Comprar(View view){
        NomeClient.setText("");
        CpfClient.setText("");
        CodProduto.setText("");
        NomeProduto.setText("");
        PrecoProduto.setText("");
        QuantidadeProduto.setText("");
        TextCarrinho.setText("");
        TextTotal.setText("Total: ");


        Toast toast = Toast.makeText(contexto, texto,duracao);
        toast.show();
    }

}
