package sample.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.organization.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String> {

}
