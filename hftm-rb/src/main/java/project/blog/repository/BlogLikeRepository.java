package project.blog.repository;

import project.blog.entity.BlogLike;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BlogLikeRepository implements PanacheRepository<BlogLike> {
}
