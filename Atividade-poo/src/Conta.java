public class Conta {
    private String agencia, numero;
    private double saldo;
    private Cliente cliente;
    
    public Conta(String agencia, String numero, double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
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
    
}