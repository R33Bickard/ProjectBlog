package project.ini;
import project.blog.entity.Blog;
import project.blog.repository.BlogRepository;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataIni {
   
  @Inject
  BlogRepository blogRepository;

    @Transactional
    public void init(@Observes StartupEvent event) {
            if (blogRepository.count() == 0) {
              Blog blog1 = new Blog("Titel", "Content");
              Blog blog2 = new Blog("Titel 2", "Content2");
              blogRepository.persist(blog1);
              blogRepository.persist(blog2);
    }
  }
}