package View;

import Model.Pedido;
import Model.Sanduiche;
import Services.Controllers.ClienteController;
import Services.Controllers.FuncionarioController;
import Services.Controllers.LancheController;
import Services.Controllers.PedidoController;
import Services.Get;

import java.util.ArrayList;

public class Menu {
    public static void login(){
        while (0==0) {
            System.out.println("\n\n==================================");
            System.out.println("===== Sistema de Lanchonete ======");
            System.out.println("==================================\n");
            //O PRIMEIRO USUARIO SERÁ CONSIDERADO ADMIN
            System.out.println("\t(1)Login");
            System.out.println("\t(2)Criar conta");
            System.out.println("\t(0)Sair do sistema");
            int selected = Get.integer();

            switch (selected) {
                default:
                    System.err.println("Opção inválida!");
                    break;
                case 1:
                    FuncionarioController.logon();
                    break;
                case 2:
                    FuncionarioController.cadastrar();
                    break;
                case 0:
                    System.exit(2);
                    break;

            }
        }
    }





    public static void inicio(){
        while (0==0){
            System.out.println("\n\n================================");
            System.out.println("======Sistema de Cadastro=======");
            System.out.println("================================");
            System.out.println("\t(1)SANDUICHES");
            System.out.println("\t(2)GUARNIÇÕES");
            System.out.println("\t(3)SUCOS");
            System.out.println("\t(4)FUNCIONAROS");
            System.out.println("\t(5)CLIENTES");
            System.out.println("\t(0)LOGOFF");
            int selected = Get.integer();

            switch (selected){
                default:
                    System.err.println("Opção inválida");
                    break;

                case 1:
                    LancheController.sanduiche();
                    break;

                case 2:
                    LancheController.guarnicao();
                    break;

                case 3:
                    LancheController.suco();
                    break;
                case 4:
                    FuncionarioController.cadastrar();
                    break;
                case 5:
                    ClienteController.cadastrar();
                    break;



                case 0:
                    login();
                    break;

            }
        }


    }

    public static void PDV(){
        while (0==0){
            System.out.println("\n\n===================================");
            System.out.println("========= Ponto de Vendas =========");
            System.out.println("===================================");
            System.out.println("(1)Vender Combo");
            System.out.println("(2)Ver Lanches");
            System.out.println("(3)Cadastrar Cliente");
            System.out.println("(0)LOGOFF");
            int selected = Get.integer();

            switch (selected){

                default:
                    System.err.println("Opção Invalida");
                    break;

                case 1:

                    PedidoController.sellPedidos(LancheController.getSanduiche(),
                                                 LancheController.getGuarnicao(),
                                                 LancheController.getSuco(),
                                                 ClienteController.getCliente(),
                                                 PedidoController.getPedidos());
                    break;

                case 2:
                    PedidoController.showPedidos(LancheController.getSanduiche(),
                                                LancheController.getGuarnicao(),
                                                LancheController.getSuco());
                    break;
                case 3:
                    ClienteController.cadastrar();
                    break;

                case 0:
                    login();
                    break;

            }


        }

    }
}
