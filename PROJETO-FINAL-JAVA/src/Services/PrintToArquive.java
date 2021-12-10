package Services;

import Model.Globais;
import Services.Controllers.Log;

import java.io.*;
import java.util.Scanner;

public class PrintToArquive {
    public static void writeArquive(){
        Log p = new Log(true);

        try{
            FileWriter file = new FileWriter(Globais.path, true);
            BufferedWriter buff = new BufferedWriter(file);

            buff.write(p.toString() + "\n");
            buff.close();
            file.close();
            System.out.println("Pessoa Cadastrada com sucesso!");
        }catch (FileNotFoundException e){
            System.err.println("Pessoa não cadastrada...");
            System.out.println("O caminho não existe. Confirme se a pasta ../Log/ foi criada!");


        }catch (IOException e) {
            System.err.println("Pessoa não cadastrada...");
            System.out.println("##ERRO INESPERADO##:\n" + e);
        }

    }
    public static void readArquive(){

        try{
            FileReader file = new FileReader(Globais.path);
            BufferedReader buff = new BufferedReader(file);

            String row = "";
            while((row = buff.readLine()) != null){
                Log l = new Log(row);
                l.Print();
                System.out.println("--------------------------------------------------");
            }

            buff.close();
            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado!!");
        } catch (IOException e) {
            System.err.println("Erro inesperado!\n" + e);
        }
    }
}
