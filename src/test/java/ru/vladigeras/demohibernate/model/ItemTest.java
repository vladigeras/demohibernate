package ru.vladigeras.demohibernate.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

	@Test
	void addToOrder() {
		Item item = new Item("Mi Notebook Pro", "Конкурент MacBook Pro");
		Order order = new Order();
		item.addToOrder(order);

		assertEquals(1, order.getItems().size());
		assertEquals(1, item.getOrders().size());
	}

	@Test
	void removeFromOrder() {
		Item item = new Item("Mi Notebook Pro", "Конкурент MacBook Pro");
		Order order = new Order();
		item.addToOrder(order);
		item.removeFromOrder(order);

		assertEquals(0, order.getItems().size());
		assertEquals(0, item.getOrders().size());
	}

	@Test
	void addToNullOrder() {
		Item item = new Item("Mi Notebook Pro", "Конкурент MacBook Pro");
		item.addToOrder(null);
		assertEquals(0, item.getOrders().size());
	}

	@Test
	void removeFromNullOrder() {
		Item item = new Item("Mi Notebook Pro", "Конкурент MacBook Pro");
		item.addToOrder(new Order());
		item.removeFromOrder(null);
		assertEquals(1, item.getOrders().size());
	}
}