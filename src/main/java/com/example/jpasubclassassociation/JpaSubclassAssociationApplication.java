package com.example.jpasubclassassociation;

import com.example.jpasubclassassociation.blog.Blog;
import com.example.jpasubclassassociation.blog.BlogRepository;
import com.example.jpasubclassassociation.blog.User;
import com.example.jpasubclassassociation.blog.UserRepository;
import com.example.jpasubclassassociation.plan.ComputePlan;
import com.example.jpasubclassassociation.plan.Plan;
import com.example.jpasubclassassociation.plan.PlanRepository;
import com.example.jpasubclassassociation.plan.Resource;
import com.example.jpasubclassassociation.plan.ResourceRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JpaSubclassAssociationApplication {

  public static void main(String[] args) {
    SpringApplication.run(JpaSubclassAssociationApplication.class, args);
  }

  @Bean
  CommandLineRunner initPlans(
      ResourceRepository resourceRepository, PlanRepository planRepository) {
    return (args) -> {
      Resource resource1 = new Resource("resource1");
      Resource resource2 = new Resource("resource2");
      resourceRepository.save(resource1);
      resourceRepository.save(resource2);

      Plan plan1 = new ComputePlan("computer", resource1);
      planRepository.save(plan1);
      for (int i = 0; i < 100; i++) {
        Plan plan2 = new ComputePlan("computer" + i, resource2);
        planRepository.save(plan2);
      }
    };
  }

  @Bean
  CommandLineRunner initUsers(UserRepository userRepository, BlogRepository blogRepository) {
    return (args) -> {
      User user = new User("aisensiy");
      userRepository.save(user);
      Blog blog = new Blog("blog1", "content", user);
      blogRepository.save(blog);
    };
  }
}

@RestController
@AllArgsConstructor
class Api {
  private PlanRepository planRepository;
  private BlogRepository blogRepository;

  @GetMapping("/plans")
  public List<Plan> plans() {
    return planRepository.findAll();
  }

  @GetMapping("/computs")
  public List<ComputePlan> computePlans() {
    return planRepository.findAllComputePlans();
  }

  @GetMapping("/blogs")
  public List<Blog> blogs() {
    return blogRepository.findAll();
  }
}