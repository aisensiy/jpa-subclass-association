package com.example.jpasubclassassociation.plan;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@DiscriminatorValue("COMPUTE_PLAN")
@NoArgsConstructor
public class ComputePlan extends Plan {
  @ManyToOne(fetch = FetchType.EAGER)
  private Resource resource;
  public ComputePlan(String name, Resource resource) {
    super(name);
    this.resource = resource;
  }
}
