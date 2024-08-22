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
      Blog blog1 = new Blog("Exploring the Future of AI", 
                            "Artificial Intelligence (AI) continues to evolve, bringing new possibilities and challenges. In this post, we explore the potential future developments in AI technology.");
      Blog blog2 = new Blog("Sustainable Living: Tips for a Greener Life", 
                            "Sustainability is becoming increasingly important in our daily lives. This blog offers practical tips on how to live a more eco-friendly and sustainable lifestyle.");
      blogRepository.persist(blog1);
      blogRepository.persist(blog2);
    }
  }
}