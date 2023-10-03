package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.example.entities.Genre;
import org.example.repositories.AlbumRepository;

public class Main {public static void main(String[] args) throws Exception {
    var entityManagerFactory = Persistence.createEntityManagerFactory( "default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    var albumRepository = new AlbumRepository(entityManager);

    var jpql = "select u from Genre u";
    var querry = entityManager.createQuery(jpql, Genre.class);
    var genres = querry.getResultList();

    var sql = "Select * from Genre";
    var querryNative = entityManager.createNativeQuery(jpql, Genre.class);
    var genereNative = querry.getResultList();
    System.out.println("Concluído");
}
}