package ru.vladigeras.demohibernate.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.vladigeras.demohibernate.model.Customer;
import ru.vladigeras.demohibernate.model.Item;
import ru.vladigeras.demohibernate.model.Order;

/**
 * @author vladi_geras on 26.03.2019
 */
public class HibernateSessionFactory {
	private static SessionFactory sessionFactory;

	private HibernateSessionFactory() {
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration().configure();

				configuration.addAnnotatedClass(Customer.class);
				configuration.addAnnotatedClass(Order.class);
				configuration.addAnnotatedClass(Item.class);

				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				sessionFactory = configuration.buildSessionFactory(builder.build());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}