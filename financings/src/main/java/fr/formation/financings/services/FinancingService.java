package fr.formation.financings.services;

import fr.formation.financings.dtos.FinancingDto;
import fr.formation.financings.entities.Financing;

public interface FinancingService {

    void create(FinancingDto dto);

    void delete(Long id);

    Financing getOne(Long id);

    void update(FinancingDto dto, Long id);
}
