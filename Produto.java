import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nomeProduto;
    private float valorUnitario;
    private String categoriaProduto;
    private int codigoProduto;
    private int quantProduto;

    
    private static List<Produto> medicamentosCadastrados = new ArrayList<>();

    public Produto(String nomeProduto, float valorUnitario, String categoriaProduto, int codigoProduto, int quantProduto) {
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.categoriaProduto = categoriaProduto;
        this.codigoProduto = codigoProduto;
        this.quantProduto = quantProduto;
       

        medicamentosCadastrados.add(this);
    }
    public static void exibirMedicamentosCadastrados() {
        System.out.println("Medicamentos Cadastrados:");
        for (Produto medicamento : medicamentosCadastrados) {
            System.out.println("Código: " + medicamento.getCodigoProduto() +
                    " \nNome: " + medicamento.getNomeProduto() +
                    " \nValor: " + medicamento.getvalorUnitario() +
                    " \nCategoria: " + medicamento.getCategoriaProduto()+
                    " \nEstoque: " + medicamento.getQuantProduto());
        }
    }
    

    public static List<Produto> getMedicamentosCadastrados() {
        return medicamentosCadastrados;
    }
    public void adicionarProdutoAoPedido(Pedido pedido, int quantidade) {
        if (quantProduto >= quantidade) {
            ItemPedido itemPedido = new ItemPedido(this, quantidade);
            
            pedido.adicionarItemPedido(itemPedido);

            System.out.println("Produto adicionado ao pedido!!");
        } else {
            System.out.println("Quantidade em estoque insuficiente!");
        }
    }

    public void cadastrarMedicamentos() {
        System.out.println("Medicamento cadastrado com sucesso!");
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantProduto() {
        return quantProduto;
    }

    public void setQuantProduto(int quantProduto) {
        this.quantProduto = quantProduto;
    }

    public float getvalorUnitario() {
        return valorUnitario;
    }
     public void setvalorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
     public float getNomeMedicamento() {
        return valorUnitario;
    }
       public String getCategoriaProduto() {
        return categoriaProduto;
    }
   
       public String getNomeProduto() {
        return nomeProduto;
    }
    
    
}
