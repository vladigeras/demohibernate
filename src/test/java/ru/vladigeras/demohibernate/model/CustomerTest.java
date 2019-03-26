package ru.vladigeras.demohibernate.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

	@Test
	void addOrder() {
		Customer customer = new Customer("Иванов", "Иван");
		customer.addOrder(new Order());

		assertEquals(1, customer.getOrders().size());
	}

	@Test
	void removeOrder() {
		Customer customer = new Customer("Иванов", "Иван");
		Order order = new Order();
		customer.addOrder(order);
		customer.removeOrder(order);

		assertEquals(0, customer.getOrders().size());
	}

	@Test
	void addNullOrder() {
		Customer customer = new Customer("Иванов", "Иван");
		customer.addOrder(null);

		assertEquals(0, customer.getOrders().size());
	}

	@Test
	void removeNullOrder() {
		Customer customer = new Customer("Иванов", "Иван");
		Order order = new Order();
		customer.addOrder(order);
		customer.removeOrder(null);

		assertEquals(1, customer.getOrders().size());
	}
}