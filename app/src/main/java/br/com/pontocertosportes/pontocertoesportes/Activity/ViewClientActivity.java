package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.pontocertosportes.pontocertoesportes.Adapter.ClientAdapter;
import br.com.pontocertosportes.pontocertoesportes.DAO.ClientDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Clients;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ViewClientActivity extends AppCompatActivity {

    TextView Nome;
    TextView Aniversario;
    TextView Rg;
    TextView Cpf;
    TextView Email;
    TextView Telefone;
    TextView Endereco;

    String NomeClient;
    String AniversarioClient;
    String RgClient;
    String CpfClient;
    String EmailClient;
    String TelefoneClient;
    String EnderecoClient;

    Clients cliente;

/*
    public ViewClientActivity(Clients clientSelecionado) {


        NomeClient = clientSelecionado.getName();
        AniversarioClient = clientSelecionado.getAniversario();
        RgClient = clientSelecionado.getRg();
        CpfClient = clientSelecionado.getCpf();
        EmailClient = clientSelecionado.getEmail();
        TelefoneClient = clientSelecionado.getEmail();
        EnderecoClient = clientSelecionado.getRua() + ", " + clientSelecionado.getNumero() + ", " + clientSelecionado.getCep() + ", " + clientSelecionado.getBairro() + ", " + clientSelecionado.getCidade() + ", " + clientSelecionado.getEstado();

        cliente = clientSelecionado;


    }*/
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Nome = (TextView) findViewById(R.id.NameTxtCliente);
        Aniversario = (TextView) findViewById(R.id.AniversarioTxtCliente);
        Rg = (TextView) findViewById(R.id.RgTxtCliente);
        Cpf = (TextView) findViewById(R.id.CpfTxtCliente);
        Email = (TextView) findViewById(R.id.EmailTxtCliente);
        Telefone = (TextView) findViewById(R.id.TelefoneTxtCliente);
        Endereco = (TextView) findViewById(R.id.EnderecoTxtCliente);

        setContentView(R.layout.activity_view_client);
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getInt("id");
        }else{
            id = 0;
        }
        ClientDAO clienteDao = new ClientDAO(this);
        cliente = clienteDao.selecionar(id);
        //

        Nome.setText(cliente.getName());
        Aniversario.setText(cliente.getAniversario());
        Rg.setText(cliente.getRg());
        Cpf.setText(cliente.getCpf());
        Email.setText(cliente.getEmail());
        Telefone.setText(cliente.getTelefone());
        Endereco.setText(cliente.getRua() + ", " + cliente.getNumero() + ", " + cliente.getCep() + ", " + cliente.getBairro() + ", " + cliente.getCidade() + ", " + cliente.getEstado());


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

    private void alterarCliente(View view){
        Intent intent = new Intent(this, ConfClienteActivity.class);
        startActivity(intent);
    }

}
