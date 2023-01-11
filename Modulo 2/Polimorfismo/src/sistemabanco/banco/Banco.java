package sistemabanco.banco;

import utilidades.Leitor;
import sistemabanco.conta.Conta;
import sistemabanco.conta.ContaCorrente;
import sistemabanco.conta.ContaPoupanca;
import sistemabanco.cliente.Cliente;
import sistemabanco.cliente.ClienteFisico;
import sistemabanco.cliente.ClienteJuridico;

public class Banco {
    public Cliente cadastrarCliente() {
        System.out.println();
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.println();

        String mensagem;
        String aviso;

        mensagem = "Digite o tipo de cliente desejado: ";
        aviso = "Número informado inválido";
        Integer tipoClienteInformado = Leitor.lerInteiro(1, 2, mensagem, aviso);

        mensagem = "Digite o nome do cliente: ";
        String nome = Leitor.lerTexto(mensagem);

        mensagem = "Digite o email do cliente: ";
        String email = Leitor.lerTexto(mensagem);

        Cliente cliente;

        if (tipoClienteInformado == 1) {
            mensagem = "Digite o cpf do cliente: ";
            String cpf = Leitor.lerTexto(mensagem);

            mensagem = "Digite o telefone do cliente: ";
            String telefone = Leitor.lerTexto(mensagem);

            cliente = new ClienteFisico(nome, email, cpf, telefone);
        } else {
            mensagem = "Digite o cnpj do cliente: ";
            String cnpj = Leitor.lerTexto(mensagem);

            mensagem = "Digite a razão social do cliente: ";
            String razaoSocial = Leitor.lerTexto(mensagem);

            cliente = new ClienteJuridico(nome, email, cnpj, razaoSocial);
        }

        return cliente;
    }

    public Conta criarConta(Cliente cliente) {
        System.out.println();
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.println();

        String mensagem;
        String aviso;

        mensagem = "Digite o tipo de conta desejada: ";
        aviso = "Número informado inválido";
        Integer tipoContaInformada = Leitor.lerInteiro(1, 2, mensagem, aviso);

        mensagem = "Digite o valor de depósito inicial: ";
        aviso = "Valor de depósito inicial inválido";
        Double depositoInicial = Leitor.lerDecimal(0.01,  10_000.0, mensagem, aviso);

        Conta conta;

        if (tipoContaInformada == 1) {
            conta = new ContaCorrente(cliente);
        } else {
            conta = new ContaPoupanca(cliente);
        }

        conta.depositar(depositoInicial);
        return conta;
    }

}
