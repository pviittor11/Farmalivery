public abstract class Funcionario extends Pessoa {

    private String cargo;
    private String unidadeTrabalho;

    public Funcionario(String nome, String dataNascimento, String telefone, String endereco, String cargo, String unidadeTrabalho) {
        super(nome, dataNascimento, telefone, endereco);
        this.cargo = cargo;
        this.unidadeTrabalho = unidadeTrabalho;
    }

    public abstract boolean ehFuncionario();

    public void exibirInformacoesFuncionario() {
        exibirInformacoes();
        System.out.println("Cargo: " + cargo);
        System.out.println("Unidade de Trabalho: " + unidadeTrabalho);
    }
}
