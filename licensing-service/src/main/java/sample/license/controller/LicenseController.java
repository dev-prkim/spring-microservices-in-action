package sample.license.controller;

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
  public ResponseEntity<License> getLicense(@PathVariable String organizationId, @PathVariable String licenseId) {
    License license = licenseService.getLicense(licenseId, organizationId);
    return ResponseEntity.ok(license);
  }

  @PutMapping
  public ResponseEntity<String> updateLicense(
      @PathVariable String organizationId,
      @RequestBody License license,
      @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
    return ResponseEntity.ok(licenseService.updateLicense(license, organizationId, locale));
  }

  @PostMapping
  public ResponseEntity<String> createLicense(
      @PathVariable String organizationId,
      @RequestBody License license,
      @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
    return ResponseEntity.ok(licenseService.createLicense(license, organizationId, locale));
  }

  @DeleteMapping(value = "/{licenseId}")
  public ResponseEntity<String> deleteLicense(
      @PathVariable String organizationId,
      @PathVariable String licenseId) {
    return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));
  }
}
