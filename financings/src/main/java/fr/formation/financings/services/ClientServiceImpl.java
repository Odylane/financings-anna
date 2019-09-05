package fr.formation.financings.services;

import org.springframework.stereotype.Service;

import fr.formation.financings.dtos.ClientDto;
import fr.formation.financings.entities.Client;
import fr.formation.financings.entities.Contact;
import fr.formation.financings.entities.LegalForm;
import fr.formation.financings.repositories.ClientRepository;
import fr.formation.financings.repositories.ContactRepository;

@Service
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
	populateAndSave(dto, client);
    }

    @Override
    public void update(ClientDto dto, Long id) {
	Client client = clientRepo.findById(id).get();
	populateAndSave(dto, client);
    }

    private void populateAndSave(ClientDto dto, Client client) {
	String name = dto.getName();
	client.setName(name);
	LegalForm legalForm = dto.getLegalForm();
	client.setLegalForm(legalForm);
	Contact contact = null;
	if (dto.getContactId() != null) {
	    contact = contactRepo.getOne(dto.getContactId());
	}
	client.setContact(contact);
	clientRepo.save(client);
    }

    @Override
    public void delete(Long id) {
	clientRepo.deleteById(id);
    }

    @Override
    public Client getOne(Long id) {
	return clientRepo.findById(id).get();
    }
}
