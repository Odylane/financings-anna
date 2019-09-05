package fr.formation.financings.services;

import org.springframework.stereotype.Service;

import fr.formation.financings.dtos.ContactDto;
import fr.formation.financings.entities.Contact;
import fr.formation.financings.entities.ContactInfo;
import fr.formation.financings.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepo;

    protected ContactServiceImpl(ContactRepository contactRepository) {
	this.contactRepo = contactRepository;
    }

    @Override
    public void create(ContactDto dto) {
	Contact contact = new Contact();
	contact.setFirstName(dto.getFirstName());
	contact.setLastName(dto.getLastName());
	ContactInfo contactInfo = new ContactInfo();
	contactInfo.setEmail(dto.getEmail());
	contactInfo.setMobile(dto.getMobile());
	contactInfo.setPhone(dto.getPhone());
	contact.setInfo(contactInfo);
	contactRepo.save(contact);
    }
}
