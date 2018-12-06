package br.com.pontocertosportes.pontocertoesportes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Banco.DbGateway;
import br.com.pontocertosportes.pontocertoesportes.Model.Product;

public class ProdutoDAO {

    private final String TABLE_PRODUTOS = "Produtos";
    private DbGateway gw;

    public ProdutoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public List<Product> retornarTodos(){
        List<Product> products = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Produtos", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String dtaCompra = cursor.getString(cursor.getColumnIndex("DtaCompra"));
            String categoria = cursor.getString(cursor.getColumnIndex("Categoria"));
            String descricao = cursor.getString(cursor.getColumnIndex("Descricao"));
            int tamanho = cursor.getInt(cursor.getColumnIndex("Tamanho"));
            float preco = cursor.getFloat(cursor.getColumnIndex("Preco"));
            int quantidade = cursor.getInt(cursor.getColumnIndex("Quantidade"));

            products.add(new Product(id,nome,dtaCompra,categoria,descricao,tamanho,preco,quantidade));
        }
        cursor.close();
        return products;
    }

    public Product retornarUltimo(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Produtos ORDER BY ID DESC", null);
        if(cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String dtaCompra = cursor.getString(cursor.getColumnIndex("DtaCompra"));
            String categoria = cursor.getString(cursor.getColumnIndex("Categoria"));
            String descricao = cursor.getString(cursor.getColumnIndex("Descricao"));
            int tamanho = cursor.getInt(cursor.getColumnIndex("Tamanho"));
            int quantidade = cursor.getInt(cursor.getColumnIndex("Quantidade"));
            float preco = cursor.getFloat(cursor.getColumnIndex("Preco"));
            cursor.close();
            return new Product(id,nome,dtaCompra,categoria,descricao,tamanho,preco,quantidade);
        }

        return null;
    }



    public boolean salvar(String nome, String dtaCompra, String categoria, String descricao, int Tamanho, int Quantidade, float Preco){
        return salvar(0, nome, dtaCompra, categoria, descricao, Tamanho, Quantidade, Preco);
    }

    public boolean salvar(int id, String nome, String dtaCompra, String categoria, String descricao, int Tamanho, int Quantidade, float Preco){
        ContentValues cv = new ContentValues();
        cv.put("Nome", nome);
        cv.put("DtaCompra", dtaCompra);
        cv.put("Categoria", categoria);
        cv.put("Descricao", descricao);
        cv.put("Tamanho", Tamanho);
        cv.put("Quantidade", Quantidade);
        cv.put("Preco",Preco);

        if(id > 0)
            return gw.getDatabase().update(TABLE_PRODUTOS, cv, "ID=?", new String[]{ id + "" }) > 0;
        else
            return gw.getDatabase().insert(TABLE_PRODUTOS, null, cv) > 0;
    }

    public boolean excluir(int id){
        return gw.getDatabase().delete(TABLE_PRODUTOS, "ID=?", new String[]{ id + "" }) > 0;
    }

    public Product selecionar(int id){
        Product product = new Product();
        SQLiteDatabase db = gw.getDatabase();

        Cursor cursor = db.query(TABLE_PRODUTOS, new String[]{"ID", "Nome", "DtaCompra", "Categoria", "Descricao", "Tamanho", "Quantidade", "Preco"}, "ID=?", new String[]{String.valueOf(id)}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
            if (cursor.getCount() > 0){
                product.setID(cursor.getInt(0));
                product.setName(cursor.getString(1));
                product.setDataCompra(cursor.getString(2));
                product.setCategoria(cursor.getString(3));
                product.setDescricao(cursor.getString(4));
                product.setTamanho(cursor.getInt(5));
                product.setQuantidade(cursor.getInt(6));
                product.setPreco(cursor.getDouble(7));
            }else{
                return null;
            }
        }
        db.close();
        return product;
    }
}