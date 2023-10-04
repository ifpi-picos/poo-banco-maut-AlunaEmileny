import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;
public class Conta {
    private String agencia, numero;
    private double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;
    
    public Conta(String agencia, String numero, double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
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

    public void depositar(double valor){
        if (valor > 0){ 
        this.setSaldo((getSaldo()+valor));
    }
    else{
        System.out.println("Valor inválido");
    }
}
public void sacar(double valor){
    if (valor <= getSaldo()){
        this.setSaldo((getSaldo()-valor));
        }
        else {
            System.out.println("Saldo indisponivel para realizar essa ação");  
    }
}
public void verSaldo(){
    System.out.println("Seu Saldo é: "+getSaldo());
}

public void transferir(String destinatario,String numContaDestino, double valor){
    if (valor <= getSaldo()){
        this.setSaldo((getSaldo() - valor));
    }else {
        System.out.println("Tranferencia interrompida. Verifique o destino. ");
    }
}

public void adicionarTransacao(String tipo, double valor, Date data){
    Transacao novaTransacao = new Transacao(tipo, valor, data);
    transacoes.add(novaTransacao);
}
 public void verExtrato(){
    for(Transacao novaTransacao : transacoes){
        System.out.println(novaTransacao.toString());
    }
    verSaldo();
 }
}