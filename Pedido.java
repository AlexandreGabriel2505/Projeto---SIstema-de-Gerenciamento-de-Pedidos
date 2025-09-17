import java.util.ArrayList;
import java.util.List;

public class Pedido {
    // --- Atributos ---
    private int numero;
    private String nomeCliente;
    private List<Item> itens;

    // --- Construtor ---
    public Pedido(int numero, String nomeCliente){
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>();
    }

    // --- Métodos ---

    // Inserir um elemento na lista
    public void adicionarItem(Item item){
        this.itens.add(item);
    }

    // Calcula e retorna o valor total do pedido
    public double getValorTotal() {
        double total = 0.0;
        // Loop para percorrer cada item dentro da lista
        for (Item item : this.itens) {
            total += item.getPreco();
        }
        return total;
    }

    // --- Métodos Getters ---
    public int getNumero(){
        return numero;
    }
    public String getNomeCliente(){
        return nomeCliente;
    }
    public List<Item> getItens() {
        return itens;
    }
}
