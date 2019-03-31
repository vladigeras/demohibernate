package ru.vladigeras.demohibernate.xml;

import java.util.HashSet;
import java.util.Set;

/**
 * @author vladi_geras on 26.03.2019
 */
public class ItemXml {
	private Long id;
	private String title;
	private String description;
	private Set<OrderXml> orders = new HashSet<>();

	public ItemXml() {
	}

	public ItemXml(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public void addToOrder(OrderXml order) {
		if (order != null) {
			order.addItem(this);
			this.orders.add(order);
		}
	}

	public void removeFromOrder(OrderXml order) {
		if (order != null) {
			order.removeItem(this);
			this.orders.remove(order);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<OrderXml> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderXml> orders) {
		this.orders = orders;
	}
}
