package br.com.pontocertosportes.pontocertoesportes.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    private String categoria;
    private String name;
    private int ID;
    private String dataCompra;
    private int tamanho;
    private double preco;
    private int quantidade;
    private String descricao;

    public String getDataCompra() {return dataCompra;}

    public void setDataCompra(String dataCompra) {this.dataCompra = dataCompra;}

    public int getTamanho() {return tamanho;}

    public void setTamanho(int tamanho) {this.tamanho = tamanho; }

    public double getPreco() {return preco; }

    public void setPreco(double preco) {this.preco = preco;}

    public int getQuantidade() {return quantidade;}

    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getID() {return ID;}

    public void setID(int ID) {this.ID = ID;}

    public String getCategoria() {return categoria;}

    public void setCategoria(String categoria) {this.categoria = categoria;}


    public Product(){}


    public Product(int ID, String name, String datacompra, String categoria, String descricao,  int tamanho, double preco, int quantidade) {
        this.name = name;
        this.ID = ID;
        this.categoria = categoria;
        this.dataCompra = datacompra;
        this.tamanho = tamanho;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    public boolean equals(Object o) { return this.ID == ((Product)o).ID;}

    public int hashCode(){ return this.ID;}


}

