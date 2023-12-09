public class ClientePessoaFisica extends Pessoa {

    private String cpf;
    private String rg;

    public ClientePessoaFisica(String nome, String dataNascimento, String telefone, String endereco, String cpf, String rg) {
        super(nome, dataNascimento, telefone, endereco);
        this.cpf = cpf;
        this.rg = rg;
    }

    @Override
    public void cadastrar() {
        System.out.println("Cadastro de Cliente Pessoa Física realizado com sucesso:");
        exibirInformacoes();
        System.out.println("CPF: " + cpf);
        System.out.println("RG: " + rg);
    }
}
