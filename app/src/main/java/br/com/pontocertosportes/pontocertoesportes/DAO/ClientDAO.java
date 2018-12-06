package br.com.pontocertosportes.pontocertoesportes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Activity.ViewClientActivity;
import br.com.pontocertosportes.pontocertoesportes.Banco.DbGateway;
import br.com.pontocertosportes.pontocertoesportes.Model.Clients;

import android.widget.Toast;

import br.com.pontocertosportes.pontocertoesportes.Banco.CreateBanco;
import br.com.pontocertosportes.pontocertoesportes.Model.Clients;



public class ClientDAO {
    private final static String TABELA = "Cliente";
    private CreateBanco banco;
    private SQLiteDatabase db;
    private String queryCriarTabela= "CREATE TABLE "+TABELA + "(" +
            "idCliente integer NOT NULL primary key autoincrement," +
            "nome TEXT NOT NULL," +
            "cpf TEXT NOT NULL,rg TEXT NOT NULL," +
            "aniversario TEXT NOT NULL," +
            "email TEXT NOT NULL," +
            "telefone TEXT NOT NULL," +
            "rua TEXT NOT NULL," +
            "numero TEXT NOT NULL," +
            "cep TEXT NOT NULL," +
            "bairro TEXT NOT NULL," +
            "cidade TEXT NOT NULL," +
            "estado TEXT NOT NULL)";

  

    public void InsertClient(Clients cliente){
        String queryInsert ="INSERT INTO "+this.TABELA+" (nome,cpf, aniversario, telefone, rua, numero, cep, bairro, cidade,estado) VALUES ( "+
                cliente.getName() +","+
                cliente.getCpf() +","+
                cliente.getAniversario()+","+
                cliente.getTelefone() +","+
                cliente.getRua() +","+
                cliente.getNumero() +","+
                cliente.getCep() +","+
                cliente.getBairro() +","+
                cliente.getCidade() +","+
                cliente.getEstado() +")";


            db = banco.getWritableDatabase();
            db.q(queryInsert);
            db.close();





    }


   private final String TABLE_CLIENTES = "Clientes";
   private DbGateway gw;

   public ClientDAO(Context ctx){
      gw = DbGateway.getInstance(ctx);
   }

   public List<Clients> retornarTodos(){
      List<Clients> clientes = new ArrayList<>();
      Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Clientes", null);
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

         clientes.add(new Clients(id, nome,Cpf,Rg,Aniversario,Telefone,Email,Rua,numero,bairro,cep,cidade,estado ));
      }
      cursor.close();
      return clientes;
   }

   public Clients retornarUltimo(){
      Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Clientes ORDER BY ID DESC", null);
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
         return new Clients(id, nome,Cpf,Rg,Aniversario,Telefone,Email,Rua,numero,bairro,cep,cidade,estado );
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
         return gw.getDatabase().update(TABLE_CLIENTES, cv, "ID=?", new String[]{ id + "" }) > 0;
      else
         return gw.getDatabase().insert(TABLE_CLIENTES, null, cv) > 0;
   }

   public boolean excluir(int id){
      return gw.getDatabase().delete(TABLE_CLIENTES, "ID=?", new String[]{ id + "" }) > 0;
   }
   public Clients selecionar(int id){
      Clients clients = new Clients();
      SQLiteDatabase db = gw.getDatabase();

      Cursor cursor = db.query(TABLE_CLIENTES, new String[]{"ID", "Nome", "Cpf", "Rg", "Aniversario", "Telefone", "Email", "Rua","Numero", "Bairro", "Cep", "Cidade", "Estado"}, "ID=?", new String[]{String.valueOf(id)}, null, null, null, null);

      if(cursor != null){
         cursor.moveToFirst();
         if (cursor.getCount() > 0){
            clients.setId(cursor.getInt(0));
            clients.setName(cursor.getString(1));
            clients.setCpf(cursor.getString(2));
            clients.setRg(cursor.getString(3));
            clients.setAniversario(cursor.getString(4));
            clients.setTelefone(cursor.getString(5));
            clients.setEmail(cursor.getString(6));
            clients.setRua(cursor.getString(7));
            clients.setNumero(cursor.getString(8));
            clients.setBairro(cursor.getString(9));
            clients.setCep(cursor.getString(10));
            clients.setCidade(cursor.getString(11));
            clients.setEstado(cursor.getString(12));
         }else{
            return null;
         }
      }
      db.close();
      return clients;
   }
}
