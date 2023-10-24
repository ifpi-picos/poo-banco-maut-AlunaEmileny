package Notificacao;

public class Email implements Notificacao {
    @Override
    public void enviarNotificacao(String operacao, double valor){
        System.out.println("Notificação enviada por email "+ operacao + "Valor: " + valor);
    }
}
