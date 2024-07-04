package project.blog.repository;

import project.blog.entity.BlogComment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BlogCommentRepository implements PanacheRepository<BlogComment> {
}
