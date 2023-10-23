import java.time.LocalDate;

import Notificacao.Email;
import Notificacao.Sms;
import Notificacao.Notificacao;

public class Main {
    public static void main(String[] args) {
        Cliente.Endereco endereco = new Cliente.Endereco("lino", "xique-Xique", "santo antonio", 000);
        Cliente cliente = new Cliente("emileny", "000.111.222-33", endereco, LocalDate.now());
        Notificacao msmEmail = new Email() ;
        Notificacao msmSms = new Sms();
        Conta conta = new Conta("000-1", "0102030-9", 0, cliente, msmEmail);

        // Teste da conta Corrente
            
        Conta contaCorrente = new ContaCorrente("000-1", "0102030-9", 0, cliente, 1000, msmEmail);
        contaCorrente.depositar(190); 
        contaCorrente.sacar(200);
        contaCorrente.transferir(90, conta);
        contaCorrente.transferir(30, conta);
        contaCorrente.transferir(60, conta);

        // Teste da conta Poupança
        Conta contaPoupanca = new ContaPoupanca("000-1", "010203-9", 0, cliente,0, msmSms);
        contaPoupanca.depositar(100);
        contaPoupanca.transferir(50, conta);
        contaPoupanca.sacar(10);

        };
}
