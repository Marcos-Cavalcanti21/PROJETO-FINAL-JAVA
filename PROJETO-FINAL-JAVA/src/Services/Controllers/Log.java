package Services.Controllers;

import Model.Pedido;
import Model.PedidoNome;
import Services.PrintToArquive;

import java.time.LocalDate;
import java.util.ArrayList;

public class Log {
    private String titulo_log;
    private String dados_log;
    private String hora_log;

    public Log(String row) {}

    public Log(String titulo_log, String dados_log, String hora_log) {
        this.titulo_log = titulo_log;
        this.dados_log = dados_log;
        this.hora_log = hora_log;
    }

    public Log(boolean monta){
        if (monta){
            ArrayList<PedidoNome> l = new ArrayList<>();
            relatorioPedido(l);
        }
    }

    public void Print(){
        System.out.println(this.titulo_log);






        System.out.println(this.dados_log);

        System.out.println(this.hora_log);


    }

    public void relatorioPedido(ArrayList<PedidoNome> l){
        this.titulo_log = "\n\n===== RELATORIO GERAL DE PEDIDOS =====";





        LocalDate data = LocalDate.now();
        this.hora_log = "\n\n---Relatorio gerado em: " + data.getDayOfMonth() + "/" + (data.getMonthValue()) + "/" + data.getYear() + "-------";

    }

    public String getTitulo_log() {
        return titulo_log;
    }

    public void setTitulo_log(String titulo_log) {
        this.titulo_log = titulo_log;
    }

    public String getDados_log() {
        return dados_log;
    }

    public void setDados_log(String dados_log) {
        this.dados_log = dados_log;
    }

    public String getHora_log() {
        return hora_log;
    }

    public void setHora_log(String hora_log) {
        this.hora_log = hora_log;
    }

}
