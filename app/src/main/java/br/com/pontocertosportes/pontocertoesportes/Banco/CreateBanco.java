package br.com.pontocertosportes.pontocertoesportes.Banco;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateBanco extends SQLiteOpenHelper{
    private static final String NOME_BANCO = "banco.db";
    private static final int VERSAO = 1;

    public  CreateBanco(Context context){
        super(context, NOME_BANCO, null,VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
