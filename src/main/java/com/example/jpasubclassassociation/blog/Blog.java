package com.example.jpasubclassassociation.blog;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
public class Blog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  private User author;

  public Blog(String title, String content, User author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }
}
