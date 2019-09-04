package fr.formation.financings.services;

import fr.formation.financings.dtos.ClientDto;
import fr.formation.financings.entities.Client;
import fr.formation.financings.entities.Contact;
import fr.formation.financings.entities.LegalForm;
import fr.formation.financings.repositories.ClientRepository;
import fr.formation.financings.repositories.ContactRepository;

public class ClientServiceImpl implements ClientService {

    private final ContactRepository contactRepo;

    private final ClientRepository clientRepo;

    protected ClientServiceImpl(ContactRepository contactRepo,
	    ClientRepository clientRepo) {
	this.contactRepo = contactRepo;
	this.clientRepo = clientRepo;
    }

    @Override
    public void create(ClientDto dto) {
	// Convert dto to entity Client
	Client client = new Client();
	String name = dto.getName();
	client.setName(name);
	LegalForm legalForm = dto.getLegalForm();
	client.setLegalForm(legalForm);
	Contact contact = contactRepo.getOne(dto.getContactId());
	client.setContact(contact);
	clientRepo.save(client);
    }

    @Override
    public void delete(Long id) {
	// TODO Auto-generated method stub
    }

    @Override
    public Client getOne(Long id) {
	// TODO Auto-generated method stub
	return null;
    }
}
