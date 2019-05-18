package greenacademy.sample_annotation;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class Hibernate {
	public static void main(String[] args) {
	
			Set<Email> emails = new HashSet<Email>();
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			session.beginTransaction();
			
			Person person = new Person();
			person.setFirstname("Phan");
			person.setLastname("Phuoc");
			person.setBirthday(new Date());
			session.save(person);
			
			Email emailFirst = new Email();
			emailFirst.setEmails("17520918@gm.uit.edu.vn");
			emailFirst.setPersonE(person);
			
			emails.add(emailFirst);
			person.setEmail(emails);
			session.save(emailFirst);
			
			session.getTransaction().commit();
	}
}