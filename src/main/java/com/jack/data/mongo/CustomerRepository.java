/**
 * 
 */
package com.jack.data.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Jaikishan Gurav
 *
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByFirstName(String firstName);

	public List<Customer> findByLastName(String lastName);

}
