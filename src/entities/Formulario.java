package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Formulario {

    protected String path = "C:\\Users\\marin\\Desafio - Sistema de Cadastro\\formulario.txt";

    public void lerFormulario(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }



}
