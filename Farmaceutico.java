public class Farmaceutico extends Funcionario {

    private int art;

    public Farmaceutico(String nome, String dataNascimento, String telefone, String endereco, String cargo, String unidadeTrabalho, int art) {
        super(nome, dataNascimento, telefone, endereco, cargo, unidadeTrabalho);
        this.art = art;
    }

    public int getArt() {
        return art;
    }

    public void setArt(int art) {
        this.art = art;
    }

    @Override
    public boolean ehFuncionario() {
       
        throw new UnsupportedOperationException("Unimplemented method 'ehFuncionario'");
    }
}
