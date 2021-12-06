package Services.Controllers;


import Model.Guarnicao;
import Model.Pedido;
import Model.Sanduiche;
import Model.Suco;
import Services.ConectDB.ConexaoMySQL;
import Services.Get;
import View.Menu;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

public class PedidoController {

    public static void sellPedidos(ArrayList<Sanduiche>lSand,
                                  ArrayList<Guarnicao>lGuarn,
                                  ArrayList<Suco>lSuco){
        int sanduiche, guarnicao, suco, O = 0;
        while (O==0){
            System.out.println("\n\n== Selecione o Lanche para venda: ==");
            System.out.println("\n----------------------------------------");
            System.out.println("\t(1)Sanduiche");
            System.out.println("\t(2)Guarnição");
            System.out.println("\t(3)Suco");
            System.out.println("\t(4)Cliente");
            System.out.println("\t(5)FINALIZAR");
            System.out.println("\t(0)SAIR");
            int selected = Get.integer();
            Pedido pedido = new Pedido(sanduiche,guarnicao, suco,0,0);

            switch (selected){
                default:
                    System.out.println("Opção inválida");
                    break;

                case 1:
                    imprimirSanduiche(lSand);
                    System.out.println("Qual Index deseja? ");
                    sanduiche = Get.integer();
                    break;
                case 2:
                    imprimirGuarnicao(lGuarn);
                    System.out.println("Qual Index deseja? ");
                    guarnicao = Get.integer();
                    break;
                case 3:
                    imprimirSuco(lSuco);
                    System.out.println("Qual Index deseja? ");
                    suco = Get.integer();
                    break;
                case 5:

                    finalizarPedido(sanduiche, guarnicao, suco);


                    break;
                case 0:
                    O = 1;
                    break;


            }
        }

    }

    public static void getPedidos(ArrayList<Sanduiche>lSand,
                                  ArrayList<Guarnicao>lGuarn,
                                  ArrayList<Suco>lSuco){

        int O = 0;
        while (O==0){
            System.out.println("\n\n== Selecione o Lanche para Consulta: ==");
            System.out.println("\n----------------------------------------");
            System.out.println("\t(1)Sanduiche");
            System.out.println("\t(2)Guarnição");
            System.out.println("\t(3)Suco");
            System.out.println("\t(0)SAIR");
            int selected = Get.integer();

            switch (selected){
                default:
                    System.out.println("Opção inválida");
                    break;

                case 1:
                    imprimirSanduiche(lSand);
                    break;
                case 2:
                    imprimirGuarnicao(lGuarn);
                    break;
                case 3:
                    imprimirSuco(lSuco);
                    break;

                case 0:
                    O = 1;
                    break;
            }
        }
    }

    public static void finalizarPedido(ArrayList<Pedido>list){
        System.out.println(sanduiche + guarnicao + suco);

    }

    public static void imprimirSanduiche(ArrayList<Sanduiche> l){
        System.out.println("\n\n=======RELATÓRIO GERAL DE SANDUICHES========");

        if (l.isEmpty()){
            System.out.println("\n-------------------------------------------");
            System.out.println("------ Não há Sanduiches cadastrados ------");
            System.out.println("-------------------------------------------");
        }else {
            for (Sanduiche s : l){
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("ID: " + s.getId());
                System.out.println("Nome: " + s.getNome());
                System.out.println("Ingredientes: " + s.getIngrediente());
                System.out.println("Preço R$: " + s.getPreço());
            }
            LocalDate data = LocalDate.now();
            System.out.println("---Relatorio gerado em: " + data.getDayOfMonth() + "/" + (data.getMonthValue()) + "/" + data.getYear() + "-------");
        }
    }

    public static void imprimirGuarnicao(ArrayList< Guarnicao > l){
        System.out.println("\n\n=======RELATÓRIO GERAL DE GUARNIÇÕES========");

        if (l.isEmpty()){
            System.out.println("\n-------------------------------------------");
            System.out.println("------ Não há Guarnições cadastradas ------");
            System.out.println("-------------------------------------------");
        }else {
            for (Guarnicao g : l){
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("ID: " + g.getId());
                System.out.println("Nome: " + g.getNome());
                System.out.println("Preço R$: " + g.getPreco());
            }
            LocalDate data = LocalDate.now();
            System.out.println("---Relatorio gerado em: " + data.getDayOfMonth() + "/" + (data.getMonthValue()) + "/" + data.getYear() + "-------");
        }
    }

    public static void imprimirSuco(ArrayList< Suco > l){
        System.out.println("\n\n=======RELATÓRIO GERAL DE SUCOS========");

        if (l.isEmpty()){
            System.out.println("\n--------------------------------------");
            System.out.println("------ Não há Sucos cadastrados ------");
            System.out.println("--------------------------------------");
        }else {
            for (Suco s : l){
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("ID: " + s.getId());
                System.out.println("Sabor: " + s.getSabor());
                System.out.println("Ingredientes: " + s.getIngrediente());
                System.out.println("Preço R$: " + s.getPreco());
            }
            LocalDate data = LocalDate.now();
            System.out.println("---Relatorio gerado em: " + data.getDayOfMonth() + "/" + (data.getMonthValue()) + "/" + data.getYear() + "-------");
        }
    }
}
