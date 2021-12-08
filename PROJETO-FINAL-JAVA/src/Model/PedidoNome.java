package Model;

public class PedidoNome {
    private String sanduiche,
                   guarnicao,
                   suco;

    public PedidoNome() {}

    public PedidoNome(String sanduiche, String guarnicao, String suco) {
        this.sanduiche = sanduiche;
        this.guarnicao = guarnicao;
        this.suco = suco;

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
