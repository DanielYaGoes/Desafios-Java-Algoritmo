package Exercicio03.service;

import Exercicio03.model.Conta;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GerenciadorDeContas implements TransferenciaBancaria {

    private final Map<Integer, Conta> contas = new ConcurrentHashMap<>();


    public void cadastrarConta(Conta conta){
        contas.put(conta.getNumeroConta(),conta);
    }

    public Conta obterConta(int numeroConta){
        return contas.get(numeroConta);
    }

    @Override
    public boolean transferir(int contaOrigemId, int contaDestinoId, double valor) {
        if (contaOrigemId == contaDestinoId) return false;
        if (valor <= 0) return false;


        Conta contaOrigem = contas.get(contaOrigemId);
        Conta contaDestino = contas.get(contaDestinoId);

        if (contaOrigem == null || contaDestino == null) return false;


        Conta primeiraConta = contaOrigemId < contaDestinoId ? contaOrigem : contaDestino;
        Conta segundaConta = contaOrigemId < contaDestinoId ? contaDestino : contaOrigem;

        synchronized (primeiraConta) {
            synchronized (segundaConta) {
                if (contaOrigem.sacar(valor)) {
                    contaDestino.depositar(valor);
                    return true;
                }
                return false;
            }
        }
    }

    public double saldoTotal() {
        double total = 0;
        for (Conta conta : contas.values()) {
            total += conta.consultarSaldo();
        }
        return total;
    }


}

