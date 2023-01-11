package sistemabanco.cliente;

import sistemabanco.enumeration.TipoCliente;

public class ClienteJuridico extends Cliente {
    private String cnpj;
    private String razaoSocial;

    public ClienteJuridico(String nome, String email, String cnpj, String razaoSocial) {
        super(nome, email, TipoCliente.PessoaJuridica);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String toString() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Cliente Jurídico: \n");
        mensagem.append(String.format("Nome - %s\n", nome));
        mensagem.append(String.format("Cnpj - %s\n", cnpj));
        mensagem.append(String.format("Email - %s\n", email));
        mensagem.append(String.format("Razão Social - %s\n", razaoSocial));

        return mensagem.toString();
    }

}
