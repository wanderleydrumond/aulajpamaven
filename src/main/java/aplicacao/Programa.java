package aplicacao;

import dominio.Pessoa;

public class Programa {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa(1, "Carlos da Silva", "carlos@email.com");
        Pessoa pessoa2 = new Pessoa(2, "Joaquim Torres", "joaquim@email.com");
        Pessoa pessoa3 = new Pessoa(3, "Ana Maria", "ana@email.com");

        System.out.println(pessoa1 + "\n"+ pessoa2 + "\n" + pessoa3);
    }
}