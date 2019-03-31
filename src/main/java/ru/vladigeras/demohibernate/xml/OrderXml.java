package ru.vladigeras.demohibernate.xml;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vladi_geras on 26.03.2019
 */
public class OrderXml {
	private Long id;
	private LocalDateTime creationDate = LocalDateTime.now(ZoneOffset.UTC);
	private CustomerXml customer;
	private Set<ItemXml> items = new HashSet<>();

	public void addItem(ItemXml item) {
		if (item != null) {
			this.items.add(item);
		}
	}

	public void removeItem(ItemXml item) {
		this.items.remove(item);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public CustomerXml getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerXml customer) {
		this.customer = customer;
	}

	public Set<ItemXml> getItems() {
		return items;
	}

	public void setItems(Set<ItemXml> items) {
		this.items = items;
	}
}
