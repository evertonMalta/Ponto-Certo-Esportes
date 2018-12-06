package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.pontocertosportes.pontocertoesportes.Model.Funcionarios;
import br.com.pontocertosportes.pontocertoesportes.R;


public class ViewFuncionarioActivity extends AppCompatActivity {


    TextView Nome;
    TextView Aniversario;
    TextView Rg;
    TextView Cpf;
    TextView Email;
    TextView Telefone;
    TextView Endereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_view_funcionario);
        Nome = (TextView) findViewById(R.id.NomeTextFuncionario);
        Aniversario = (TextView) findViewById(R.id.AniversarioTextFuncionario);
        Rg = (TextView) findViewById(R.id.RgTextFuncionario);
        Cpf = (TextView) findViewById(R.id.CpfTextFuncionario);
        Email = (TextView) findViewById(R.id.EmailTextFuncionario);
        Telefone = (TextView) findViewById(R.id.TelefoneTextFuncionario);
        Endereco = (TextView) findViewById(R.id.EnderecoTextFuncionario);
        Intent intent = getIntent();

        funcionarioEditado = (Funcionarios) getIntent().getExtras().get("funcionario");
        Nome.setText(funcionarioEditado.getName());
        Aniversario.setText(funcionarioEditado.getAniversario());
        Rg.setText(funcionarioEditado.getRg());
        Cpf.setText(funcionarioEditado.getCpf());
        Email.setText(funcionarioEditado.getEmail());
        Telefone.setText(funcionarioEditado.getTelefone());
        Endereco.setText(funcionarioEditado.getRua() + ", " + funcionarioEditado.getNumero() + ", " + funcionarioEditado.getCep() + ", " + funcionarioEditado.getBairro() + ", " + funcionarioEditado.getCidade() + ", " + funcionarioEditado.getEstado());

    }

    public Funcionarios funcionarioEditado = null;

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

    private void alterarFuncionario(View view){
        Intent intent = new Intent(this, ConfFuncionarioActivity.class);
        startActivity(intent);
    }
}
