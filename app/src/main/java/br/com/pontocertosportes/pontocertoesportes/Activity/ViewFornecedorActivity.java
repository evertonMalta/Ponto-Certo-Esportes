package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.pontocertosportes.pontocertoesportes.Model.Fornecedores;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ViewFornecedorActivity extends AppCompatActivity {

    TextView Nome;
    TextView DtaInauguracao;
    TextView Cnpj;
    TextView Email;
    TextView Telefone;
    TextView Endereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_view_fornecedor);
        Nome = (TextView) findViewById(R.id.nameTxtFornecedor);
        DtaInauguracao = (TextView) findViewById(R.id.dtaInauguracaotxtFornecedor);
        Cnpj = (TextView) findViewById(R.id.CnpjTextFornecedor);
        Email = (TextView) findViewById(R.id.EmailTextFornecedor);
        Telefone = (TextView) findViewById(R.id.telefoneTextFornecedor);
        Endereco = (TextView) findViewById(R.id.enderecoTextFornecedor);
        Intent intent = getIntent();

        fornecedorEditado = (Fornecedores) getIntent().getExtras().get("fornecedor");
        Nome.setText(fornecedorEditado.getName());
        DtaInauguracao.setText(fornecedorEditado.getDtaInauguracao());
        Cnpj.setText(fornecedorEditado.getCnpj());
        Email.setText(fornecedorEditado.getEmail());
        Telefone.setText(fornecedorEditado.getTelefone());
        Endereco.setText(fornecedorEditado.getRua() + ", " + fornecedorEditado.getNumero() + ", " + fornecedorEditado.getCep() + ", " + fornecedorEditado.getBairro() + ", " + fornecedorEditado.getCidade() + ", " + fornecedorEditado.getEstado());

    }

    public Fornecedores fornecedorEditado = null;

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

    private void alterarFornecedor(View view){
        Intent intent = new Intent(this, ConfFornecedorActivity.class);
        startActivity(intent);
    }

}
