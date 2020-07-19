/**
 * 
 */
package com.jack.data.mongo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Jaikishan Gurav
 *
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomerRepositoryIntegrationTest2 {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void customerSavedAndGetId() {
		Customer customer = customerRepository.save(new Customer("Jack", "Sparrow"));
		assertThat(customer.getId()).isNotNull();
		assertThat(customer.getFirstName()).isEqualTo("Jack");
		assertThat(customer.getLastName()).isEqualTo("Sparrow");
	}

}
