package application;

import entities.Formulario;
import entities.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Formulario form = new Formulario();

        List<Usuario> user = new ArrayList<>();

        form.lerFormulario();

        System.out.println("Por gentileza, responde as perguntas na mesma ordem");
        System.out.print("1 -> ");
        String nome = sc.nextLine();
        System.out.print("2 -> ");
        String email = sc.nextLine();
        System.out.print("3 -> ");
        int idade = sc.nextInt();
        System.out.print("4 -> ");
        double altura = sc.nextDouble();

        user.add(new Usuario(nome, email, idade, altura));

        for (Usuario usuario : user){
            usuario.exibirInformacoes();
        }
    }
}
