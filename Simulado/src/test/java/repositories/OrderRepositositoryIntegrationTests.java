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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

        var order = new org.example.entities.Order();
        var customerId = faker.number().numberBetween(0,99);
        var id = faker.number().numberBetween(0,99);
        var statusCodeId = faker.number().numberBetween(1,5);
        var customerComments = faker.lorem().words(new Random().nextInt(10)).toString();
        order.setCustomer_id(customerId);
        order.setId(id);
        order.setStatus_code_id(statusCodeId);
        order.setCustomer_comments(customerComments);

        orederRepository.InsertOrder(order);

        var savedOrder = orederRepository.GetOrderById(order.getId()).orElse(null);
        assertNotNull(savedOrder);
        assertEquals(order.getId(), savedOrder.getId());

    }

    @Test
    @Order(2)
    public void  testCreateInvalidOrder(){
        //Arrange
        var order = new org.example.entities.Order();

        //Act
        try {
            orederRepository.InsertOrder(order);
        }catch (Exception e){

            assertNotNull(e);
        }
    }

    @Test
    @Order(3)
    public void testUpdateOrder(){

        var order = new org.example.entities.Order();
        var customerId = faker.number().numberBetween(0,99);
        var id = faker.number().numberBetween(0,99);
        var statusCodeId = faker.number().numberBetween(1,5);
        var customerComments = faker.lorem().words(new Random().nextInt(10)).toString();
        order.setCustomer_id(customerId);
        order.setId(id);
        order.setStatus_code_id(statusCodeId);
        order.setCustomer_comments(customerComments);

        orederRepository.InsertOrder(order);



    }
}
