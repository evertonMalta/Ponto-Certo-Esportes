package br.com.pontocertosportes.pontocertoesportes.Banco;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.NoCopySpan;

public class CreateBanco extends SQLiteOpenHelper{
    private static final String NOME_BANCO = "banco.db";
    private static final int VERSAO = 1;
    private String query;
    private String tabela;


    public  CreateBanco(Context context, String tabela, String query){
        super(context, NOME_BANCO, null,VERSAO);
        this.tabela = tabela;
        this.query = query;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ this.tabela);
        onCreate(db);
    }



    public void setQuery(String query) {
        this.query = query;
    }
}
