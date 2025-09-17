public class Item {
    // --- Atributos ---
    private String nome;
    private double preco;

    // --- Construtor ---
    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // --- Métodos ---
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }

}
