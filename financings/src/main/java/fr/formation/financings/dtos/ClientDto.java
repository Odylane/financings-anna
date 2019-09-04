package fr.formation.financings.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.formation.financings.entities.LegalForm;

public class ClientDto {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    private LegalForm legalForm;

    private Long contactId;

    public ClientDto() {
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

    public Long getContactId() {
	return contactId;
    }

    public void setContactId(Long contactId) {
	this.contactId = contactId;
    }
}
