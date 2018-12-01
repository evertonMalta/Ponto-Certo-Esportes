package br.com.pontocertosportes.pontocertoesportes.Model;

public class Clients extends Endereco{
    private int id;
    private String name;
    private String cpf;
    private String rg;
    private String aniversario;
    private String email;
    private String telefone;

    Endereco endereco = new Endereco();

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
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

    public Clients(String name, String cpf, int id, String rg, String aniversario, String email, String telefone, String rua, String numero, String cep, String bairro, String cidade, String estado) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.aniversario = aniversario;
        this.email = email;
        this.telefone = telefone;
        this.endereco.setRua(rua);
        this.endereco.setNumero(numero);
        this.endereco.setCep(cep);
        this.endereco.setBairro(bairro);
        this.endereco.setCidade(cidade);
        this.endereco.setEstado(estado);
    }
}
