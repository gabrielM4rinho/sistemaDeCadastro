package entities;

public class ProgramException extends RuntimeException{

    public static final long serialVersionUID = 1;

    public ProgramException(String msg) {super(msg);}

    public static class NomeInvalidoException extends Exception {
        public NomeInvalidoException(String message) {
            super(message);
        }
    }

    public static class EmailInvalidoException extends Exception {
        public EmailInvalidoException(String message) {
            super(message);
        }
    }

    public static class IdadeInvalidaException extends Exception {
        public IdadeInvalidaException(String message) {
            super(message);
        }
    }

    public static class AlturaInvalidaException extends Exception {
        public AlturaInvalidaException(String message) {
            super(message);
        }
    }

    public static class EmailDuplicadoException extends Exception {
        public EmailDuplicadoException(String message) {
            super(message);
        }
    }
}
