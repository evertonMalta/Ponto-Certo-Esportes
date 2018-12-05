package br.com.pontocertosportes.pontocertoesportes.Model;


import java.io.Serializable;


public class Fornecedores extends Endereco{


public class Fornecedores implements Serializable {
    private int id;
    private String name;
    private String cnpj;
    private String dtaInauguracao;
    private String email;
    private String telefone;
    private String rua;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;



    public Fornecedores() {
    }



    public Fornecedores( int id, String name, String cnpj, String dtaInauguracao, String email, String telefone, String rua, String numero, String cep, String bairro, String cidade, String estado) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.dtaInauguracao = dtaInauguracao;
        this.email = email;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDtaInauguracao() {
        return dtaInauguracao;
    }

    public void setDtaInauguracao(String dtaInauguracao) {
        this.dtaInauguracao = dtaInauguracao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public boolean equals(Object o) { return this.id == ((Fornecedores)o).id;}

    public int hashCode(){ return this.id;}


}
