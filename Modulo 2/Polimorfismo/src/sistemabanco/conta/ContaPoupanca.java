package sistemabanco.conta;

import sistemabanco.cliente.Cliente;
import sistemabanco.enumeration.TipoConta;

public class ContaPoupanca extends Conta {
    private static final Double rendimentoMensal = 0.05;
    private double taxaRendimento;

    public ContaPoupanca(Cliente cliente) {
        super(TipoConta.ContaPoupanca, cliente);
        taxaRendimento = 0.0;
    }

    @Override
    public void depositar(Double valor) {
        super.depositar(valor);
        calcularRendimento();
    }

    private void calcularRendimento() {
        taxaRendimento = ContaPoupanca.rendimentoMensal * saldoDisponivel;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    @Override
    public String toString() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Conta Poupança: \n");
        mensagem.append(String.format("Saldo Disponível - %s\n", saldoDisponivel));
        mensagem.append(String.format("Taxa Rendidmento - %s\n", taxaRendimento));
        mensagem.append("\n");
        mensagem.append(cliente);

        return mensagem.toString();
    }

}
