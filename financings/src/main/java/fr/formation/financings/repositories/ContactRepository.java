package fr.formation.financings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.financings.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    //
}
