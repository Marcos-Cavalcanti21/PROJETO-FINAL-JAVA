package Model;

public class PedidoNome {
    private String sanduiche,
                   suco,
                   guarnicao,
                   cliente,
                   funcionario;

    public PedidoNome() {}

    public PedidoNome(String sanduiche, String suco, String guarnicao, String cliente, String funcionario) {
        this.sanduiche = sanduiche;
        this.suco = suco;
        this.guarnicao = guarnicao;
        this.cliente = cliente;
        this.funcionario = funcionario;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }
}
