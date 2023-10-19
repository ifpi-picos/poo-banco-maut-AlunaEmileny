public class ContaPoupanca extends Conta{
    private double rendimento;

    public ContaPoupanca(String agencia, String numero, double saldo, Cliente cliente, double rendimento){
        super(agencia, numero, saldo, cliente);
        this.rendimento = rendimento;
    }
    public double getRendimento() {
        return rendimento;
    }
    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
    
    public void depositar(double valor){
        setSaldo(getSaldo() + valor);
        rendimento = valor * 0.1;
        setRendimento(rendimento);
        setSaldo(rendimento + getSaldo());
        verSaldo();
    }
    public void sacar(double valor){
        if (getSaldo() >= valor){
            double taxa = 0.05;
            this.setSaldo(getSaldo() - (valor + (valor * taxa)));
            System.out.println("Saque realizado com sucesso!");
            verSaldo();
        }else {
            System.out.println("Saldo insuficiente para este saque");
        }
    }
    public void transferir(double valor, Conta destinatario){
        if (getSaldo() >= valor){
            this.setSaldo(getSaldo() - (valor + (valor * 0.1)));
            System.out.println("Saque realizado com sucesso!");
            verSaldo();
        }else {
            System.out.println("Verifique seu saldo para realizar essa transferência");
        }
    }
}
