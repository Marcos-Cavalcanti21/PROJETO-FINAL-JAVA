package Services.Controllers;

import Model.Suco;

import java.util.ArrayList;

public class Log {
    private String Relatorio;

    public Log() {}

    public Log(String relatorio) {
        Relatorio = relatorio;
    }

    public Log(boolean monta){
        if (monta){
            ArrayList<Suco> l = new ArrayList<>();
            PedidoController.imprimirSuco(l);
        }
    }

    public void Print(){

    }
}
