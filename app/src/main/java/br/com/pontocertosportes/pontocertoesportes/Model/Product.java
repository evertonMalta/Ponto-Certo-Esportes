package br.com.pontocertosportes.pontocertoesportes.Model;

public class Product {
    private String categoria;
    private String name;
    private String ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }



    public Product(String name, String ID, String categoria) {
        this.name = name;
        this.ID = ID;
        this.categoria = categoria;
    }



}
