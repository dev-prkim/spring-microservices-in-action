package sample.license.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "licenses", indexes = {
    @Index(name = "idx_license_license_id", columnList = "license_id", unique = true)
})
public class License extends RepresentationModel<License> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;
  @Column(name = "license_id", nullable = false)
  @Setter private String licenseId;
  private String description;
  @Column(name = "organization_id", nullable = false)
  private String organizationId;
  @Column(name = "product_name", nullable = false)
  private String productName;
  @Column(name = "license_type", nullable = false)
  private String licenseType;
  private String comment;

  @Transient
  private String organizationName;
  @Transient
  private String contactName;
  @Transient
  private String contactPhone;
  @Transient
  private String contactEmail;


  public License withComment(String comment) {
    this.comment = comment;
    return this;
  }

  public void setOrganizationInfo(String organizationName, String contactName, String contactPhone, String contactEmail) {
    this.organizationName = organizationName;
    this.contactName = contactName;
    this.contactPhone = contactPhone;
    this.contactEmail = contactEmail;
  }

}
