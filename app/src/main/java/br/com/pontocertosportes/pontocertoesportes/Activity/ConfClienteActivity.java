package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Model.Clients;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ConfClienteActivity extends AppCompatActivity {


    EditText nomeClient;
    EditText rgClient;
    EditText cpfClient;
    EditText aniversarioClient;
    EditText emailClient;
    EditText telefoneClient;
    EditText ruaClient;
    EditText numeroClient;
    EditText cepClient;
    EditText bairroClient;
    EditText cidadeClient;
    EditText estadoClient;

    int id = 0;
    private List<Clients> listaCliente = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_cliente);

        //declarando as EditTexts

        nomeClient = (EditText) findViewById(R.id.EditTextNomeCliente);
        rgClient = (EditText) findViewById(R.id.EditTextRGCliente);
        cpfClient = (EditText) findViewById(R.id.EditTextCPFCliente);
        aniversarioClient = (EditText) findViewById(R.id.EditTextAniversarioCliente);
        emailClient = (EditText) findViewById(R.id.EditTextEmailCliente);
        telefoneClient = (EditText) findViewById(R.id.EditTextTelefoneCliente);
        ruaClient = (EditText) findViewById(R.id.EditTextRuaCliente);
        numeroClient = (EditText) findViewById(R.id.EditTextNumeroCliente);
        cepClient = (EditText) findViewById(R.id.EditTextCEPCliente);
        bairroClient = (EditText) findViewById(R.id.EditTextBairroCliente);
        cidadeClient = (EditText) findViewById(R.id.EditTextCidadeCliente);
        estadoClient = (EditText) findViewById(R.id.EditTextEstadoCliente);
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, HomeActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    public void salvar(){

        Clients client = new Clients();

         client.setName(nomeClient.getText().toString());
        client.setCpf(cpfClient.getText().toString());
        client.setRg( rgClient.getText().toString());
        client.setAniversario(aniversarioClient.getText().toString());
        client.setEmail(emailClient.getText().toString());
        client.setTelefone(telefoneClient.getText().toString());
        client.setRua(ruaClient.getText().toString());
        client.setNumero(numeroClient.getText().toString());
        client.setCep(cepClient.getText().toString());
        client.setBairro(bairroClient.getText().toString());
        client.setCidade(cidadeClient.getText().toString());
        client.setEstado(estadoClient.getText().toString());


        //inseriri no banco aqui

    }

    public void cancelar(View view){
        finish();
    }
}
