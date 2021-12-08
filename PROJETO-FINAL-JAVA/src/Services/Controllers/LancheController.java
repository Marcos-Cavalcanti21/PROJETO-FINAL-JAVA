package Services.Controllers;

import Model.Guarnicao;
import Model.Sanduiche;
import Model.Suco;
import Services.ConectDB.ConexaoMySQL;
import Services.Get;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class LancheController {
    public static void sanduiche(){
        String nome, ingredientes;
        double preco;

        System.out.println("Nome do Sanduiche: ");
        nome = Get.string();

        System.out.println("Ingredientes usados: ");
        ingredientes = Get.string();

        System.out.println("Preço do sanduiche: ");
        preco = Get.decimal();

        Sanduiche s = new Sanduiche(0, nome, ingredientes, preco);

        Connection conexao = ConexaoMySQL.getConexaoMySQL();

        try{
            String sql = "INSERT INTO Sanduiche " +
                    "(nome, ingrediente, preco)" +
                    "VALUES (?,?,?)";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,s.getNome());
            statement.setString(2,s.getIngrediente());
            statement.setDouble(3,s.getPreço());

            int rows = statement.executeUpdate();

            if(rows>0){
                System.out.println("\n\n--------------------------------------");
                System.out.println("--Sanduiche Cadastrado com Sucesso!!--");
                System.out.println("--------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
    }


    public static void guarnicao(){
        String nome;
        double preco;

        System.out.println("Nome da guarnição: ");
        nome = Get.string();

        System.out.println("Preço da guarnição: ");
        preco = Get.decimal();

        Guarnicao g = new Guarnicao(0, nome, preco);

        Connection conexao = ConexaoMySQL.getConexaoMySQL();

        try{
            String sql = "INSERT INTO Guarnicao " +
                    "(nome, preco)" +
                    "VALUES (?,?)";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,g.getNome());
            statement.setDouble(2,g.getPreco());

            int rows = statement.executeUpdate();

            if(rows>0){
                System.out.println("\n\n--------------------------------------");
                System.out.println("--Guarnicao Cadastrada com Sucesso!!--");
                System.out.println("--------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
    }


    public static void suco(){
        String sabor, ingredientes;
        double preco;

        System.out.println("Sabor do suco: ");
        sabor = Get.string();

        System.out.println("Ingredientes usados: ");
        ingredientes = Get.string();

        System.out.println("Preço do suco: ");
        preco = Get.decimal();

        Suco s = new Suco(0, sabor, ingredientes, preco);

        Connection conexao = ConexaoMySQL.getConexaoMySQL();

        try{
            String sql = "INSERT INTO Suco " +
                    "(sabor, ingrediente, preco)" +
                    "VALUES (?,?,?)";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,s.getSabor());
            statement.setString(2,s.getIngrediente());
            statement.setDouble(3,s.getPreco());

            int rows = statement.executeUpdate();

            if(rows>0){
                System.out.println("\n\n-------------------------------------");
                System.out.println("----Suco Cadastrado com Sucesso!!----");
                System.out.println("-------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
    }


    public static ArrayList<Sanduiche> getSanduiche(){
        Connection conexao = ConexaoMySQL.getConexaoMySQL();
        ArrayList<Sanduiche> lista = new ArrayList<>();

        try{
            String sql = "SELECT * FROM Sanduiche";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                lista.add(new Sanduiche(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("ingrediente"),
                        resultSet.getDouble("preco")

                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
        return lista;
    }

    public static ArrayList<Guarnicao> getGuarnicao(){
        Connection conexao = ConexaoMySQL.getConexaoMySQL();
        ArrayList<Guarnicao> lista = new ArrayList<>();

        try{
            String sql = "SELECT * FROM Guarnicao";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                lista.add(new Guarnicao(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getDouble("preco")

                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
        return lista;
    }

    public static ArrayList<Suco> getSuco(){
        Connection conexao = ConexaoMySQL.getConexaoMySQL();
        ArrayList<Suco> lista = new ArrayList<>();

        try{
            String sql = "SELECT * FROM Suco";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                lista.add(new Suco(
                        resultSet.getInt("id"),
                        resultSet.getString("sabor"),
                        resultSet.getString("ingrediente"),
                        resultSet.getDouble("preco")

                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
        return lista;
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

    public static void imprimirGuarnicao(ArrayList<Guarnicao> l){
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

    public static void imprimirSuco(ArrayList<Suco> l){
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

































