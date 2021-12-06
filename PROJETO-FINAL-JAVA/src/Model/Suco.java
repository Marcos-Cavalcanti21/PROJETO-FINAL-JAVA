package Model;

public class Suco {
    private int id;
    private String sabor;
    private String ingrediente;
    private double preco;

    public Suco() {}

    public Suco(int id, String sabor, String ingrediente, double preco) {
        this.id = id;
        this.sabor = sabor;
        this.ingrediente = ingrediente;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
