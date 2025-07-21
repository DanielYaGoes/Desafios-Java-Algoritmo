package Exercicio03.model;

public class Conta {
    private final int numeroConta;
    private double saldo;

    public Conta(int numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public synchronized double consultarSaldo() {
        return saldo;
    }

    public synchronized void depositar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor deve ser positivo.");
        saldo += valor;
    }

    public synchronized boolean sacar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor deve ser positivo.");
        if (valor > saldo) return false;
        saldo -= valor;
        return true;
    }
}