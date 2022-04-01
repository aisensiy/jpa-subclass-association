package com.example.jpasubclassassociation.plan;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Getter
@NoArgsConstructor
@Inheritance
@DiscriminatorColumn(name = "plan_type")
public abstract class Plan {
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  private Long id;

  private String name;

  public Plan(String name) {
    this.name = name;
  }
}
