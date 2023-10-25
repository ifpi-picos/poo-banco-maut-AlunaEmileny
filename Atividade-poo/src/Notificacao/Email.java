package Notificacao;

public class Email implements Notificacao {
    @Override
    public void enviarNotificacao(String operacao, double valor){
        System.out.println("Notificação enviada por email\nVocê fez um "+ operacao + " no Valor: R$" + valor);
    }
}
