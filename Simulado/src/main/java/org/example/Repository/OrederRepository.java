package org.example.Repository;

import jakarta.persistence.EntityManager;
import org.example.entities.Order;

import java.util.List;
import java.util.Optional;

public class OrederRepository {

    EntityManager entityManager;

    public OrederRepository(EntityManager entityManager){this.entityManager=entityManager;}

    public List<Order> GetAllOrders(){
        var jpql = "Select a from order a";
        var query = entityManager.createQuery(jpql,Order.class);
        return query.getResultList();
    }

    public Optional<Order> GetOrderById(long id){
        return Optional.ofNullable(entityManager.find(Order.class,id));
    }

    public void InsertOrder(Order order){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(order);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void UpdateOrder(Order order){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(order);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void DelteOrder(long id){
        try {
            var order = GetOrderById(id);
            if (order.isPresent()){
                entityManager.getTransaction().begin();
                entityManager.remove(order);
                entityManager.getTransaction().commit();
            }
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }


}
