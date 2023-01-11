package sistemabanco.cliente;

import sistemabanco.enumeration.TipoCliente;

public class ClienteFisico extends Cliente {
    private String cpf;
    private String telefone;

    public ClienteFisico(String nome, String email, String cpf, String telefone) {
        super(nome, email, TipoCliente.PessoaFisica);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Cliente: \n");
        mensagem.append(String.format("Nome - %s\n", nome));
        mensagem.append(String.format("Cpf - %s\n", cpf));
        mensagem.append(String.format("Email - %s\n", email));
        mensagem.append(String.format("Telefone - %s\n", telefone));

        return mensagem.toString();
    }

}
