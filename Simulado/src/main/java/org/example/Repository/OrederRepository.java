package org.example.Repository;

import jakarta.persistence.EntityManager;
import org.example.entities.Order;

import java.util.List;

public class OrederRepository {

    EntityManager entityManager;

    public OrederRepository(EntityManager entityManager){this.entityManager=entityManager;}

    public List<Order> GetAllOrders(){
        var jpql = "Select a from order a";
        var query = entityManager.createQuery(jpql,Order.class);
        return query.getResultList();
    }


}
