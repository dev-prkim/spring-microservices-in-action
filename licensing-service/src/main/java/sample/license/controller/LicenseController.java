package sample.license.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.license.model.License;
import sample.license.service.LicenseService;

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/license")
@RequiredArgsConstructor
public class LicenseController {

  private final LicenseService licenseService;

  @GetMapping(value = "/{licenseId}")
  public ResponseEntity<License> getLicense(@PathVariable String organizationId,
      @PathVariable String licenseId) {

    License license = licenseService.getLicense(licenseId, organizationId);

    license.add(linkTo(methodOn(LicenseController.class)
            .getLicense(organizationId, licenseId)).withSelfRel(),
        linkTo(methodOn(LicenseController.class).createLicense(organizationId, license)).withRel("createLicense"),
        linkTo(methodOn(LicenseController.class).updateLicense(license)).withRel("updateLicense"),
        linkTo(methodOn(LicenseController.class).deleteLicense(licenseId)).withRel("deleteLicense"));

    return ResponseEntity.ok(license);
  }

  @PostMapping
  public ResponseEntity<License> createLicense(
      @PathVariable String organizationId,
      @RequestBody License license) {
    return ResponseEntity.ok(licenseService.createLicense(license, organizationId));
  }

  @PutMapping
  public ResponseEntity<License> updateLicense(
      @RequestBody License license) {
    return ResponseEntity.ok(licenseService.updateLicense(license));
  }

  @DeleteMapping(value = "/{licenseId}")
  public ResponseEntity<String> deleteLicense(
      @PathVariable String licenseId) {
    return ResponseEntity.ok(licenseService.deleteLicense(licenseId));
  }
}
