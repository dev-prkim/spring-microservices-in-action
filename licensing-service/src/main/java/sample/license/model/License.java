package sample.license.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@Getter
@ToString
public class License extends RepresentationModel<License> {

  private int id;
  private String licenseId;
  private String description;
  @Setter private String organizationId;
  private String productName;
  private String licenseType;

  @Builder
  private License(int id, String licenseId, String description, String organizationId,
      String productName, String licenseType) {
    this.id = id;
    this.licenseId = licenseId;
    this.description = description;
    this.organizationId = organizationId;
    this.productName = productName;
    this.licenseType = licenseType;
  }

}
