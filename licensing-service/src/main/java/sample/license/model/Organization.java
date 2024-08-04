package sample.license.model;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
public class Organization extends RepresentationModel<Organization> {

  String id;
  String name;
  String contactName;
  String contactEmail;
  String contactPhone;

}