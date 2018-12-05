package br.com.pontocertosportes.pontocertoesportes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Banco.CreateBanco;
import br.com.pontocertosportes.pontocertoesportes.Model.Product;

import static android.content.ContentValues.TAG;

public class ProdutoDAO {

    private CreateBanco banco;


    private SQLiteDatabase db;


    public ProdutoDAO(Context context){
        banco = new CreateBanco(context);
    }



}