package br.com.pontocertosportes.pontocertoesportes.Model;

public class Clients {
    private String name;
    private String cpf;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clients(String name, String cpf, int id) {
        this.name = name;
        this.cpf = cpf;
        this.id = id;
    }
}
