import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cliente.Endereco endereco = new Cliente.Endereco("lino", "xique-Xique", "santo antonio", 000);
        Cliente cliente = new Cliente("emileny", "000.111.222-33", endereco, LocalDate.now());
        Conta conta = new Conta("000-1", "0102030-9", 0, cliente);
        conta.depositar(100);
        ContaCorrente contaCorrente = new ContaCorrente("000-1", "0102030-9", 0, cliente, 0);
        // contaCorrente.depositar(190);
        // //contaCorrente.sacar(200);
        // contaCorrente.transferir(90, conta);
        // contaCorrente.transferir(30, conta);
        // contaCorrente.transferir(60, conta);
        //conta.verExtrato();
        ContaPoupanca contaPoupanca = new ContaPoupanca("000-1", "010203-9", 0, cliente, 0);
        contaPoupanca.depositar(100);
        contaPoupanca.depositar(50);
    }
}
