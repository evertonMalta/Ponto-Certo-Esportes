package br.com.pontocertosportes.pontocertoesportes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText user;
    EditText password;
    TextView nameUserTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = (EditText) findViewById(R.id.textUsuario);
        password = (EditText) findViewById(R.id.textSenha);
        nameUserTextView = (TextView) findViewById(R.id.nameUser);
    }

    public void login(View view){
        if(user.getText().toString().equals("user") && password.getText().toString().equals("password")){
            Intent openHomeActivity = new Intent(this, HomeActivity.class);
            startActivity(openHomeActivity);
            //nameUserTextView.setText(nameUsuario);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(),"Usuário ou senha incorretos",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }
 }

/*
    tenho 0.0028 bit coins
    trei 0.332 bit coins*?
*/

/*
<EditText
    android:layout_width="wrap_content"
    android:layout_height="match_parent"
    android:ems="9"
    android:fontFamily="@font/allerstd"
    android:hint="Usuário"
    android:inputType="textEmailAddress"
    android:maxLines="1"
    android:minLines="1"
    android:textColor="@android:color/white"
    android:textColorHint="@android:color/darker_gray"
    android:textSize="16dp"
    tools:layout_editor_absoluteX="77dp"
    tools:layout_editor_absoluteY="118dp" />

     */