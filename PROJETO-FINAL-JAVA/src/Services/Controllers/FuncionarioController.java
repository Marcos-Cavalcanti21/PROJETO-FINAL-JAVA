package Services.Controllers;

import Model.Cliente;
import Model.IrootAcess;
import Model.Funcionario;
import Model.Login;
import Services.ConectDB.ConexaoMySQL;
import Services.Get;
import View.Menu;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static View.Menu.PDV;

public class FuncionarioController implements IrootAcess {
    public static int idLogin;

    public static void cadastrar (){
        String nome;
        String pass;
        String email;

        System.out.println("Nome do usuario: ");
        nome = Get.string();

        System.out.println("Senha: ");
        pass = Get.string();

        System.out.println("Email - Opcional: ");
        email = Get.string();

        Connection conexao = ConexaoMySQL.getConexaoMySQL();

        Funcionario p = new Funcionario(0, nome, pass, email, false);

        try{

            String sql = "INSERT INTO Funcionario" +
                    "(nome, pass, email, permission_root)" +
                    "VALUES (?,?,?,?)";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, p.getNome());
            statement.setString(2, p.getPass());
            statement.setString(3, p.getEmail());
            statement.setBoolean(4, p.getRoot());



            int rows = statement.executeUpdate();

            if(rows>0){
                System.out.println("\n\n===============================");
                System.out.println("Usuario cadastrado com sucesso!");
                System.out.println("===============================");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
    }

    public static void logon() {

        String nome, pass;

            System.out.print("Digite seu Login: ");
            nome = Get.string();
            System.out.print("Digite sua Senha: ");
            pass = Get.string();


            Connection conexao = ConexaoMySQL.getConexaoMySQL();
            ArrayList<Login> login = new ArrayList<>();

            try{
                String sql = "SELECT id, nome, pass FROM Funcionario WHERE nome = \"" + nome +"\" and pass = \""+ pass +"\";";
                Statement statement = conexao.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()){
                    login.clear();
                    login.add(new Login(
                       resultSet.getInt("id"),
                       resultSet.getString("nome"),
                       resultSet.getString("pass")
                    ));

                }
                if(login.isEmpty()){
                    System.out.println("\n\nLogin ou senha invalidos");
                }else {
                    for (Login l : login){
                        int idLogin = FuncionarioController.idLogin;
                        idLogin = l.getId();
                        FuncionarioController.idLogin = idLogin;


                        if (l.getId() == 1){
                            System.out.println("\n\n==================================");
                            System.out.println("\t Administrador: " + l.getLogin());
                            System.out.println("\t Logado com Sucesso");
                            System.out.println("==================================");

                            ConexaoMySQL.fecharConexao();
                            Menu.inicio();
                        }else {
                            System.out.println("\n\n==================================");
                            System.out.println("\t Usuario: " + l.getLogin());
                            System.out.println("\t Logado com Sucesso");
                            System.out.println("==================================");

                            ConexaoMySQL.fecharConexao();
                            PDV();

                        }
                    }


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ConexaoMySQL.fecharConexao();



    }

    public static ArrayList<Funcionario> getFuncionario(){

        ArrayList<Funcionario> funcList = new ArrayList<>();
        Connection conexao = ConexaoMySQL.getConexaoMySQL();

        try{
            String sql = "SELECT * FROM Funcionario";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                funcList.add(new Funcionario(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("pass"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("permission_root")
                ));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
        return funcList;
    }

    public static void imprimirFuncionario(ArrayList<Funcionario> l){
        System.out.println("\n\n=======RELATÓRIO GERAL DE CLIENTES========");

        if (l.isEmpty()){
            System.out.println("\n----------------------------------------");
            System.out.println("------ Não há funcionarios cadastrados ------");
            System.out.println("----------------------------------------");
        }else {
            for (Funcionario f : l){
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("ID: " + f.getId());
                System.out.println("Nome: " + f.getNome());
                System.out.println("Senha: " + f.getPass());
                if (f.getEmail().isEmpty()){
                }else{
                    System.out.println("E-Mail: " + f.getEmail());
                }
            }
            LocalDate data = LocalDate.now();
            System.out.println("---Relatorio gerado em: " + data.getDayOfMonth() + "/" + (data.getMonthValue()) + "/" + data.getYear() + "-------");
        }
    }



}
