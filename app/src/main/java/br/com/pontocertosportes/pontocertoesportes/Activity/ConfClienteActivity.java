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

import br.com.pontocertosportes.pontocertoesportes.Adapter.ClientAdapter;
import br.com.pontocertosportes.pontocertoesportes.DAO.ClientDAO;
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

        Intent intent = getIntent();
        if (intent.hasExtra("Cliente")) {
            clienteEditado = (Clients) intent.getSerializableExtra("Cliente");
            nomeClient.setText(clienteEditado.getName());
            aniversarioClient.setText(clienteEditado.getAniversario());
            rgClient.setText(clienteEditado.getRg());
            cpfClient.setText(clienteEditado.getCpf());
            emailClient.setText(clienteEditado.getEmail());
            telefoneClient.setText(clienteEditado.getTelefone());
            ruaClient.setText(clienteEditado.getRua());
            numeroClient.setText(clienteEditado.getNumero());
            cepClient.setText(clienteEditado.getCep());
            bairroClient.setText(clienteEditado.getBairro());
            cidadeClient.setText(clienteEditado.getCidade());
            estadoClient.setText(clienteEditado.getEstado());
        }
    }

    public Clients clienteEditado = null;

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
        String Nome = nomeClient.getText().toString();
        String Aniversario = aniversarioClient.getText().toString();
        String Rg = rgClient.getText().toString();
        String Cpf = cpfClient.getText().toString();
        String Email = emailClient.getText().toString();
        String Telefone = telefoneClient.getText().toString();
        String Rua = ruaClient.getText().toString();
        String Numero = numeroClient.getText().toString();
        String Cep = cepClient.getText().toString();
        String Bairro = bairroClient.getText().toString();
        String Cidade = cidadeClient.getText().toString();
        String Estado = estadoClient.getText().toString();

        //Salvando os dados
        ClientDAO dao = new ClientDAO(getBaseContext());
        ClientDAO clientDAO = new ClientDAO(this);
        ClientAdapter adapter = new ClientAdapter(clientDAO.retornarTodos(), this);

        boolean sucesso;
        if (clienteEditado != null)
            sucesso = dao.salvar(clienteEditado.getId(),Nome,Aniversario,Rg,Cpf,Email,Telefone,Rua,Numero,Cep,Bairro,Cidade,Estado);
        else
            sucesso = dao.salvar(Nome,Aniversario,Rg,Cpf,Email,Telefone,Rua,Numero,Cep,Bairro,Cidade,Estado);

        if (sucesso){
            Clients clients = dao.retornarUltimo();
            if (clienteEditado != null) {
                adapter.atualizarCliente(clients);
                clienteEditado = null;
            }else
                adapter.adicionarCliente(clients);

            //limpa os campos
            nomeClient.setText("");
            aniversarioClient.setText("");
            rgClient.setText("");
            cpfClient.setText("");
            emailClient.setText("");
            telefoneClient.setText("");
            ruaClient.setText("");
            numeroClient.setText("");
            cepClient.setText("");
            bairroClient.setText("");
            cidadeClient.setText("");
            estadoClient.setText("");

            Snackbar.make(view, "Salvou!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            startActivity(new Intent(this, ListClientsActivity.class));
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
