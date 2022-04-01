package com.example.jpasubclassassociation.plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PlanRepository extends JpaRepository<Plan, Long> {
  @Query("select p from ComputePlan p")
  List<ComputePlan> findAllComputePlans();
}
