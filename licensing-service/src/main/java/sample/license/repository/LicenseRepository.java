package sample.license.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.license.model.License;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {

  Optional<License> findByOrganizationIdAndLicenseId(String organizationId, String licenseId);

  long deleteByLicenseId(String licenseId);
}
