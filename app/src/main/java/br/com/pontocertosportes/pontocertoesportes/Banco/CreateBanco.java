package br.com.pontocertosportes.pontocertoesportes.Banco;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.pontocertosportes.pontocertoesportes.DAO.ProdutoDAO;

public class CreateBanco extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "SISBD";
    private static final int DATABASE_VERSION = 2;
    private final String CREATE_TABLEClient = "CREATE TABLE Clientes " +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            " Nome TEXT NOT NULL," +
            "Cpf TEXT NOT NULL," +
            " Rg TEXT NOT NULL, " +
            "Aniversario TEXT NOT NULL," +
            "Telefone TEXT NOT NULL," +
            "Email TEXT NOT NULL," +
            " Rua TEXT NOT NULL, " +
            " Numero TEXT NOT NULL, " +
            "Bairro TEXT NOT NULL," +
            " Cep TEXT NOT NULL, " +
            "Cidade TEXT NOT NULL," +
            " Estado TEXT NOT NULL);";

    private  final String CREATE_TABLEProduct = "CREATE TABLE Produtos"+
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            " Nome TEXT NOT NULL," +
            " DtaCompra TEXT NOT NULL," +
            " Categoria TEXT NOT NULL," +
            " Descricao TEXT NOT NULL, " +
            "Tamanho TEXT NOT NULL," +
            "Quantidade TEXT NOT NULL," +
            " Preco TEXT NOT NULL);";

    private final String CREATE_TABLEFuncionario = "CREATE TABLE Funcionario " +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            " Nome TEXT NOT NULL," +
            "Cpf TEXT NOT NULL," +
            " Rg TEXT NOT NULL, " +
            "Aniversario TEXT NOT NULL," +
            "Telefone TEXT NOT NULL," +
            "Email TEXT NOT NULL," +
            " Rua TEXT NOT NULL, " +
            " Numero TEXT NOT NULL, " +
            "Bairro TEXT NOT NULL," +
            " Cep TEXT NOT NULL, " +
            "Cidade TEXT NOT NULL," +
            " Estado TEXT NOT NULL);";

    private final String CREATE_TABLEFornecedor = "CREATE TABLE Fornecedor " +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            " Nome TEXT NOT NULL," +
            "Cnpj TEXT NOT NULL," +
            "DtaInauguracao TEXT NOT NULL," +
            "Telefone TEXT NOT NULL," +
            "Email TEXT NOT NULL," +
            " Rua TEXT NOT NULL, " +
            " Numero TEXT NOT NULL, " +
            "Bairro TEXT NOT NULL," +
            " Cep TEXT NOT NULL, " +
            "Cidade TEXT NOT NULL," +
            " Estado TEXT NOT NULL);";



    public CreateBanco(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLEClient);
        db.execSQL(CREATE_TABLEProduct);
        db.execSQL(CREATE_TABLEFuncionario);
        db.execSQL(CREATE_TABLEFornecedor);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
