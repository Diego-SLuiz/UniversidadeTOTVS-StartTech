package sistemabanco.conta;

import sistemabanco.cliente.Cliente;
import sistemabanco.enumeration.TipoConta;

public class ContaCorrente extends Conta {
    private static final Double limiteChequeEspecial = 0.10;
    private Double chequeEspecial;

    public ContaCorrente(Cliente cliente) {
        super(TipoConta.ContaCorrente, cliente);
        chequeEspecial = 0.0;
    }

    @Override
    public void depositar(Double valor) {
        super.depositar(valor);
        calcularChequeEspecial();
    }

    private void calcularChequeEspecial() {
        chequeEspecial = ContaCorrente.limiteChequeEspecial * saldoDisponivel;
    }

    public Double getChequeEspeciall() {
        return chequeEspecial;
    }

    @Override
    public String toString() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Conta Corrente: \n");
        mensagem.append(String.format("Saldo Disponível - %s\n", saldoDisponivel));
        mensagem.append(String.format("Cheque Especial - %s\n", chequeEspecial));
        mensagem.append("\n");
        mensagem.append(cliente);

        return mensagem.toString();
    }

}
