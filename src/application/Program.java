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
        form.atualizarIdAtual();

        int selectMenu;
        String cont;

        do {

            System.out.println("\n=================");
            System.out.println("\nMENU");
            System.out.print("1 - Cadastrar o usuário\n" +
                    "2 - Listar todos usuários cadastrados\n" +
                    "3 - Cadastrar nova pergunta no formulário\n" +
                    "4 - Deletar pergunta do formulário\n" +
                    "5 - Pesquisar usuário por nome ou idade ou email\n");
            selectMenu = sc.nextInt();

            while(selectMenu > 5 || selectMenu < 1){
                System.out.print("Item invalido, tente novamente: ");
                selectMenu = sc.nextInt();
            }

            switch (selectMenu){
                case 1:
                    System.out.println("\nCadastrar novo usuario: ");
                    Usuario user = form.cadastrarUsuario();
                    System.out.println(user);
                    form.novoFormulario(user);
                    sc.nextLine();
                    break;
                case 2:
                    form.lerCadastrados();
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Digite a pergunta: ");
                    sc.nextLine();
                    String novaPergunta = sc.nextLine();
                    form.adicionarPergunta(novaPergunta);
                    form.salvarFormularioPerguntas();
                    break;
                case 4:
                    System.out.print("Digite o indice da pergunta que quer deletar: ");
                    int indiceDeletar = sc.nextInt();
                    form.deletarPergunta(indiceDeletar);
                    form.salvarFormularioPerguntas();
                    sc.nextLine();
                    break;
                case 5:
                    System.out.print("Digite o termo de busca: ");
                    sc.nextLine();
                    String termobusca = sc.nextLine();
                    form.pesquisarUsuario(termobusca);
                    form.printUsuariosEncontrados();
                    //form.lerUsuarios();
                    break;
            }

            System.out.println("Deseja continuar? (S/N)");
            cont = sc.nextLine().toLowerCase();

        } while (cont.equals("s"));
    }
}
