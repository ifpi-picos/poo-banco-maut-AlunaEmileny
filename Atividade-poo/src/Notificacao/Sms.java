package Notificacao;

public class Sms implements Notificacao {
    @Override
    public void enviarNotificacao(String operacao, double valor){
        System.out.println("Notificação enviada por sms "+ operacao + "Valor: " + valor);
    }
    
}
