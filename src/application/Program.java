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

        form.lerFormulario();

        System.out.println("\nCadastrar novo usuario: ");
        Usuario user = form.cadastrarUsuario();
        System.out.println(user);
        form.novoFormulario(user);
    }
}
