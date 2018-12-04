package br.com.pontocertosportes.pontocertoesportes.Model;

public class Funcionarios extends Endereco{

    private int id;
    private String name;
    private String cpf;
    private String rg;
    private String aniversario;
    private String email;
    private String telefone;

    Endereco endereco = new Endereco();

    public Funcionarios( int id, String name, String cpf, String rg, String aniversario, String email, String telefone, String rua, String numero, String cep, String bairro, String cidade, String estado) {
        super(rua, numero, cep, bairro, cidade, estado);
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.aniversario = aniversario;
        this.email = email;
        this.telefone = telefone;
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




}
