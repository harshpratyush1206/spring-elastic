package org.oaknorth.springelastic.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@EqualsAndHashCode
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {

  @CreatedBy
  @JsonIgnore
  @Column(name = "created_by", updatable = false)
  private String createdBy;

  @CreatedDate
  @JsonIgnore
  @Column(name = "created_on", updatable = false)
  private LocalDateTime createdOn;

  @LastModifiedBy
  @JsonIgnore
  @Column(name = "last_modified_by")
  private String lastModifiedBy;

  @LastModifiedDate
  @JsonIgnore
  @Column(name = "last_modified_on")
  private LocalDateTime lastModifiedOn;
}
