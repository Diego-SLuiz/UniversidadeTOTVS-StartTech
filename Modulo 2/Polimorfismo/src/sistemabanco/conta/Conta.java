package sistemabanco.conta;

import sistemabanco.cliente.Cliente;
import sistemabanco.enumeration.TipoConta;

import java.util.Random;

public abstract class Conta {
    protected Integer numeroConta;
    protected Double saldoDisponivel;
    protected TipoConta tipoConta;
    protected Cliente cliente;

    public Conta(TipoConta tipoConta, Cliente cliente) {
        this.numeroConta = gerarNumeroConta();
        this.saldoDisponivel = 0.0;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
    }

    public void depositar(Double valor) {
        saldoDisponivel += valor;
    }

    private Integer gerarNumeroConta() {
        Random aleatorizador = new Random();
        return aleatorizador.nextInt(1, 1_000_000);
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(Double saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
