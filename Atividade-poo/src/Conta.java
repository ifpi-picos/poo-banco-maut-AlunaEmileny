
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Notificacao.Notificacao;

import java.time.LocalDateTime;

public class Conta {
    private String agencia, numero;
    private double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;
    private Notificacao notificacao;

    public Conta(String agencia, String numero, double saldo, Cliente cliente,
            Notificacao notificacao) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
        this.notificacao = notificacao;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.setSaldo((getSaldo() + valor));
            adicionarTransacao("Deposito", valor, LocalDateTime.now());
        } else {
            System.out.println("Valor inválido");
        }
    }

    public void sacar(double valor) {
        if (valor <= getSaldo()) {
            this.setSaldo((getSaldo() - valor));
            adicionarTransacao("Saque", valor, LocalDateTime.now());
        } else {
            System.out.println("Saldo indisponivel para realizar essa ação");
        }
    }

    public void verSaldo() {
        System.out.println("Seu Saldo é: " + getSaldo());
    }

    public void transferir(double valor, Conta destinatario) {
        if (valor <= getSaldo()) {
            this.setSaldo((getSaldo() - valor));
            adicionarTransacao("Transferencia", valor, LocalDateTime.now());
        } else {
            System.out.println("Tranferencia interrompida. Verifique o destino. ");
        }
    }

    public void adicionarTransacao(String tipo, double valor, LocalDateTime data) {
        Transacao novaTransacao = new Transacao(tipo, valor, LocalDateTime.now());
        transacoes.add(novaTransacao);
        notificacao.enviarNotificacao(tipo, valor);
    }

    public void verExtrato() {
        for (Transacao novaTransacao : transacoes) {
            System.out.println(novaTransacao.toString());
        }
        verSaldo();
    }
}
