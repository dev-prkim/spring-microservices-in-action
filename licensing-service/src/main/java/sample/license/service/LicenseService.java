package sample.license.service;

import java.util.Random;
import org.springframework.stereotype.Service;
import sample.license.model.License;

@Service
public class LicenseService {

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

  public String createLicense(License license, String organizationId) {
    if(license == null) {
      return null;
    }

    license.setOrganizationId(organizationId);
    return String.format("This is the post and the object is %s", license);
  }

  public String updateLicense(License license, String organizationId) {
    if(license == null) {
      return null;
    }

    license.setOrganizationId(organizationId);
    return String.format("This is the put and the object is %s", license);
  }

  public String deleteLicense(String licenseId, String organizationId) {
    return String.format("Deleting license with id %s for the organization %s", licenseId, organizationId);
  }

}
