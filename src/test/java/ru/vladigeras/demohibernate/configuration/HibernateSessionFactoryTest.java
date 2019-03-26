package ru.vladigeras.demohibernate.configuration;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HibernateSessionFactoryTest {

	@Test
	void getSessionFactoryReturnNotNull() {
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		assertNotEquals(null, sessionFactory);
	}

	@Test()
	void getSessionFactoryNotThrowException() {
		assertDoesNotThrow((Executable) HibernateSessionFactory::getSessionFactory);
	}
}