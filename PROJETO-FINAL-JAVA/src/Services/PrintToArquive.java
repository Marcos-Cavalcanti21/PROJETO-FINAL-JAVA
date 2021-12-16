package Services;

import Model.Globais;
import Model.PedidoNome;
import Services.Controllers.Log;
import Services.Controllers.PedidoController;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintToArquive {
    public static void writeArquive(ArrayList<PedidoNome> l){
        Log log = new Log(true);



        try{
            FileWriter file = new FileWriter(Globais.path, true);
            BufferedWriter buff = new BufferedWriter(file);


            buff.write(log.getTitulo_log());

            for (PedidoNome p : l) {

                        buff.write( "\n------------------------------------------------------------------------" +
                        "\n\nPedido para o cliente: " + p.getCliente() +
                        "\n\n\t- Numero do pedido: " + p.getId() +
                        "\n\t- Sanduiche: " + p.getSanduiche() +
                        "\n\t- Guarnição: " + p.getGuarnicao() +
                        "\n\t- Bebida: " + p.getSuco()
                        );
            }

            buff.write( log.getHora_log() + "\n");

            buff.close();
            file.close();
            System.out.println("Relatorio gerado com sucesso!");
        }catch (FileNotFoundException e){
            System.err.println("Relatorio não Salvo...");
            System.out.println("O caminho não existe. Confirme se a pasta" +
                    " \n /home/godgreen_sk/Documents/Saida/Users.dat foi criada!");


        }catch (IOException e) {
            System.err.println("Relatório não salvo...");
            System.out.println("##ERRO INESPERADO##:\n" + e);
        }

    }
    public static void readArquive(){

        try{
            FileReader file = new FileReader(Globais.path);
            BufferedReader buff = new BufferedReader(file);

            String row = "";
            while((row = buff.readLine()) != null){
                Log l = new Log(row);
                System.out.println(row);

            }

            buff.close();
            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado!!");
        } catch (IOException e) {
            System.err.println("Erro inesperado!\n" + e);
        }
    }
}
