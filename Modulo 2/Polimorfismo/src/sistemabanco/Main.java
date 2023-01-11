package sistemabanco;

import sistemabanco.banco.Banco;
import sistemabanco.cliente.Cliente;
import sistemabanco.conta.Conta;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Cliente cliente = banco.cadastrarCliente();
        Conta conta = banco.criarConta(cliente);

        System.out.println();
        System.out.println(conta);
    }

}
