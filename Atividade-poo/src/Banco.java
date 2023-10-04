import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
    // TODO: code application logic here
    Scanner scanner = new Scanner(System.in);
    Conta conta = null;
    
    while (true){ 
        System.out.println("0- sair\n1- Criar Conta\n2- Depositar\n3- Sacar\n4- Trasferir\n5- Ver saldo\n6- Extrato");
        System.out.println("Qual a sua opção?");
        int op = scanner.nextInt();
        if (op == 0){
            System.out.println("Saindo do programa...");
            break;
        }else if (op == 1){
        System.out.println("Digite seu nome: ");
        String nome=scanner.next();
        System.out.println("Digite seu cpf: ");
        String cpf = scanner.next();
        System.out.println("Digite a rua: ");
        String rua = scanner.next();
        System.out.println("Digite o bairro: ");
        String bairro = scanner.next();
        System.out.println("Digite a cidade: ");
        String cidade = scanner.next();
        System.out.println("Digite o número da casa:");
        int numCasa = scanner.nextInt();

        Cliente.Endereco endereco = new Cliente.Endereco(rua, bairro, cidade, numCasa);
        Cliente cliente = new Cliente(nome, cpf, endereco, null);
        conta = new Conta("000-1", "0102030-9", 0, cliente);
        System.out.println("Conta criada com sucesso!");
    }
    else if (op == 2){
        System.out.println("Qual valor você quer Depositar?");
        double valor = scanner.nextDouble();
        conta.depositar(valor);
        System.out.println("Deposito realizado com sucesso!");
        conta.adicionarTransacao("Deposito", valor, null);
    }
    else if (op == 3){
        System.out.println("Qual valor você quer sacar?");
        double valor = scanner.nextDouble();
        conta.sacar(valor);
        System.out.println("saque realizado com sucesso!");
        conta.adicionarTransacao("Saque", valor, null);
    }
    else if (op == 4){
        System.out.println("Qual valor você quer trasferir");
        double valor = scanner.nextDouble();
        System.out.println("Digite o nome do destinatario");
        String destinatario = scanner.next();
        System.out.println("Digite o numero da conta de destino");
        String contaDestino = scanner.next();
        conta.transferir(destinatario,contaDestino,valor);
        conta.adicionarTransacao("Transferencia", valor, null);
    }
    else if (op == 5){
        conta.verSaldo();
    }else if (op == 6){
        conta.verExtrato();
    }
}
scanner.close();
}
}
