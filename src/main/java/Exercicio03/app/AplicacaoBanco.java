package Exercicio03.app;

import Exercicio03.model.Conta;
import Exercicio03.service.GerenciadorDeContas;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AplicacaoBanco {

    public static void main(String[] args) throws InterruptedException {
        GerenciadorDeContas banco = new GerenciadorDeContas();

        for (int i = 1; i <= 10; i++) {
            banco.cadastrarConta(new Conta(i, 1000));
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable tarefaTransferencia = () -> {
            Random rand = new Random();
            for (int i = 0; i < 1000; i++) {
                int origem = rand.nextInt(10) + 1;
                int destino;
                do {
                    destino = rand.nextInt(10) + 1;
                } while (destino == origem);

                double valor = rand.nextInt(100) + 1; // entre 1 e 100

                banco.transferir(origem, destino, valor);
            }
        };


        for (int i = 0; i < 10; i++) {
            executor.submit(tarefaTransferencia);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        for (int i = 1; i <= 10; i++) {
            Conta c = banco.obterConta(i);
            System.out.printf("Conta %d: R$%.2f%n", i, c.consultarSaldo());
        }


        double total = banco.saldoTotal();
        System.out.printf("Saldo total do banco: R$%.2f%n", total);

        if (Math.abs(total - 10000) < 0.01) {
            System.out.println("Consistência mantida: saldo total correto!");
        } else {
            System.out.println("Erro: saldo total inconsistente!");
        }
    }
}

