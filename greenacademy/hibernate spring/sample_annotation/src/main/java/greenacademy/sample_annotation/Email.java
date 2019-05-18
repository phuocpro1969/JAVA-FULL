package greenacademy.sample_annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "emails", catalog = "person_email")
public class Email implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String emails;
	private Person personE;
	
	public Email() {
	}
	
	
	public Email(long id, String emails, Person personE) {
		this.emails = emails;
		this.personE = personE;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "PERSONID")
	public Person getPersonE() {
		return personE;
	}
	

	public void setPersonE(Person person) {
		this.personE = person;
	}

	@Column(name = "EMAILS", length = 255)
	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}
}