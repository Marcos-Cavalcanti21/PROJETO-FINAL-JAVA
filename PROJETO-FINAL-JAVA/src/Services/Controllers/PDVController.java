package Services.Controllers;

import Model.Sanduiche;
import Services.ConectDB.ConexaoMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PDVController {
    public static ArrayList<Sanduiche> venderLanche(){
        int index = 1;

        Connection conexao = ConexaoMySQL.getConexaoMySQL();
        ArrayList<Sanduiche> listaSand = new ArrayList<>();

        System.out.println("###VENDER LANCHE###");

        try {
            String sql = "SELECT * FROM sanduiche";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                listaSand.add(new Sanduiche(
                   resultSet.getInt("id"),
                   resultSet.getString("nome"),
                   resultSet.getString("ingrediente"),
                   resultSet.getDouble("preço")
                ));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ConexaoMySQL.fecharConexao();
        return listaSand;
    }
}
