package project.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Blog {

  @Id @GeneratedValue
  private Long id;
  
  private String title;
  private String content;
}


