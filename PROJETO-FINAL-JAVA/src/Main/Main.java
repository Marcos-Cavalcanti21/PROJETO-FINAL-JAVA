package Main;

import View.Menu;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
       //Carregar informação de Root do banco em um array
/*
        JFrame janela = new JFrame();

        janela.setSize(300,200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = janela.getContentPane();
        contentPane.setLayout(new BorderLayout());
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);

*/
        Menu.login();



    }
}
/*
AVALIAÇÃO DE JAVA SE
====================

SUBIR PARCIAL DO PROJETO


=============================Especificações do projeto

TEMA LIVRE
Sugestões:
    *Lanchonete *PDV(Ponto De Venda - comércio em geral)
    *SIG (Sistema de Informações Gerênciais)
    *Escola/Curso
    *Hospedagem

--RECURSOS MÍNIMOS!!!--
    *LOGIN (acesso através de usuário e senha)
    *Uso de BD; *CRUD -> Criar, Cadastrar, Atualizar e Deletar informações
    *Opção de salvar o relatório em arquivo

*/