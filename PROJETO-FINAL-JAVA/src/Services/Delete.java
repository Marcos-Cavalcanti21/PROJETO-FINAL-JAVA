package Services;

import Model.*;
import Services.ConectDB.ConexaoMySQL;
import Services.Controllers.ClienteController;
import Services.Controllers.FuncionarioController;
import Services.Controllers.LancheController;
import Services.Controllers.PedidoController;
import View.Menu;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Delete {
    static int index;
    static String tabela;
    public static void deleteIndex(ArrayList<Sanduiche> lSand,
                                   ArrayList<Guarnicao> lGuarn,
                                   ArrayList<Suco>lSuco,
                                   ArrayList<Cliente>lCliente,
                                   ArrayList<Funcionario>lFunc){

        while (0==0){
            System.out.println("\n\n================================");
            System.out.println("======Sistema de Exclusão=======");
            System.out.println("================================");
            System.out.println("\t(1)SANDUICHES");
            System.out.println("\t(2)GUARNIÇÕES");
            System.out.println("\t(3)SUCOS");
            System.out.println("\t(4)FUNCIONAROS");
            System.out.println("\t(5)CLIENTES");
            System.out.println("\t(0)VOLTAR");
            int selected = Get.integer();

            switch (selected){
                default:
                    System.err.println("Opção inválida");
                    break;

                case 1:
                    tabela = "Sanduiche";
                    PedidoController.imprimirSanduiche(lSand);
                    selectIndex();
                    remove();
                    break;

                case 2:
                    tabela = "Guarnicao";
                    PedidoController.imprimirGuarnicao(lGuarn);
                    selectIndex();
                    remove();
                    break;

                case 3:
                    tabela = "Suco";
                    PedidoController.imprimirSuco(lSuco);
                    selectIndex();
                    remove();
                    break;
                case 4:
                    tabela = "Funcionario";
                    FuncionarioController.imprimirFuncionario(lFunc);
                    selectIndex();
                    if (index == 1){
                        System.out.println("O Administrador não pode ser excluido");
                    }else {
                        remove();
                    }
                    break;
                case 5:
                    tabela = "Cliente";
                    ClienteController.imprimirCliente(lCliente);
                    selectIndex();
                    remove();
                    break;


                case 0:
                    Menu.inicio();
                    break;

            }
        }



    }

    public static void selectIndex(){
        System.out.println("Qual index deseja? ");
        index = Get.integer();
    }

    public static void remove(){
        Connection conexao = ConexaoMySQL.getConexaoMySQL();

        try{
            String sql = "DELETE FROM " + tabela + " WHERE id = " + index;

            PreparedStatement statement = conexao.prepareStatement(sql);


            int rows = statement.executeUpdate();

            if(rows>0){
                System.out.println("\n\n--------------------------------------");
                System.out.println("-- Index Excluído com Sucesso!!--");
                System.out.println("--------------------------------------");
            }

            tabela = "";
            deleteIndex(LancheController.getSanduiche(),
                    LancheController.getGuarnicao(),
                    LancheController.getSuco(),
                    ClienteController.getCliente(),
                    FuncionarioController.getFuncionario());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
    }
}
