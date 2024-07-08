package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Usuario;

public class Formulario {

    private List<String> perguntas;
    private Integer idAtual =1;

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

    public void atualizarIdAtual(){
        File pathFile = new File("C:\\Users\\marin\\Desafio - Sistema de Cadastro");
        File[] cadastrados = pathFile.listFiles();
        for (int i =0; i < cadastrados.length; i++){
            File file = cadastrados[i];
            if(Character.isDigit(file.getName().charAt(0))){
                char primeiroChar = file.getName().charAt(0);
                int valorId = Character.getNumericValue(primeiroChar);
                idAtual = valorId + 1;
            }
        }

    }

    public void lerCadastrados(){

        File pathFile = new File("C:\\Users\\marin\\Desafio - Sistema de Cadastro");
        File[] cadastrados = pathFile.listFiles();
        for (int i =0; i < cadastrados.length; i++){
            File file = cadastrados[i];
            if(file.isFile() && !file.getName().equals("formulario.txt") && file.getName().endsWith(".txt")){
                System.out.println(file.getName().replaceAll(".txt", ""));
            }
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