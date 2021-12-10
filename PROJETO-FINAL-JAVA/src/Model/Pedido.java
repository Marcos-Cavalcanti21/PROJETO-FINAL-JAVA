package Model;

public class Pedido {
    private int id;
    private int idSanduiche;
    private int idSuco;
    private int idGuarnicao;
    private int idCliente;
    private int idFuncionario;

    public Pedido(){}

    public Pedido(int id, int idSanduiche, int idSuco, int idGuarnicao, int idCliente, int idFuncionario) {
        this.id = id;
        this.idSanduiche = idSanduiche;
        this.idSuco = idSuco;
        this.idGuarnicao = idGuarnicao;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
