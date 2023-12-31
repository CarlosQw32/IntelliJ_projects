package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.Genre;


public class GenreRepository extends JpaRepository<Genre>{
    public GenreRepository(EntityManager entityManager, Class<Genre> entityType) {
        super(entityManager, entityType);
    }
}
