package ru.vladigeras.demohibernate.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author vladi_geras on 26.03.2019
 */
public class HibernateSessionFactory {
	private static SessionFactory sessionFactory;

	private HibernateSessionFactory() {
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure();
//			configuration.addAnnotatedClass(Customer.class);
//			configuration.addAnnotatedClass(Order.class);
//			configuration.addAnnotatedClass(Item.class);

			configuration.addResource("CustomerXml.hbm.xml");
			configuration.addResource("ItemXml.hbm.xml");
			configuration.addResource("OrderXml.hbm.xml");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}