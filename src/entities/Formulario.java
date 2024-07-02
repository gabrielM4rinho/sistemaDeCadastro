package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Usuario;

public class Formulario {

    private List<String> perguntas;
    private int idAtual = 1;

    public Formulario() {

    }

    public Formulario(int idAtual, List<String> perguntas) {
        this.idAtual = 1;
        this.perguntas = new ArrayList<>();
    }

    protected String path = "C:\\Users\\marin\\Desafio - Sistema de Cadastro\\formulario.txt";
    protected String path2 = null;

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

    public Usuario cadastrarUsuario() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        System.out.print("Altura: ");
        double altura = scanner.nextDouble();

        path2 = "C:\\Users\\marin\\Desafio - Sistema de Cadastro\\" + idAtual + " - " + nome.replaceAll(" ", "").toUpperCase() + ".txt";

        return new Usuario(nome, email, idade, altura);
    }

    public void novoFormulario(Usuario usuario){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path2))){
            bw.write(usuario.toString());
        }
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        idAtual++;
    }
}