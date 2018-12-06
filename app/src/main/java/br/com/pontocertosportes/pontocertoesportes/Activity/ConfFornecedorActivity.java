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

import br.com.pontocertosportes.pontocertoesportes.Adapter.FornecedorAdapter;
import br.com.pontocertosportes.pontocertoesportes.DAO.FornecedorDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Fornecedores;
import br.com.pontocertosportes.pontocertoesportes.R;
import br.com.pontocertosportes.pontocertoesportes.adapter_fornecedores;

public class ConfFornecedorActivity extends AppCompatActivity {

    EditText nomeFornecedor;
    EditText cnpjFornecedor;
    EditText dtaInauguracaoFornecedor;
    EditText emailFornecedor;
    EditText telefoneFornecedor;
    EditText ruaFornecedor;
    EditText numeroFornecedor;
    EditText cepFornecedor;
    EditText bairroFornecedor;
    EditText cidadeFornecedor;
    EditText estadoFornecedor;

    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_fornecedor);

        //declarando as EditTexts

        nomeFornecedor = (EditText) findViewById(R.id.EditTextNomeFornecedor);
        cnpjFornecedor = (EditText) findViewById(R.id.EditTextCNPJFornecedor);
        dtaInauguracaoFornecedor = (EditText) findViewById(R.id.EditTextDtaInauguracaoFornecedor);
        emailFornecedor = (EditText) findViewById(R.id.EditTextEmailFornecedor);
        telefoneFornecedor = (EditText) findViewById(R.id.EditTextTelefoneFornecedor);
        ruaFornecedor = (EditText) findViewById(R.id.EditTextRuaFornecedor);
        numeroFornecedor = (EditText) findViewById(R.id.EditTextNumeroFornecedor);
        cepFornecedor = (EditText) findViewById(R.id.EditTextCEPFornecedor);
        bairroFornecedor = (EditText) findViewById(R.id.EditTextBairroFornecedor);
        cidadeFornecedor = (EditText) findViewById(R.id.EditTextCidadeFornecedor);
        estadoFornecedor = (EditText) findViewById(R.id.EditTextEstadoFornecedor);

        Intent intent = getIntent();
        if (intent.hasExtra("Fornecedor")){
            fornecedorEditado = (Fornecedores) intent.getSerializableExtra("Fornecedor");
            nomeFornecedor.setText(fornecedorEditado.getName());
            dtaInauguracaoFornecedor.setText(fornecedorEditado.getDtaInauguracao());
            cnpjFornecedor.setText(fornecedorEditado.getCnpj());
            emailFornecedor.setText(fornecedorEditado.getEmail());
            telefoneFornecedor.setText(fornecedorEditado.getTelefone());
            ruaFornecedor.setText(fornecedorEditado.getRua());
            numeroFornecedor.setText(fornecedorEditado.getNumero());
            cepFornecedor.setText(fornecedorEditado.getCep());
            bairroFornecedor.setText(fornecedorEditado.getBairro());
            cidadeFornecedor.setText(fornecedorEditado.getCidade());
            estadoFornecedor.setText(fornecedorEditado.getEstado());
        }
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

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, HomeActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    public void salvar(View view){
        //Pegando os valores
        String Nome = nomeFornecedor.getText().toString();
        String Cnpj = cnpjFornecedor.getText().toString();
        String DtaInauguracao = dtaInauguracaoFornecedor.getText().toString();
        String Email = emailFornecedor.getText().toString();
        String Telefone = telefoneFornecedor.getText().toString();
        String Rua = ruaFornecedor.getText().toString();
        String Numero = numeroFornecedor.getText().toString();
        String Cep = cepFornecedor.getText().toString();
        String Bairro = bairroFornecedor.getText().toString();
        String Cidade = cidadeFornecedor.getText().toString();
        String Estado = estadoFornecedor.getText().toString();

        //Salvando os dados
        FornecedorDAO dao = new FornecedorDAO(getBaseContext());
        FornecedorDAO fornecedorDao = new FornecedorDAO(this);
        adapter_fornecedores adapter = new adapter_fornecedores(fornecedorDao.retornarTodos());

        boolean sucesso;
        if (fornecedorEditado != null)
            sucesso = dao.salvar(fornecedorEditado.getId(),Nome,Cnpj,DtaInauguracao,Telefone,Email,Rua,Numero,Bairro,Cep,Cidade,Estado);
        else
            sucesso = dao.salvar(Nome,Cnpj,DtaInauguracao,Telefone,Email,Rua,Numero,Bairro,Cep,Cidade,Estado);

        if (sucesso){
            Fornecedores fornecedores = dao.retornarUltimo();
            if (fornecedorEditado != null) {
                adapter.atualizarFornecedor(fornecedores);
                fornecedorEditado = null;
            }else
                adapter.adicionarFornecedores(fornecedores);

            //limpa os campos
            nomeFornecedor.setText("");
            cnpjFornecedor.setText("");
            dtaInauguracaoFornecedor.setText("");
            emailFornecedor.setText("");
            telefoneFornecedor.setText("");
            ruaFornecedor.setText("");
            numeroFornecedor.setText("");
            cepFornecedor.setText("");
            bairroFornecedor.setText("");
            cidadeFornecedor.setText("");
            estadoFornecedor.setText("");

            Snackbar.make(view, "Salvou!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            startActivity(new Intent(this, list_fornecedores.class));
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
