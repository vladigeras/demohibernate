package ru.vladigeras.demohibernate.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

	@Test
	void addItem() {
		Order order = new Order();
		Item item = new Item("Mi Notebook Pro", "Конкурент MacBook Pro");
		order.addItem(item);

		assertEquals(1, order.getItems().size());
	}

	@Test
	void removeItem() {
		Order order = new Order();
		Item item = new Item("Mi Notebook Pro", "Конкурент MacBook Pro");
		order.addItem(item);
		order.removeItem(item);

		assertEquals(0, order.getItems().size());
	}

	@Test
	void addNullItem() {
		Order order = new Order();
		order.addItem(null);

		assertEquals(0, order.getItems().size());
	}

	@Test
	void removeNullItem() {
		Order order = new Order();
		Item item = new Item("Mi Notebook Pro", "Конкурент MacBook Pro");
		order.addItem(item);
		order.removeItem(null);

		assertEquals(1, order.getItems().size());
	}
}