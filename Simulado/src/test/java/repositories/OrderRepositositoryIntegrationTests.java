package repositories;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Repository.OrederRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class OrderRepositositoryIntegrationTests {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    private static OrederRepository orederRepository;

    private final  Faker faker = new Faker();


    @BeforeAll
    public static void  setUp(){
        entityManagerFactory = Persistence.createEntityManagerFactory("oracle");
        entityManager = entityManagerFactory.createEntityManager();
        orederRepository = new  OrederRepository(entityManager);
    }

    @Test
    @Order(1)
    public void testCreatValidOrder(){

        var order = new Order();
        var customerId faker.number().numberBetween(0,99);
        order.setCus
    }
}
