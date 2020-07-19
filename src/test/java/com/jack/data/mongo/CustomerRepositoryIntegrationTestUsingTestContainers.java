/**
 * 
 */
package com.jack.data.mongo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * @author Jaikishan Gurav
 *
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Testcontainers
public class CustomerRepositoryIntegrationTestUsingTestContainers {

	@Container
	final static MongoDBContainer mongoDBContainer = new MongoDBContainer();

	@Autowired
	CustomerRepository customerRepository;

	@BeforeAll
	public static void startContainer() {
		mongoDBContainer.start();
		System.out.println("***********Port : ******|| " + mongoDBContainer.getExposedPorts());

	}

	@Test
	public void customerSavedAndGetId() {
		Customer customer = customerRepository.save(new Customer("Jack", "Sparrow"));
		System.out.println(customer);
		assertThat(customer.getId()).isNotNull();
		assertThat(customer.getFirstName()).isEqualTo("Jack");
		assertThat(customer.getLastName()).isEqualTo("Sparrow");
	}

}
