package sample.license.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import sample.license.model.License;
import sample.license.config.ServiceConfig;
import sample.license.model.Organization;
import sample.license.repository.LicenseRepository;
import sample.license.service.client.OrganizationFeignClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class LicenseService {

  private final MessageSource messages;
  private final LicenseRepository licenseRepository;
  private final ServiceConfig config;
  private final OrganizationFeignClient organizationFeignClient;

  public License getLicense(String licenseId, String organizationId) {
    License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId)
        .orElseThrow(
            () -> new IllegalArgumentException(String.format(messages.getMessage(
                "license.search.error.message", null, null), licenseId, organizationId)));

    retrieveOrganizationInfo(organizationId);

    return license.withComment(config.getProperty());
  }

  public License createLicense(License license, String organizationId) {
    license.setLicenseId(UUID.randomUUID().toString());
    licenseRepository.save(license);
    return license.withComment(config.getProperty());
  }

  public License updateLicense(License license) {
    licenseRepository.save(license);
    return license.withComment(config.getProperty());
  }

  public String deleteLicense(String licenseId) {
    licenseRepository.deleteByLicenseId(licenseId);
    String responseMessage = String.format(messages.getMessage(
        "license.delete.message", null, null), licenseId);
    return responseMessage;
  }

  private Organization retrieveOrganizationInfo(String organizationId) {
    return organizationFeignClient.getOrganization(organizationId);
  }


}
