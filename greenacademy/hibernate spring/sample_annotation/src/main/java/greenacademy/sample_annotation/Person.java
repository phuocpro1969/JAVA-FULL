package greenacademy.sample_annotation;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "person", catalog = "person_email")

public class Person implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private long personid;
	private String firstname;
	private String lastname;
	private Date birthday;
	private Set<Email> email;

	public Person() {
	}
	
	public Person(String firstname, String lastname, Date birthday, Set<Email> email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PERSONID", unique = true, nullable = false)
	public long getPersonid() {
		return personid;
	}

	public void setPersonid(long personid) {
		this.personid = personid;
	}

	@Column(name = "FIRSTNAME", length = 20)
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "LASTNAME", length = 20)
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "BIRTHDAY")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@OneToMany(mappedBy = "personE", cascade = CascadeType.ALL )
	public Set<Email> getEmail() {
		return email;
	}
	
	public void setEmail(Set<Email> email) {
		this.email = email;
	}
}
