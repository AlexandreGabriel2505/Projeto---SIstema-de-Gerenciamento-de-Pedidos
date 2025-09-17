import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        // Ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        List<Pedido> listaDePedidos = new ArrayList<>();

        // controla o numero sequencial dos pedidos
        int proximoNumeroPedido = 1;

        // Loop para manter o menu rodando ate que o usuario escolha sair
        while(true){
            System.out.println("\n===== Restaurante 'Sakura Coffee' =====");
            System.out.println("1. Registrar Pedido");
            System.out.println("2. Remover Pedido");
            System.out.println("3. Listar Pedidos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    // --- LÓGICA PARA REGISTRAR PEDIDO ---
                    // Pega o nome do cliente
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    // Cria o novo objeto Pedido
                    Pedido novoPedido = new Pedido(proximoNumeroPedido, nomeCliente);

                    // Loop para add itens ao pedido
                    while(true) {
                        System.out.print("Digite o nome do item (ou 'fim' para terminar): ");
                        String nomeItem = scanner.nextLine();

                        // Condiçao de parada:
                        if (nomeItem.equalsIgnoreCase("fim")) {
                            break;
                        }
                        System.out.print("Digite o preço do item: ");
                        double precoItem = Double.parseDouble(scanner.nextLine());

                        // Cria o objeto Item com os dados informados
                        Item novoItem = new Item(nomeItem, precoItem);

                        // Adiciona o item criado à lista de itens do nosso pedido
                        novoPedido.adicionarItem(novoItem);
                        System.out.println("Item adicionado!");
                    }
                    // add o pedido completo a lista principal do restaurante
                    listaDePedidos.add(novoPedido);
                    proximoNumeroPedido++;

                    // Mostra a nota de confirmação
                    System.out.println("\n========================================");
                    System.out.println("         Pedido Registrado!           ");
                    System.out.println("========================================");
                    System.out.println("Pedido Nº: " + novoPedido.getNumero());
                    System.out.println("Cliente: " + novoPedido.getNomeCliente());
                    System.out.println("----------------------------------------");
                    System.out.println("Itens:");
                    // Loop para mostrar cada item do pedido
                    for (Item item : novoPedido.getItens()) {
                        System.out.println("- " + item.getNome() + " | R$ " + String.format("%.2f", item.getPreco()));
                    }
                    System.out.println("----------------------------------------");
                    System.out.println("Total: R$ " + String.format("%.2f", novoPedido.getValorTotal()));
                    System.out.println("========================================");
                    break;
                case 2:
                    // --- LÓGICA PARA REMOVER PEDIDO ---
                    // Verificar se a lista esta vazia
                    if (listaDePedidos.isEmpty()){
                        System.out.println("Não há pedidos registrados para remover.");
                        break;
                    }

                    System.out.print("Digite o número do pedido que deseja remover: ");
                    int numeroParaRemover = Integer.parseInt(scanner.nextLine());

                    boolean removido = listaDePedidos.removeIf(pedido -> pedido.getNumero() == numeroParaRemover
                    );
                    if (removido) {
                        System.out.println("Pedido Nº " + numeroParaRemover + " removido com sucesso!");
                    } else {
                        // se for falso:
                        System.out.println("Erro: Pedido Nº " + numeroParaRemover + " não encontrado.");
                    }
                    break;
                case 3:
                    // --- LÓGICA PARA LISTAR PEDIDOS ---
                     // se a lista está vazia, avisamos o usuário.
                    if (listaDePedidos.isEmpty()) {
                        System.out.println("Nenhum pedido registrado no sistema.");
                    } else {
                        System.out.println("\n===== Lista de Todos os Pedidos =====");
                        // Usamos um loop para passar por cada 'pedido' na nossa 'listaDePedidos'.
                        for (Pedido pedido : listaDePedidos) {
                            System.out.println("----------------------------------------");
                            System.out.println("Pedido Nº: " + pedido.getNumero()); // Pega o número do pedido 
                            System.out.println("Cliente: " + pedido.getNomeCliente());  
                            System.out.println("Itens:");

                            // Para cada pedido percorremos a lista de iten.
                            for (Item item : pedido.getItens()) {
                                // Imprime o nome e o preço de cada item 
                                System.out.println("- " + item.getNome() + " | R$ " + String.format("%.2f", item.getPreco()));
                            }
                            System.out.println("Valor Total: R$ " + String.format("%.2f", pedido.getValorTotal())); // Mostra o valor total do pedido 
                        }
                        System.out.println("=======================================");
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o sistema. Obrigado!");
                    scanner.close(); // fechar o scanner antes de sair.
                    System.exit(0); // Encerra o programa
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}
