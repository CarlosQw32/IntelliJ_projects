package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.example.Repository.OrederRepository;
import org.example.entities.Order;

public class Main {
    public static void main(String[] args) throws Exception {
        var entityManagerFactory = Persistence.createEntityManagerFactory("oracle");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //var orderRepository = new OrederRepository(entityManager);

        var jpql = "Select * from Order_pedido ";
        var querry = entityManager.createNativeQuery(jpql, Order.class);
        var Order = querry.getResultList();


    }


}