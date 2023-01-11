package sistemabanco.cliente;

import sistemabanco.enumeration.TipoCliente;

public abstract class Cliente {
    protected String nome;
    protected String email;
    protected TipoCliente tipoCliente;

    public Cliente(String nome, String email, TipoCliente tipoCliente) {
        this.nome = nome;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

}
