package com.example.jpasubclassassociation.plan;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("STORAGE_PLAN")
@NoArgsConstructor
public class StoragePlan extends Plan {
  private int size;

  public StoragePlan(String name) {
    super(name);
  }
}
