package Services.Controllers;


import Model.*;
import Services.ConectDB.ConexaoMySQL;
import Services.Get;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class PedidoController {
    static int sanduiche = 0,
               guarnicao = 0,
               suco = 0,
               cliente = 0,
               funcionario = FuncionarioController.idLogin;

    public static void sellPedidos(ArrayList<Sanduiche> lSand,
                                   ArrayList<Guarnicao> lGuarn,
                                   ArrayList<Suco>lSuco,
                                   ArrayList<Cliente>lCliente,
                                   ArrayList<PedidoNome> lPedido) {
        int O = 0;

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


            switch (selected){
                default:
                    System.out.println("Opção inválida");
                    break;

                case 1:
                    if (lSand.isEmpty()){
                        imprimirSanduiche(lSand);
                    } else {
                        imprimirSanduiche(lSand);
                        System.out.println("Qual Index deseja? ");
                        sanduiche = Get.integer();
                    }
                    break;
                case 2:
                    if(lCliente.isEmpty()){
                        imprimirGuarnicao(lGuarn);
                    }else {
                        imprimirGuarnicao(lGuarn);
                        System.out.println("Qual Index deseja? ");
                        guarnicao = Get.integer();
                    }
                    break;
                case 3:
                    if (lSuco.isEmpty()){
                        imprimirSuco(lSuco);
                    } else {
                        imprimirSuco(lSuco);
                        System.out.println("Qual Index deseja? ");
                        suco = Get.integer();
                    }
                    break;

                case 4:
                    if (lCliente.isEmpty()){
                        ClienteController.imprimirCliente(lCliente);
                    } else {
                        ClienteController.imprimirCliente(lCliente);
                        System.out.println("Qual Index deseja? ");
                        cliente = Get.integer();
                    }
                    break;

                case 5:
                    if (cliente != 0) {
                        if (suco != 0 || sanduiche != 0 || guarnicao != 0) {

                            setPedidos();
                            getPedidos(getPedidoBase());
                            imprimirPedido(lPedido);

                        } else {
                            System.out.println("Ao menos um Lanche deve ser selecionado");
                            System.out.println("É Obrigatorio selecionar um cliente");
                        }
                    }else {
                        System.out.println("Ao menos um Lanche deve ser selecionado");
                        System.out.println("É Obrigatorio selecionar um cliente");
                    }
                    break;

                case 0:
                    O = 1;
                    break;


            }
        }

    }

    public static void showPedidos(ArrayList<Sanduiche>lSand,
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

    public static void setPedidos(){

        Connection conexao = ConexaoMySQL.getConexaoMySQL();

        Pedido p = new Pedido(0, sanduiche, suco, guarnicao, cliente, funcionario);
        try {

            String sql = "INSERT INTO Pedidos" +
                    "(idSanduiche, idSuco, idGuarnicao, idCliente, idFuncionario)" +
                    "VALUES (?,?,?,?,?)";

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setInt(1, p.getIdSanduiche());
            statement.setInt(2, p.getIdSuco());
            statement.setInt(3, p.getIdGuarnicao());
            statement.setInt(4, p.getIdCliente());
            statement.setInt(5, p.getIdFuncionario());

            int rows = statement.executeUpdate();
            if (rows>0) {
                System.out.println("\n\n-------------------------------");
                System.out.println("  Pedido efetuado com sucesso");
                System.out.println("-------------------------------\n\n");
            }

            } catch (SQLException throwables) {
               throwables.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
    }

    public static ArrayList<PedidoNome> getPedidos(ArrayList<Pedido> pedido){
        Connection conexao = ConexaoMySQL.getConexaoMySQL();
        ArrayList<PedidoNome> pedidoNome = new ArrayList<>();


        int idPedido = 0, idCliente = 0, idSanduiche = 0, idGuarnicao = 0, idSuco = 0;

        for (Pedido p : pedido) {
            idPedido = p.getId();
            idCliente = p.getIdCliente();
            idSanduiche = p.getIdSanduiche();
            idGuarnicao = p.getIdGuarnicao();
            idSuco = p.getIdSuco();


            try {
                String sql =  "SELECT Cliente.nome, Sanduiche.nome, Guarnicao.nome, Suco.sabor from Sanduiche, Guarnicao," +
                                                "Suco WHERE Pedidos.id LIKE \""+ idPedido +
                                                    "\" Cliente.id LIKE \""+ idCliente +
                                                    "\" Sanduiche.id LIKE \""+ idSanduiche +
                                                "\" and Guarnicao.id LIKE \""+ idGuarnicao +
                                                "\" and Suco.id LIKE \""+ idSuco + "\"";


                Statement statement = conexao.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);


                    while(resultSet.next()) {
                        pedidoNome.add(new PedidoNome(

                                resultSet.getInt("Pedido.id"),
                                resultSet.getString("Cliente.nome"),
                                resultSet.getString("Sanduiche.nome"),
                                resultSet.getString("Guarnicao.nome"),
                                resultSet.getString("Suco.sabor")
                        ));
                    }

            } catch (Exception e) {
                e.printStackTrace();
            }

            ConexaoMySQL.fecharConexao();
        }



        return pedidoNome;
    }
    
    public static ArrayList<Pedido> getPedidoBase(){
        
        ArrayList<Pedido> lPedido = new ArrayList<>();
        Connection conexao = ConexaoMySQL.getConexaoMySQL();
        
        try {
            String sql = "SELECT * FROM Pedidos";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()){
                lPedido.add(new Pedido(
                        resultSet.getInt("id"),
                        resultSet.getInt("idSanduiche"),
                        resultSet.getInt("idSuco"),
                        resultSet.getInt("idGuarnicao"),
                        resultSet.getInt("idCliente"),
                        resultSet.getInt("idFuncionario")
                ));
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }ConexaoMySQL.fecharConexao();
        return lPedido;
    }

    public static void imprimirPedido(ArrayList<PedidoNome> l){
        System.out.println("\n\n===== RELATORIO GERAL DE PEDIDOS =====");


        if (l.isEmpty()){
            System.out.println("\n-------------------------------------------");
            System.out.println("------- Não há Pedidos cadastrados --------");
            System.out.println("-------------------------------------------");
        }else {
            for (PedidoNome p : l) {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Pedido para o cliente: " + p.getCliente());
                System.out.println("\t- Numero do pedido" + p.getId());
                if(p.getSanduiche().isEmpty()){}else{
                    System.out.println("\t- Sanduiche: " + p.getSanduiche());
                }
                if(p.getSanduiche().isEmpty()){}else {
                    System.out.println("\t- Guarnição: " + p.getGuarnicao());
                }
                if(p.getSanduiche().isEmpty()){}else {
                    System.out.println("\t- Bebida: " + p.getSuco());
                }

            }
            LocalDate data = LocalDate.now();
            System.out.println("---Relatorio gerado em: " + data.getDayOfMonth() + "/" + (data.getMonthValue()) + "/" + data.getYear() + "-------");
        }
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
