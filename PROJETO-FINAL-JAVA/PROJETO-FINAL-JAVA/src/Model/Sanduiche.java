package Model;

public class Sanduiche {

    private int id;
    private String nome;
    private String ingrediente;
    private double preço;

    public Sanduiche() {}

    public Sanduiche(int id, String nome, String ingrediente, double preço) {
        this.id = id;
        this.nome = nome;
        this.ingrediente = ingrediente;
        this.preço = preço;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }
}
