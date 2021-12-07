package Services.Controllers;

import Model.Cliente;
import Services.ConectDB.ConexaoMySQL;
import Services.Get;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteController {

    public static void cadastrar(){
        String nome, CPF, endereco, email;

        System.out.println("Nome do Cliente: ");
        nome = Get.string();

        System.out.println("CPF do Cliente: ");
        CPF = Get.string();

        System.out.println("Endereço do Cliente: ");
        endereco = Get.string();

        System.out.println("E-Mail do Cliente: ");
        email = Get.string();

        Cliente c = new Cliente(0, nome, CPF, endereco, email);

        Connection conexao = ConexaoMySQL.getConexaoMySQL();

        try{
            String sql = "INSERT INTO Cliente " +
                    "(nome, cpf, endereco, email)" +
                    "VALUES (?,?,?,?)";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,c.getNome());
            statement.setString(2,c.getCpf());
            statement.setString(3,c.getEndereco());
            statement.setString(4,c.getEmail());

            int rows = statement.executeUpdate();

            if(rows>0){
                System.out.println("\n\n--------------------------------------");
                System.out.println("---Cliente Cadastrado com Sucesso!!---");
                System.out.println("--------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
    }

    public static ArrayList<Cliente> getCliente(){
        Connection conexao = ConexaoMySQL.getConexaoMySQL();
        ArrayList<Cliente> lista = new ArrayList<>();

        try{
            String sql = "SELECT * FROM Cliente";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                lista.add(new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("endereco"),
                        resultSet.getString("email")

                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
        return lista;
    }

    public static void imprimirCliente(ArrayList<Cliente> l){
        System.out.println("\n\n=======RELATÓRIO GERAL DE CLIENTES========");

        if (l.isEmpty()){
            System.out.println("\n----------------------------------------");
            System.out.println("------ Não há clientes cadastrados ------");
            System.out.println("----------------------------------------");
        }else {
            for (Cliente c : l){
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("ID: " + c.getId());
                System.out.println("Nome: " + c.getNome());
                System.out.println("CPF: " + c.getCpf());
                System.out.println("Endereço: " + c.getEndereco());
                System.out.println("E-Mail: " + c.getEmail());
            }
            LocalDate data = LocalDate.now();
            System.out.println("---Relatorio gerado em: " + data.getDayOfMonth() + "/" + (data.getMonthValue()) + "/" + data.getYear() + "-------");
        }
    }

}
