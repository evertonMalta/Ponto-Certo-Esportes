package br.com.pontocertosportes.pontocertoesportes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Banco.DbGateway;
import br.com.pontocertosportes.pontocertoesportes.Model.Fornecedores;

public class FornecedorDAO {
    private final String TABLE_FORNECEDOR = "Fornecedor";
    private DbGateway gw;

    public FornecedorDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public List<Fornecedores> retornarTodos(){
        List<Fornecedores> fornecedores = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Fornecedor", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String Cnpj = cursor.getString(cursor.getColumnIndex("Cnpj"));

            String DtaInauguracao = cursor.getString(cursor.getColumnIndex("DtaInauguracao"));
            String Telefone = cursor.getString(cursor.getColumnIndex("Telefone"));
            String Email = cursor.getString(cursor.getColumnIndex("Email"));
            String Rua = cursor.getString(cursor.getColumnIndex("Rua"));
            String numero = cursor.getString(cursor.getColumnIndex("Numero"));
            String bairro = cursor.getString(cursor.getColumnIndex("Bairro"));
            String cep = cursor.getString(cursor.getColumnIndex("Cep"));
            String cidade = cursor.getString(cursor.getColumnIndex("Cidade"));
            String estado = cursor.getString(cursor.getColumnIndex("Estado"));

            fornecedores.add(new Fornecedores(id, nome,Cnpj,DtaInauguracao,Telefone,Email,Rua,numero,bairro,cep,cidade,estado ));
        }
        cursor.close();
        return fornecedores;
    }

    public Fornecedores retornarUltimo(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Fornecedor ORDER BY ID DESC", null);
        if(cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String Cnpj = cursor.getString(cursor.getColumnIndex("Cnpj"));
            String DtaInauguracao = cursor.getString(cursor.getColumnIndex("DtaInauguracao"));
            String Telefone = cursor.getString(cursor.getColumnIndex("Telefone"));
            String Email = cursor.getString(cursor.getColumnIndex("Email"));
            String Rua = cursor.getString(cursor.getColumnIndex("Rua"));
            String numero = cursor.getString(cursor.getColumnIndex("Numero"));
            String bairro = cursor.getString(cursor.getColumnIndex("Bairro"));
            String cep = cursor.getString(cursor.getColumnIndex("Cep"));
            String cidade = cursor.getString(cursor.getColumnIndex("Cidade"));
            String estado = cursor.getString(cursor.getColumnIndex("Estado"));
            cursor.close();
            return new Fornecedores(id, nome,Cnpj,DtaInauguracao,Telefone,Email,Rua,numero,bairro,cep,cidade,estado );
        }

        return null;
    }



    public boolean salvar(String nome, String Cnpj, String DtaInauguracao, String Telefone, String Email,String Rua, String numero, String bairro,String cep, String cidade,String estado){
        return salvar(0, nome,Cnpj,DtaInauguracao,Telefone,Email,Rua,numero,bairro,cep,cidade,estado);
    }

    public boolean salvar(int id, String nome, String cnpj, String DtaInauguracao, String telefone, String email,String rua, String numero, String bairro, String cep,String cidade,String estado){
        ContentValues cv = new ContentValues();
        cv.put("Nome", nome);
        cv.put("Cnpj", cnpj);
        cv.put("DtaInauguracao", DtaInauguracao);
        cv.put("Telefone", telefone);
        cv.put("Email", email);
        cv.put("Rua",rua);
        cv.put("Numero", numero);
        cv.put("Bairro", bairro);
        cv.put("Cep", cep);
        cv.put("Cidade",cidade);
        cv.put("Estado", estado);

        if(id > 0)
            return gw.getDatabase().update(TABLE_FORNECEDOR, cv, "ID=?", new String[]{ id + "" }) > 0;
        else
            return gw.getDatabase().insert(TABLE_FORNECEDOR, null, cv) > 0;
    }

    public boolean excluir(int id){
        return gw.getDatabase().delete(TABLE_FORNECEDOR, "ID=?", new String[]{ id + "" }) > 0;
    }
}
