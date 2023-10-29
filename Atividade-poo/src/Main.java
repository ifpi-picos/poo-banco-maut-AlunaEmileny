import java.time.LocalDate;
import Notificacao.Email;
import Notificacao.Notificacao;
import Notificacao.Sms;

public class Main {
    public static void main(String[] args) {
        Cliente.Endereco endereco =
                new Cliente.Endereco("lino", "xique-Xique", "santo antonio", 000);
        Cliente cliente = new Cliente("emileny", "000.111.222-33", endereco, LocalDate.now());
        Notificacao msmEmail = new Email();
        Notificacao msmSms = new Sms();
        Conta conta = new Conta("000-1", "0102030-9", 0, cliente, msmEmail);

        // Teste da conta Corrente

        Conta contaCorrente = new ContaCorrente("000-1", "0102030-9", 0, cliente, 1000, msmEmail);
        contaCorrente.depositar(100);
        // transferencia da conta corrente não está contando com o cheque especial
        contaCorrente.transferir(100, conta);
        contaCorrente.transferir(100, conta);
        contaCorrente.transferir(100, conta);
        contaCorrente.verExtrato();

        // Teste da conta Poupança
        System.out.println("::::::::::::::Conta POUPANÇA::::::::::");
        Conta contaPoupanca = new ContaPoupanca("000-1", "010203-9", 0, cliente, 0, msmSms);
        contaPoupanca.depositar(100);
        contaPoupanca.verExtrato();
        contaPoupanca.sacar(10);
        contaPoupanca.verExtrato();

    };
}
