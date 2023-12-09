import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemPedido> itens;
    private float valorAumento;

    public Carrinho() {
        this.itens = new ArrayList<>();
        this.valorAumento = 0.0f;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        System.out.println("Produto adicionado ao carrinho.");
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
        System.out.println("Produto removido do carrinho.");
    }

    public void exibirItens() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            System.out.println("Itens no Carrinho:");
            for (ItemPedido item : itens) {
                System.out.println(item);
            }
        }
    }

    public void limparCarrinho() {
        itens.clear();
        System.out.println("Carrinho limpo.");
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ItemPedido item : itens) {
            total += item.getPreco();
        }
        return total;
    }
    public void aumentarValor(float valor) {
        this.valorAumento += valor;
    }

    public float getValorAumento() {
        return valorAumento;
    }
}

