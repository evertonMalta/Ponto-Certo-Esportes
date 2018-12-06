package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.pontocertosportes.pontocertoesportes.R;

public class HomeActivity extends AppCompatActivity {

    TextView nameUserTextView;
    ImageView imageUserImageView;

    int[] imagensIds = {
            R.drawable.btn_clientes,
            R.drawable.btn_estoque,
            R.drawable.btn_funcionarios
    };

    int i = imagensIds.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String nameUsuario = "user";
        nameUserTextView = (TextView) findViewById(R.id.nameUser);
        nameUserTextView.setText(nameUsuario);
        imageUserImageView = findViewById(R.id.imageUser);
        //imageUserImageView.setImageResource(imagensIds[i]);
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, LoginActivity.class)); //O efeito ao ser
        // pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    //functions open activity`s
    public void selectIconUser(View view){
        Intent intent = new Intent(this, SelectIconUser.class);
        startActivity(intent);
    }

    public void openCliente(View view){
        Intent intent = new Intent(this, ListClientsActivity.class);
        startActivity(intent);
    }


    public void openFornecedores(View view){
        Intent intent = new Intent(HomeActivity.this, list_fornecedores.class);
        startActivity(intent);
    }

    public void openFuncionario(View view){
        Intent intent = new Intent(HomeActivity.this, ListFuncionariosActivity.class);
        startActivity(intent);
    }

    public void openRealizarVenda(View view){
        Intent intent = new Intent(this, realizarVendas.class);
        startActivity(intent);
    }

    public void openProduto(View view){
        Intent intent = new Intent(this, ListProductActivity.class);
        startActivity(intent);

    }
    public void encerrarSessao(View view){
        finish();
    }
}
