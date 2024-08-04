package sample.organization.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.organization.model.Organization;
import sample.organization.repository.OrganizationRepository;

@Service
@RequiredArgsConstructor
public class OrganizationService {

  private final OrganizationRepository repository;

  public Organization findById(String organizationId) {
    Optional<Organization> opt = repository.findById(organizationId);
    return (opt.isPresent()) ? opt.get() : null;
  }

}