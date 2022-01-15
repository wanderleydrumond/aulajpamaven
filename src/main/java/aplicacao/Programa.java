package aplicacao;

import dominio.Pessoa;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;

public class Programa {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        inserirPessoas(entityManager);

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void inserirPessoas(@NotNull EntityManager entityManager) {
        Pessoa pessoa1 = new Pessoa(null, "Carlos da Silva", "carlos@email.com"),
               pessoa2 = new Pessoa(null, "Joaquim Torres", "joaquim@email.com"),
               pessoa3 = new Pessoa(null, "Ana Maria", "ana@email.com");
        ArrayList<Pessoa> pessoas = new ArrayList<>(Arrays.asList(pessoa1, pessoa2, pessoa3));

        entityManager.getTransaction().begin();
        pessoas.forEach(entityManager::persist);
        entityManager.getTransaction().commit();

        pessoas.forEach(System.out::println);
    }
}