package br.com.pontocertosportes.pontocertoesportes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Banco.DbGateway;
import br.com.pontocertosportes.pontocertoesportes.Model.Funcionarios;

public class FuncionarioDAO {

    private final String TABLE_FUNCIONARIOS = "Funcionario";
    private DbGateway gw;

    public FuncionarioDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public List<Funcionarios> retornarTodos(){
        List<Funcionarios> funcionarios = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Funcionario", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String Cpf = cursor.getString(cursor.getColumnIndex("Cpf"));
            String Rg = cursor.getString(cursor.getColumnIndex("Rg"));
            String Aniversario = cursor.getString(cursor.getColumnIndex("Aniversario"));
            String Telefone = cursor.getString(cursor.getColumnIndex("Telefone"));
            String Email = cursor.getString(cursor.getColumnIndex("Email"));
            String Rua = cursor.getString(cursor.getColumnIndex("Rua"));
            String numero = cursor.getString(cursor.getColumnIndex("Numero"));
            String bairro = cursor.getString(cursor.getColumnIndex("Bairro"));
            String cep = cursor.getString(cursor.getColumnIndex("Cep"));
            String cidade = cursor.getString(cursor.getColumnIndex("Cidade"));
            String estado = cursor.getString(cursor.getColumnIndex("Estado"));

            funcionarios.add(new Funcionarios(id, nome,Cpf,Rg,Aniversario,Telefone,Email,Rua,numero,bairro,cep,cidade,estado ));
        }
        cursor.close();
        return funcionarios;
    }

    public Funcionarios retornarUltimo(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Funcionario ORDER BY ID DESC", null);
        if(cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String Cpf = cursor.getString(cursor.getColumnIndex("Cpf"));
            String Rg = cursor.getString(cursor.getColumnIndex("Rg"));
            String Aniversario = cursor.getString(cursor.getColumnIndex("Aniversario"));
            String Telefone = cursor.getString(cursor.getColumnIndex("Telefone"));
            String Email = cursor.getString(cursor.getColumnIndex("Email"));
            String Rua = cursor.getString(cursor.getColumnIndex("Rua"));
            String numero = cursor.getString(cursor.getColumnIndex("Numero"));
            String bairro = cursor.getString(cursor.getColumnIndex("Bairro"));
            String cep = cursor.getString(cursor.getColumnIndex("Cep"));
            String cidade = cursor.getString(cursor.getColumnIndex("Cidade"));
            String estado = cursor.getString(cursor.getColumnIndex("Estado"));
            cursor.close();
            return new Funcionarios(id, nome,Cpf,Rg,Aniversario,Telefone,Email,Rua,numero,bairro,cep,cidade,estado );
        }

        return null;
    }



    public boolean salvar(String nome, String Cpf, String Rg, String Aniversario, String Telefone, String Email,String Rua, String numero, String bairro,String cep, String cidade,String estado){
        return salvar(0, nome,Cpf,Rg,Aniversario,Telefone,Email,Rua,numero,bairro,cep,cidade,estado);
    }

    public boolean salvar(int id, String nome, String cpf, String rg, String aniversario, String telefone, String email,String rua, String numero, String bairro, String cep,String cidade,String estado){
        ContentValues cv = new ContentValues();
        cv.put("Nome", nome);
        cv.put("Cpf", cpf);
        cv.put("Rg", rg);
        cv.put("Aniversario", aniversario);
        cv.put("Telefone", telefone);
        cv.put("Email", email);
        cv.put("Rua",rua);
        cv.put("Numero", numero);
        cv.put("Bairro", bairro);
        cv.put("Cep", cep);
        cv.put("Cidade",cidade);
        cv.put("Estado", estado);

        if(id > 0)
            return gw.getDatabase().update(TABLE_FUNCIONARIOS, cv, "ID=?", new String[]{ id + "" }) > 0;
        else
            return gw.getDatabase().insert(TABLE_FUNCIONARIOS, null, cv) > 0;
    }

    public boolean excluir(int id){
        return gw.getDatabase().delete(TABLE_FUNCIONARIOS, "ID=?", new String[]{ id + "" }) > 0;
    }
}
