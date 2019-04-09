package ru.vladigeras.demohibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.vladigeras.demohibernate.configuration.HibernateSessionFactory;
import ru.vladigeras.demohibernate.model.Customer;
import ru.vladigeras.demohibernate.model.Item;
import ru.vladigeras.demohibernate.model.Order;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

/**
 * @author vladi_geras on 26.03.2019
 */
public class Client {
	public static void main(String[] args) {
	}

	public static void addNewOrder(Customer customer, Set<Item> items) {
		Transaction transaction = null;
		try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(customer);
			items.forEach(session::save);
			session.save(new Order(customer, items));

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public static void getAllOrders() {
		try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

			CriteriaQuery<Order> orderCriteriaQuery = criteriaBuilder.createQuery(Order.class);
			Root<Order> orderRoot = orderCriteriaQuery.from(Order.class);
			orderCriteriaQuery.select(orderRoot);

			Query<Order> query = session.createQuery(orderCriteriaQuery);

			List<Order> orders = query.list();

			orders.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getItemsByTitle(String title) {
		try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

			CriteriaQuery<Item> itemCriteriaQuery = criteriaBuilder.createQuery(Item.class);
			Root<Item> itemRoot = itemCriteriaQuery.from(Item.class);
			itemCriteriaQuery
					.select(itemRoot)
					.where(criteriaBuilder.equal(itemRoot.get("title"), title))
					.orderBy(criteriaBuilder.asc(itemRoot.get("description")));

			Query<Item> query = session.createQuery(itemCriteriaQuery);

			List<Item> items = query.list();

			items.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getOrderByCustomerName(String name) {
		try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

			Query query = session.createQuery("FROM Order o WHERE o.customer.firstname = :name")
					.setParameter("name", name);

			List<Order> orders = (List<Order>) query.list();

			orders.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
