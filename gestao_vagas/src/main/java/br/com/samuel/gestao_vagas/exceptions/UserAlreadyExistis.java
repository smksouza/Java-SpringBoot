package br.com.samuel.gestao_vagas.exceptions;

public class UserAlreadyExistis extends RuntimeException {
    public UserAlreadyExistis() {
        super("Usuário já existe");
    }
}
