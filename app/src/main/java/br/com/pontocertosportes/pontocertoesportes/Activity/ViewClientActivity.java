package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_view_client);
        Nome = (TextView) findViewById(R.id.NameTxtCliente);
        Aniversario = (TextView) findViewById(R.id.AniversarioTxtCliente);
        Rg = (TextView) findViewById(R.id.RgTxtCliente);
        Cpf = (TextView) findViewById(R.id.CpfTxtCliente);
        Email = (TextView) findViewById(R.id.EmailTxtCliente);
        Telefone = (TextView) findViewById(R.id.TelefoneTxtCliente);
        Endereco = (TextView) findViewById(R.id.EnderecoTxtCliente);
        Intent intent = getIntent();

        clienteEditado = (Clients) getIntent().getExtras().get("cliente");
        Nome.setText(clienteEditado.getName());
        Aniversario.setText(clienteEditado.getAniversario());
        Rg.setText(clienteEditado.getRg());
        Cpf.setText(clienteEditado.getCpf());
        Email.setText(clienteEditado.getEmail());
        Telefone.setText(clienteEditado.getTelefone());
        Endereco.setText(clienteEditado.getRua() + ", " + clienteEditado.getNumero() + ", " + clienteEditado.getCep() + ", " + clienteEditado.getBairro() + ", " + clienteEditado.getCidade() + ", " + clienteEditado.getEstado());

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
