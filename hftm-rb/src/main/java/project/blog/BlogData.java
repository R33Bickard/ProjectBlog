package project.blog;

import project.blog.entity.Blog;
import project.blog.repository.BlogRepository;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BlogData {

    @Inject
    BlogRepository blogRepository;

@Transactional
public void init(@Observes StartupEvent event) {
    if (blogRepository.listAll().isEmpty()) {
        Blog newBlog = new Blog("Hello", "This is the first blog post");
        blogRepository.persist(newBlog);
    }
}
}