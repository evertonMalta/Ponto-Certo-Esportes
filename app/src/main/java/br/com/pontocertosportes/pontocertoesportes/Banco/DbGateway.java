package br.com.pontocertosportes.pontocertoesportes.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbGateway {
    private static DbGateway gw;
    private SQLiteDatabase db;

    private DbGateway(Context ctx){
        CreateBanco helper = new CreateBanco(ctx);
        db = helper.getWritableDatabase();
    }

    public static DbGateway getInstance(Context ctx){
        if(gw == null)
            gw = new DbGateway(ctx);
        return gw;
    }

    public SQLiteDatabase getDatabase(){
        return this.db;
    }
}
