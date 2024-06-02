package sample.license.service;

import java.util.Locale;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import sample.license.model.License;

@RequiredArgsConstructor
@Service
public class LicenseService {

  private final MessageSource messages;

  public License getLicense(String licenseId, String organizationId) {
    int id = new Random().nextInt(1000);
    String description = "Software product";
    String productName = "Ostock";
    String licenseType = "full";

    return License.builder()
        .id(id)
        .licenseId(licenseId)
        .organizationId(organizationId)
        .description(description)
        .productName(productName)
        .licenseType(licenseType)
        .build();
  }

  public String createLicense(License license, String organizationId, Locale locale) {
    if (license == null) {
      return null;
    }

    license.setOrganizationId(organizationId);
    return String.format(
        messages.getMessage("license.create.message", null, locale),
        license);
  }

  public String updateLicense(License license, String organizationId, Locale locale) {
    if (license == null) {
      return null;
    }

    license.setOrganizationId(organizationId);
    return String.format(
        messages.getMessage("license.update.message", null, locale),
        license);
  }

  public String deleteLicense(String licenseId, String organizationId) {
    return String.format(
        messages.getMessage("license.delete.message", null, null),
        licenseId, organizationId);
  }

}
