import java.time.LocalDateTime;
public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int semCobraça;

    public ContaCorrente(String agencia, String numero, double saldo, Cliente cliente, double chequeEspecial){
        super(agencia, numero, saldo, cliente);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    public void verChequeEspecial(){
        System.out.println("Cheque Especial: " + getChequeEspecial());
    }
    public void transferir(double valor, Conta destinatario){
        if (semCobraça < 2){ 
            if (valor <= getSaldo()){
                 this.setSaldo((getSaldo() - valor));
                 System.out.println("Transferencia sem combrança");
                 semCobraça++;
           }else {
                System.out.println("Tranferencia interrompida, verifique seu saldo.");
        }
    }else{
        System.out.println("Tansferencia sobre taxa");
        this.setSaldo(getSaldo() - (valor + (valor * 0.1)));
    }
    verSaldo();
    adicionarTransacao("Transferencia", valor, LocalDateTime.now());
}

public void sacar(double valor){
    if (valor > getSaldo()){
        this.setChequeEspecial(valor - getSaldo());
        System.out.println("Saque realizado. Você está em cheque especial");
        verChequeEspecial();
        }
        else{
            this.setSaldo((getSaldo()-valor));
        }
        adicionarTransacao("Saque", valor, LocalDateTime.now());
    }
}