package ru.vladigeras.demohibernate.xml;

import java.util.HashSet;
import java.util.Set;

/**
 * @author vladi_geras on 26.03.2019
 */
public class CustomerXml {
	private Long id;
	private String firstname;
	private String lastname;
	private Set<OrderXml> orders = new HashSet<>();

	public CustomerXml() {
	}

	public CustomerXml(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public void addOrder(OrderXml order) {
		if (order != null) {
			order.setCustomer(this);
			this.orders.add(order);
		}
	}

	public void removeOrder(OrderXml order) {
		this.orders.remove(order);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<OrderXml> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderXml> orders) {
		this.orders = orders;
	}

	public String toString() {
		return "Customer{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", orders=" + orders +
				'}';
	}
}
