package sample.organization.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.organization.model.Organization;
import sample.organization.service.OrganizationService;

@RestController
@RequestMapping(value="/v1/organization")
@RequiredArgsConstructor
public class OrganizationController {

  private final OrganizationService service;

  @GetMapping(value="/{organizationId}")
  public ResponseEntity<Organization> getOrganization( @PathVariable("organizationId") String organizationId) {
    return ResponseEntity.ok(service.findById(organizationId));
  }

}
