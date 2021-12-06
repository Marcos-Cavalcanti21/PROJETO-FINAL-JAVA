package Model;

public class Pedido {
    private int idSanduiche,
                idSuco,
                idGuarnicao,
                idCliente,
                idFuncionario;

    public Pedido() {}

    public Pedido(int idSanduiche, int idSuco, int idGuarnicao, int idCliente, int idFuncionario) {
        this.idSanduiche = idSanduiche;
        this.idSuco = idSuco;
        this.idGuarnicao = idGuarnicao;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
    }

    public int getIdSanduiche() {
        return idSanduiche;
    }

    public void setIdSanduiche(int idSanduiche) {
        this.idSanduiche = idSanduiche;
    }

    public int getIdSuco() {
        return idSuco;
    }

    public void setIdSuco(int idSuco) {
        this.idSuco = idSuco;
    }

    public int getIdGuarnicao() {
        return idGuarnicao;
    }

    public void setIdGuarnicao(int idGuarnicao) {
        this.idGuarnicao = idGuarnicao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
