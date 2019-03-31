package ru.vladigeras.demohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.vladigeras.demohibernate.configuration.HibernateSessionFactory;
import ru.vladigeras.demohibernate.xml.CustomerXml;

/**
 * @author vladi_geras on 26.03.2019
 */
public class Client {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CustomerXml customer = new CustomerXml("Владислав", "Герасимов");
		session.save(customer);
		transaction.commit();
		session.close();
	}
}
