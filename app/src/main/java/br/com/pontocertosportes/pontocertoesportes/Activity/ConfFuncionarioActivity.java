package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import br.com.pontocertosportes.pontocertoesportes.Adapter.FuncionarioAdapter;
import br.com.pontocertosportes.pontocertoesportes.DAO.FuncionarioDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Funcionarios;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ConfFuncionarioActivity extends AppCompatActivity {


    EditText nomeFuncionario;
    EditText rgFuncionario;
    EditText cpfFuncionario;
    EditText aniversarioFuncionario;
    EditText emailFuncionario;
    EditText telefoneFuncionario;
    EditText ruaFuncionario;
    EditText numeroFuncionario;
    EditText cepFuncionario;
    EditText bairroFuncionario;
    EditText cidadeFuncionario;
    EditText estadoFuncionario;

    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_funcionario);

        //declarando as EditTexts

        nomeFuncionario = (EditText) findViewById(R.id.EditTextNomeFuncionario);
        rgFuncionario = (EditText) findViewById(R.id.EditTextRgFuncionario);
        cpfFuncionario = (EditText) findViewById(R.id.EditTextCPFFuncionario);
        aniversarioFuncionario = (EditText) findViewById(R.id.EditTextAniversarioFuncionario);
        emailFuncionario = (EditText) findViewById(R.id.EditTextEmailFuncionario);
        telefoneFuncionario = (EditText) findViewById(R.id.EditTextTelefoneFuncionario);
        ruaFuncionario = (EditText) findViewById(R.id.EditTextRuaFuncionario);
        numeroFuncionario = (EditText) findViewById(R.id.EditTextNumeroFuncionario);
        cepFuncionario = (EditText) findViewById(R.id.EditTextCEPFuncionario);
        bairroFuncionario = (EditText) findViewById(R.id.EditTextBairroFuncionario);
        cidadeFuncionario = (EditText) findViewById(R.id.EditTextCidadeFuncionario);
        estadoFuncionario = (EditText) findViewById(R.id.EditTextEstadoFuncionario);

        Intent intent = getIntent();
        if (intent.hasExtra("Funcionario")) {
            funcionarioEditado = (Funcionarios) intent.getSerializableExtra("Funcionario");
            nomeFuncionario.setText(funcionarioEditado.getName());
            aniversarioFuncionario.setText(funcionarioEditado.getAniversario());
            rgFuncionario.setText(funcionarioEditado.getRg());
            cpfFuncionario.setText(funcionarioEditado.getCpf());
            emailFuncionario.setText(funcionarioEditado.getEmail());
            telefoneFuncionario.setText(funcionarioEditado.getTelefone());
            ruaFuncionario.setText(funcionarioEditado.getRua());
            numeroFuncionario.setText(funcionarioEditado.getNumero());
            cepFuncionario.setText(funcionarioEditado.getCep());
            bairroFuncionario.setText(funcionarioEditado.getBairro());
            cidadeFuncionario.setText(funcionarioEditado.getCidade());
            estadoFuncionario.setText(funcionarioEditado.getEstado());
        }
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

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, HomeActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    public void salvar(View view){
        //Pegando os valores
        String Nome = nomeFuncionario.getText().toString();
        String Rg = rgFuncionario.getText().toString();
        String Cpf = cpfFuncionario.getText().toString();
        String Aniversario = aniversarioFuncionario.getText().toString();
        String Email = emailFuncionario.getText().toString();
        String Telefone = telefoneFuncionario.getText().toString();
        String Rua = ruaFuncionario.getText().toString();
        String Numero = numeroFuncionario.getText().toString();
        String Cep = cepFuncionario.getText().toString();
        String Bairro = bairroFuncionario.getText().toString();
        String Cidade = cidadeFuncionario.getText().toString();
        String Estado = estadoFuncionario.getText().toString();

        //Salvando os dados
        FuncionarioDAO dao = new FuncionarioDAO(getBaseContext());
        FuncionarioDAO ClientDao = new FuncionarioDAO(this);
        FuncionarioAdapter adapter = new FuncionarioAdapter(ClientDao.retornarTodos());

        boolean sucesso;
        if (funcionarioEditado != null)
            sucesso = dao.salvar(funcionarioEditado.getId(),Nome,Cpf,Rg,Aniversario,Telefone,Email,Rua,Numero,Bairro,Cep,Cidade,Estado);
        else
            sucesso = dao.salvar(Nome,Cpf,Rg,Aniversario,Telefone,Email                                        ,Rua,Numero,Bairro,Cep,Cidade,Estado);

        if (sucesso){
            Funcionarios funcionarios = dao.retornarUltimo();
            if (funcionarioEditado != null) {
                adapter.atualizarFuncionario(funcionarios);
                funcionarioEditado = null;
            }else
                adapter.adicionarFuncionario(funcionarios);

            //limpa os campos
            nomeFuncionario.setText("");
            rgFuncionario.setText("");
            cpfFuncionario.setText("");
            aniversarioFuncionario.setText("");
            emailFuncionario.setText("");
            telefoneFuncionario.setText("");
            ruaFuncionario.setText("");
            numeroFuncionario.setText("");
            cepFuncionario.setText("");
            bairroFuncionario.setText("");
            cidadeFuncionario.setText("");
            estadoFuncionario.setText("");

            Snackbar.make(view, "Salvou!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            startActivity(new Intent(this, ListFuncionariosActivity.class));
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
