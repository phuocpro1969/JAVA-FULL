package greenacademy.sample_annotation;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			  if (sessionFactory == null)
		         {
		            AnnotationConfiguration configuration = new AnnotationConfiguration().addAnnotatedClass(Person.class).addAnnotatedClass(Email.class).addResource("hibernate.cfg.xml").configure();
		            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		            serviceRegistryBuilder.applySettings(configuration.getProperties());
		            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		         }
		         return sessionFactory;
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
