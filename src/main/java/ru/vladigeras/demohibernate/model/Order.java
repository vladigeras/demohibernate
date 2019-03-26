package ru.vladigeras.demohibernate.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vladi_geras on 26.03.2019
 */
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "creation_date")
	private LocalDateTime creationDate = LocalDateTime.now(ZoneOffset.UTC);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "orders_items",
			joinColumns = @JoinColumn(name = "order_id"),
			inverseJoinColumns = @JoinColumn(name = "item_id"))
	private Set<Item> items = new HashSet<>();

	public void addItem(Item item) {
		if (item != null) {
			this.items.add(item);
		}
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Item> getItems() {
		return items;
	}
}
