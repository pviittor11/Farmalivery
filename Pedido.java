import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Pedido {
    private List<ItemPedido> itens;
    private ClientePessoaFisica cliente;
    private String tipoEntrega;
    private Carrinho carrinho;
    private float valorAumento;
    private String formaPagamento;

    public Pedido(int codigoPedido, Date dataPedido, ClientePessoaFisica cliente) {
        this.cliente = cliente;
        this.valorAumento = 0.0f; 
        this.carrinho = new Carrinho();
        this.itens = new ArrayList<>();
    }
    public void adicionarItemPedido(ItemPedido itemPedido) {
        itens.add(itemPedido);
        float novoTotal = calcularTotal();
        System.out.println("Medicamento adicionado ao pedido. Novo total: " + novoTotal);
    } 
    
    private float calcularTotal() {
        float total = 0.0f;
        
        for (ItemPedido item : itens) {
            total += item.getPreco();
        }

        return total;
    }

    public void adicionarEndereco(String endereco) {
        cliente.setEndereco(endereco);
        System.out.println("Endereço adicionado ao pedido.");
    }
    public void adicionarCupom(String cupom) {
        System.out.println("Cupom adicionado ao pedido.");
    }

    public void adicionarFormaPagamento(String formaPagamento) {
        System.out.println("Forma de pagamento adicionada ao pedido.");
    }

    public void finalizarPedido() {
        if (!itens.isEmpty()) {
            System.out.println("Pedido finalizado com sucesso.");
        } else {
            System.out.println("Erro: Adicione itens ao pedido antes de finalizá-lo.");
        }
    }

    public void verificarEstoque() {
        System.out.println("Estoque verificado.");
    }

    public void cancelarPedido() {
        itens.clear(); 
        System.out.println("Pedido cancelado.");
    }

    public void escolherFormaPagamento(Scanner scanner) {
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1 - Cartão de Crédito");
        System.out.println("2 - Cartão de Débito");
        System.out.println("3 - PIX");
        System.out.print("Opção: ");

        int opcaoPagamento = scanner.nextInt();

        switch (opcaoPagamento) {
            case 1:
                formaPagamento = "Cartão de Crédito";
                break;
            case 2:
                formaPagamento = "Cartão de Débito";
                break;
            case 3:
                formaPagamento = "PIX";
                break;
            default:
                System.out.println("Opção inválida. Usando pagamento padrão (Cartão de Crédito).");
                formaPagamento = "Cartão de Crédito";
                break;
        }

        System.out.println("Forma de pagamento escolhida: " + formaPagamento);
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public float getValorAumento() {
        return valorAumento;
    }

    public void escolherTipoEntrega(Scanner scanner) {
        System.out.println("Escolha o tipo de entrega:");
        System.out.println("1 - Entrega padrão R$ 5,00");
        System.out.println("2 - Retirada no balcão");
        System.out.print("Opção: ");

        int opcaoEntrega = scanner.nextInt();

        switch (opcaoEntrega) {
            case 1:
                tipoEntrega = "1- Entrega padrão";
                carrinho.aumentarValor(5.0f);
                break;
            case 2:
                tipoEntrega = "2- Retirada no balcão";
                break;
            default:
                System.out.println("Opção inválida. Usando entrega padrão.");
                tipoEntrega = "Entrega padrão";
                carrinho.aumentarValor(5.0f);
                break;
        }

        System.out.println("Tipo de entrega escolhido: " + tipoEntrega);
    }

    public void calcularValorFinal() {
        float valorCarrinho = carrinho.calcularTotal();
        float valorFinal = valorCarrinho + carrinho.getValorAumento();
        System.out.println("Valor final do pedido: " + valorFinal);
    }
}
