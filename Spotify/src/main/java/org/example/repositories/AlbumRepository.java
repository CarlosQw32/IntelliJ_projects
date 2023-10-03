package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.Album;

import java.util.List;
import java.util.Optional;

public class AlbumRepository {

    EntityManager entityManager;

    public AlbumRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Album> GetAllAlbums(){
        var jpql = "SELECT a FROM Album a";
        var query =entityManager.createQuery(jpql, Album.class);
        return  query.getResultList();

        /*return  entityManager.createQuery(jpql, Album.class).getResultList();*/
    }

    public Optional<Album> GetAlbumById(int id){
        var jpql = "SELECT a FROM Album WHERE a.id :id";
        var query = entityManager.createQuery(jpql, Album.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    public  void InsertAlbum(Album album){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(album);
            entityManager.getTransaction().commit();

        }
        catch (Exception e)
        {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public  void updateAlbum(Album album){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(album);
            entityManager.getTransaction().commit();

        }
        catch (Exception e)
        {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public  void deleteAlbum(int id){
        try{
            var album = GetAlbumById(id);
            if(album.isPresent()) {
                entityManager.getTransaction().begin();
                entityManager.remove(album);
                entityManager.getTransaction().commit();
            }
        }
        catch (Exception e)
        {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
