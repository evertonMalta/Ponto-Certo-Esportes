package br.com.pontocertosportes.pontocertoesportes.DAO;

public class FuncionarioDao {

    String querrry = "CREATE TABLE `funcionario` (" +
            "    `id_funcionario` INTEGER," +
            "    `nome` TEXT," +
            "    `RG` TEXT," +
            "    `CPF` TEXT," +
            "    `data_nascimento` TEXT," +
            "    `email` TEXT," +
            "    `telefone` TEXT," +
            "    `end_rua` TEXT," +
            "    `end_numero` TEXT," +
            "    `end_bairro` TEXT," +
            "    `end_cep` TEXT," +
            "    `end_cidade` TEXT," +
            "    `end_estado` TEXT" +
            "    );";

    String query = "CREATE TABLE IF NOT EXISTS `pontoCertoDB`.`Cliente` (" +
            "`idFuncionario INT NOT NULL AUTO_INCREMENT," +
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

   /* String queryy = "CREATE TABLE [IF NOT EXISTS] [pontoCertoDB].funcionario (\n" +
            "    `id_funcionario`\tINTEGER,\n" +
            "    `nome`\tTEXT,\n" +
            "    `RG`\tTEXT,\n" +
            "    `CPF`\tTEXT,\n" +
            "    `data_nascimento`\tTEXT,\n" +
            "    `email`\tTEXT,\n" +
            "    `telefone`\tTEXT,\n" +
            "    `end_rua`\tTEXT,\n" +
            "    `end_numero`\tTEXT,\n" +
            "    `end_bairro`\tTEXT,\n" +
            "    `end_cep`\tTEXT,\n" +
            "    `end_cidade`\tTEXT,\n" +
            "    `end_estado`\tTEXT);*/

/*
    CREATE TABLE `funcionario` (
    `id_funcionario`	INTEGER,
    `nome`	TEXT,
    `RG`	TEXT,
    `CPF`	TEXT,
    `data_nascimento`	TEXT,
    `email`	TEXT,
    `telefone`	TEXT,
    `end_rua`	TEXT,
    `end_numero`	TEXT,
    `end_bairro`	TEXT,
    `end_cep`	TEXT,
    `end_cidade`	TEXT,
    `end_estado`	TEXT
    );
*/