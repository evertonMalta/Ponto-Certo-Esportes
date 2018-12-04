package br.com.pontocertosportes.pontocertoesportes.DAO;

public class ClientDAO {

    String query = "CREATE TABLE IF NOT EXISTS `pontoCertoDB`.`Cliente` (" +
            "`idCliente` INT NOT NULL AUTO_INCREMENT," +
            "`nome` TEXT NOT NULL," +
            "`cpf` TEXT NOT NULL,`rg` TEXT NOT NULL," +
            "`aniversario` TEXT NOT NULL,`email` TEXT NOT NULL," +
            "`telefone` TEXT NOT NULL," +
            "`rua` TEXT NOT NULL,`numero` TEXT NOT NULL," +
            "`cep` TEXT NOT NULL," +
            "`bairro` TEXT NOT NULL," +
            "`cidade` TEXT NOT NULL," +
            "`estado` TEXT NOT NULL," +
            "PRIMARY KEY (`idCliente`))";
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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

    public ClientDAO(Context context){
        banco = new CreateBanco(context, TABELA,queryCriarTabela );
    }

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


}
