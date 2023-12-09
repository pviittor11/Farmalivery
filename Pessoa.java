import java.util.Scanner;

public abstract class Pessoa {
    Scanner scanner = new Scanner(System.in);

    private String nome;
    private String dataNascimento;
    private String telefone;
    private String endereco;

    public Pessoa(String nome, String dataNascimento, String telefone, String endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public void cadastrar() {
        System.out.println("Cadastro realizado com sucesso:");
        exibirInformacoes();
    }

    public void editarCadastro() {
        System.out.println("Editando cadastro de " + nome);
        System.out.print("Novo nome: ");
        nome = scanner.nextLine();

        System.out.print("Nova data de nascimento: ");
        dataNascimento = scanner.nextLine();

        System.out.print("Novo telefone: ");
        telefone = scanner.nextLine();

        System.out.print("Novo endereço: ");
        endereco = scanner.nextLine();

        System.out.println("Cadastro editado com sucesso:");
        exibirInformacoes();
    }

    public void excluirCadastro() {
        System.out.println("Cadastro de " + nome + " excluído com sucesso.");
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

