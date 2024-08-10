package entities;

import java.io.*;
import java.util.*;

import entities.Usuario;

public class Formulario {

    private Integer idAtual = 1;
    private Integer idPergunta = 4;
    private List<String> pergunta = new ArrayList<>();

    public Formulario() {

    }

    public Formulario(int idAtual) {
        this.idAtual = 1;
    }

    protected String path = "C:\\Users\\marin\\Desafio - Sistema de Cadastro\\formulario.txt";
    protected String path2 = null;

    public void lerFormulario(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while (line != null){
                pergunta.add(line);
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void adicionarPergunta(String novaPergunta){
        atualizarIdPergunta();
        pergunta.add(idPergunta + " - " + novaPergunta);
        System.out.println("Pergunta adicionada!");
    }

    public void deletarPergunta(int indice){
        if(indice - 1 < 4){
            System.out.println("Não é possível deletar as 4 primeiras perguntas");
        } else if(indice - 1 <= pergunta.size() - 1){
            pergunta.remove(indice - 1);
            System.out.println("Pergunta removida!");
        } else{
            System.out.println("Índice inválido");
        }
    }

    public void salvarFormularioPerguntas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String perguntas : pergunta){
                bw.write(perguntas);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void atualizarIdPergunta(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while (line != null){
                if(Character.isDigit(line.charAt(0))){
                    char primeiroChar = line.charAt(0);
                    int valorId = Character.getNumericValue(primeiroChar);
                    idPergunta = valorId + 1;
                }
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
                String nomeArquivo = file.getName();
                String[] partes = nomeArquivo.split(" ");
                if(partes.length > 0){
                    try{
                        int valorId = Integer.parseInt(partes[0]);
                        if(valorId >= idAtual){
                            idAtual = valorId + 1;
                        }
                    }
                    catch (NumberFormatException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
                /* char primeiroChar = file.getName().charAt(0);
                int valorId = Character.getNumericValue(primeiroChar);
                idAtual = valorId + 1;*/
            }
        }
    }

    public void lerCadastrados(){

        File pathFile = new File("C:\\Users\\marin\\Desafio - Sistema de Cadastro");
        File[] cadastrados = pathFile.listFiles((dir, name) -> name.endsWith(".txt") && !name.equals("formulario.txt"));

        Arrays.sort(cadastrados, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int id1 = Integer.parseInt(o1.getName().split(" ")[0]);
                int id2 = Integer.parseInt(o2.getName().split(" ")[0]);
                return Integer.compare(id1, id2);
            }
        });

        for (File file : cadastrados){
            System.out.println(file.getName().replaceAll(".txt", ""));
        }

        /*if(cadastrados)
        for (int i =0; i < cadastrados.length; i++){
            File file = cadastrados[i];
            if(file.isFile() && !file.getName().equals("formulario.txt") && file.getName().endsWith(".txt")){
                System.out.println(file.getName().replaceAll(".txt", ""));
            }
        } */
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

        path2 = "C:\\Users\\marin\\Desafio - Sistema de Cadastro\\" + idAtual + " - " + nome.toUpperCase() + ".txt";

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

    public void pesquisarUsuario(String termoBusca){
        File pathFile = new File("C:\\Users\\marin\\Desafio - Sistema de Cadastro");
        File[] cadastrados = pathFile.listFiles((dir, name) -> name.endsWith(".txt") && !name.equals("formulario.txt"));
        List<File> encontrados = new ArrayList<>();

        for(File file : cadastrados){
            String nomeSemExtensao = file.getName().replaceAll(".txt", " ").split("-")[1].toLowerCase();
            if(nomeSemExtensao.contains(termoBusca.toLowerCase())){
                encontrados.add(file);
            }
        }

        /*encontrados.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String nome1 = o1.getName().split("-")[1].toLowerCase();
                String nome2 = o2.getName().split("-")[1].toLowerCase();
                return nome1.compareTo(nome2);
            }
        });*/

        encontrados.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int id1 = Integer.parseInt(o1.getName().split(" ")[0]);
                int id2 = Integer.parseInt(o2.getName().split(" ")[0]);
                return Integer.compare(id1, id2);
            }
        });

        if(encontrados.isEmpty()){
            System.out.println("Nenhum usuário encontrado com o termo: " + termoBusca);
        } else{
            System.out.println("Usuarios encontrados: ");
            for(File file : encontrados){
                System.out.println(file.getName().replaceAll(".txt", ""));
            }
        }
    }
}