package fr.formation.financings.services;

import org.springframework.stereotype.Service;

import fr.formation.financings.dtos.FinancingDto;
import fr.formation.financings.entities.Client;
import fr.formation.financings.entities.Financing;
import fr.formation.financings.repositories.ClientRepository;
import fr.formation.financings.repositories.FinancingRepository;

@Service
public class FinancingServiceImpl implements FinancingService {

    private final FinancingRepository financingRepo;

    private final ClientRepository clientRepo;

    protected FinancingServiceImpl(FinancingRepository financingRepo,
	    ClientRepository clientRepo) {
	this.financingRepo = financingRepo;
	this.clientRepo = clientRepo;
    }

    @Override
    public void create(FinancingDto dto) {
	// Convert dto to entity:
	Financing financing = new Financing();
	popAndSave(dto, financing);
    }

    @Override
    public void update(FinancingDto dto, Long id) {
	// Convert dto to entity:
	Financing financing = financingRepo.findById(id).get();
	popAndSave(dto, financing);
    }

    private void popAndSave(FinancingDto dto, Financing financing) {
	financing.setName(dto.getName());
	financing.setAmount(dto.getAmount());
	financing.setReference(dto.getReference());
	financing.setRate(dto.getRate());
	financing.setStartDate(dto.getStartDate());
	financing.setEndDate(dto.getEndDate());
	// Financing needs a Client object, not an id:
	Client client = clientRepo.getOne(dto.getClientId());
	financing.setClient(client);
	financingRepo.save(financing);
    }

    @Override
    public void delete(Long id) {
	financingRepo.deleteById(id);
    }

    @Override
    public Financing getOne(Long id) {
	return financingRepo.findById(id).get();
    }
}
