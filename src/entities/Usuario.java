package entities;

import entities.Formulario;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String email;
    private int idade;
    private double altura;

    private List<Formulario> novoFormulario = new ArrayList<>();

    public Usuario(String nome, String email, int idade, double altura) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void exibirInformacoes(){
        System.out.println(getNome() + "\n" + getEmail() + "\n" + getIdade() + "\n" + getAltura());
    }

    @Override
    public String toString() {
        return nome + "\n" + email + "\n" + idade + "\n" + altura;
    }

}
