package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa(null, "Carlos da Silva", "carlos@email.com");
        Pessoa pessoa2 = new Pessoa(null, "Joaquim Torres", "joaquim@email.com");
        Pessoa pessoa3 = new Pessoa(null, "Ana Maria", "ana@email.com");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(pessoa1);
        entityManager.persist(pessoa2);
        entityManager.persist(pessoa3);
        entityManager.getTransaction().commit();

        System.out.println(pessoa1 + "\n"+ pessoa2 + "\n" + pessoa3 + "\n\nCadastrados com sucesso!");
        entityManager.close();
        entityManagerFactory.close();
    }
}