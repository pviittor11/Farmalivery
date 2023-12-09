import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClientePessoaFisica cliente = null;
        Produto medicamento = null;
        Pedido pedido = null;
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Exibir Cliente Cadastrado");
            System.out.println("3 - Cadastrar Medicamento");
            System.out.println("4 - Exibir Medicamento Cadastrado");
            System.out.println("5 - Adicionar Pedido");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cliente = cadastrarCliente(scanner);
                    break;
                case 2:
                    exibirCliente(cliente);
                    break;
                case 3:
                    if (cliente != null) {
                        medicamento = cadastrarMedicamentos(scanner);
                    } else {
                        System.out.println("Erro: Cadastre um cliente antes de adicionar um medicamento.");
                    }
                    break;
                case 4:
                    exibirMedicamento(medicamento);
                    break;
                case 5:
                if (cliente != null && medicamento != null) {
                    if (pedido == null) {
                        pedido = adicionarPedido(cliente,scanner);
                    }
                    adicionarItensAoPedido(pedido,scanner);
                    pedido.escolherFormaPagamento(scanner);
                } else {
                    System.out.println("Erro: Cadastre um cliente e um medicamento antes de adicionar um pedido.");
                }
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

  // ...

private static Pedido adicionarPedido(ClientePessoaFisica cliente, Scanner scanner) {
    System.out.println("Adicionando Pedido:");
    Pedido novoPedido = new Pedido(1, null, cliente);
    novoPedido.escolherTipoEntrega(scanner); 
    return novoPedido;
}

    private static Produto encontrarMedicamentoPorCodigo(int codigo) {
    List<Produto> medicamentos = Produto.getMedicamentosCadastrados();
    for (Produto medicamento : medicamentos) {
        if (medicamento.getCodigoProduto() == codigo) {
            return medicamento;
        }
    }
    return null; 
}

private static void adicionarItensAoPedido(Pedido pedido, Scanner scanner) {
    int opcao;

    do {
        System.out.println("Lista de Produtos Disponíveis:");
        Produto.exibirMedicamentosCadastrados();

        System.out.println("Escolha um medicamento para adicionar ao carrinho:");
        System.out.print("Digite o código do medicamento: ");
        int codigoMedicamento = scanner.nextInt();

        Produto medicamento = encontrarMedicamentoPorCodigo(codigoMedicamento);

        if (medicamento != null) {
            System.out.println("Medicamento escolhido: " + medicamento.getNomeProduto());
            System.out.println("Valor do produto: " + medicamento.getvalorUnitario());

            System.out.print("Quantidade do produto a ser adicionado ao carrinho: ");
            int quantidade = scanner.nextInt();
            ItemPedido itemPedido = new ItemPedido(medicamento, quantidade);
            pedido.getCarrinho().adicionarItem(itemPedido);
            System.out.println("");
        } else {
            System.out.println("Medicamento não encontrado. Tente novamente.");
        }

        System.out.println("Deseja adicionar mais itens ao carrinho? (1 - Sim / 0 - Não): ");
        opcao = scanner.nextInt();
    } while (opcao != 0);
    pedido.calcularValorFinal();
}

    private static ClientePessoaFisica cadastrarCliente(Scanner scanner) {
        System.out.println("Digite os dados do cliente:");

        System.out.print("Nome: ");
        String nome = scanner.next();

        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.next();

        System.out.print("Telefone: ");
        String telefone = scanner.next();

        System.out.print("Endereço: ");
        String endereco = scanner.next();

        System.out.print("CPF: ");
        String cpf = scanner.next();

        System.out.print("RG: ");
        String rg = scanner.next();

        return new ClientePessoaFisica(nome, dataNascimento, telefone, endereco, cpf, rg);
    }

    private static void exibirCliente(ClientePessoaFisica cliente) {
        if (cliente != null) {
            cliente.exibirInformacoes();
        } else {
            System.out.println("Nenhum cliente cadastrado.");
        }
    }

    private static Produto cadastrarMedicamentos(Scanner scanner) {
        String nomeProduto;
        float valorUnitario;
        String categoria;
        int codigoMedicamento;
        int quantEstoque;

        System.out.println("Insira os dados do medicamento:");

        scanner.nextLine();

        System.out.print("Nome do Medicamento: ");
        nomeProduto = scanner.nextLine();

        System.out.print("Valor Unitário: ");
        valorUnitario = scanner.nextFloat();

        System.out.print("Categoria: ");
        categoria = scanner.next();

        System.out.print("Código do Medicamento: ");
        codigoMedicamento = scanner.nextInt();

        System.out.print("Quantidade em Estoque: ");
        quantEstoque = scanner.nextInt();

        return new Produto(nomeProduto, valorUnitario, categoria, codigoMedicamento, quantEstoque);
    }

    private static void exibirMedicamento(Produto medicamento) {
        if (medicamento != null) {
            Produto.exibirMedicamentosCadastrados();
        } else {
            System.out.println("Nenhum medicamento cadastrado.");
        }
    }
}
