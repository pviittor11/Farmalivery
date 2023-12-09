public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private float preco;

    public ItemPedido(Produto produto, int quantidade) {
        setProduto(produto);
        setQuantidade(quantidade);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        atualizarPreco();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        atualizarPreco();
    }

    public float getPreco() {
        return preco;
    }

    private void atualizarPreco() {
        if (produto != null) {
            this.preco = produto.getvalorUnitario() * quantidade;
        } else {
            this.preco = 0.0f; 
        }
    }
}
