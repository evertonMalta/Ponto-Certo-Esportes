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


}
