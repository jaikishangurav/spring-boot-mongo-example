/**
 * 
 */
package com.jack.data.mongo;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * @author Jaikishan Gurav
 *
 */
@Testcontainers
public class MongoDBContainerTest {

	@Container
	private final MongoDBContainer mongoDBContainer = new MongoDBContainer();

	@Test
	@DisplayName("Should start the container")
	public void test() {
		Assert.assertTrue(mongoDBContainer.isRunning());
	}

}
