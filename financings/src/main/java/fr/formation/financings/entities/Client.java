package fr.formation.financings.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 4, nullable = false)
    private LegalForm legalForm;

    // @OneToMany // One Client to Many Contact
    // @OneToMany: Many Contact to One Client
    @ManyToOne // One Client to One Contact
    // Many Client to One Contact
    // @ManyToOne: One Contact to Many Client
    private Contact contact;

    public Client() {
	// TODO Auto-generated constructor stub
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public LegalForm getLegalForm() {
	return legalForm;
    }

    public void setLegalForm(LegalForm legalForm) {
	this.legalForm = legalForm;
    }

    public Contact getContact() {
	return contact;
    }

    public void setContact(Contact contact) {
	this.contact = contact;
    }
}
