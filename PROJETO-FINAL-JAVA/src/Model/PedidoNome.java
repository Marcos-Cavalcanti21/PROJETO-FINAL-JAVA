package Model;

public class PedidoNome {
    private int id;
    private String cliente,
                   sanduiche,
                   guarnicao,
                   suco;

    public PedidoNome() {}

    public PedidoNome(int id, String cliente, String sanduiche, String guarnicao, String suco) {
        this.id = id;
        this.cliente = cliente;
        this.sanduiche = sanduiche;
        this.guarnicao = guarnicao;
        this.suco = suco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getSanduiche() {
        return sanduiche;
    }

    public void setSanduiche(String sanduiche) {
        this.sanduiche = sanduiche;
    }

    public String getSuco() {
        return suco;
    }

    public void setSuco(String suco) {
        this.suco = suco;
    }

    public String getGuarnicao() {
        return guarnicao;
    }

    public void setGuarnicao(String guarnicao) {
        this.guarnicao = guarnicao;
    }
}
