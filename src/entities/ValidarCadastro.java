package entities;

import java.util.List;

public class ValidarCadastro {

    public static void validarNome(String nome)throws ProgramException.NomeInvalidoException{
        if (nome.length() < 10) {
            throw new ProgramException.NomeInvalidoException("O nome deve ter no mínimo 10 caracteres.");
        }
    }

    public static void validarEmail(String email, List<Usuario> usuarios) throws ProgramException.EmailInvalidoException, ProgramException.EmailDuplicadoException {
        if (!email.contains("@")) {
            throw new ProgramException.EmailInvalidoException("O e-mail deve conter o caractere '@'.");
        }
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                throw new ProgramException.EmailDuplicadoException("O e-mail já está cadastrado.");
            }
        }
    }

    public static void validarIdade(int idade) throws ProgramException.IdadeInvalidaException {
        if (idade < 18) {
            throw new ProgramException.IdadeInvalidaException("O usuário deve ter mais de 18 anos.");
        }
    }


}
