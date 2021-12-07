package Services.Controllers;

import Model.Funcionario;
import View.Menu;

import java.util.ArrayList;

public class RootController {
    public static void verify(){
        String nome, pass, email;
        boolean rootAcess = false;
        FuncionarioController.getFuncionario();

        if(rootAcess == true){
            Menu.login();
        }else{
            System.out.println("ERRO");
        }

    }
}
