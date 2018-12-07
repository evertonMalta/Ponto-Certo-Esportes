package br.com.pontocertosportes.pontocertoesportes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.pontocertosportes.pontocertoesportes.R;

public class SelectIconUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_icon_user);
    }

    public void choiceConfirm(View view){
        finish();
    }

    public void selectImage(){

        String ata;
    }

    public void cancel(){
        finish();
    }
}
