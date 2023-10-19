import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String cpf;
    private Endereco endereco;
    private LocalDate data;

    public Cliente(String nome, String cpf, Endereco endereco, LocalDate data) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.data = data;
    }

    public static class Endereco{
        private String rua, bairro ,cidade ;
        private int numeroCasa;
        
        public Endereco(String rua, String bairro, String cidade, int numeroCasa) {
            this.rua = rua;
            this.bairro = bairro;
            this.cidade = cidade;
            this.numeroCasa = numeroCasa;
        }
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getData() {
        return data;
    }
    
}
