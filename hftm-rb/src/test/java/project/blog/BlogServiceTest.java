package project.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import project.blog.control.BlogService;
import project.blog.entity.Blog;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class BlogServiceTest {

    @Inject
    BlogService blogService;

    @Test
    void listingAndAddingBlogs() {
        // Arrange
        Blog blog = new Blog("Test Blog", "This is a test blog.");
        int blogsBefore = blogService.getBlogs().size();

        // Act
        blogService.addBlog(blog);
        List<Blog> blogsAfter = blogService.getBlogs();

        // Assert
        assertEquals(blogsBefore + 1, blogsAfter.size(), "Die Anzahl der Blogs sollte sich um 1 erhöhen.");
        assertEquals(blog.getTitle(), blogsAfter.get(blogsAfter.size() - 1).getTitle(), "Der letzte hinzugefügte Blog sollte den gleichen Titel haben.");
        assertEquals(blog.getContent(), blogsAfter.get(blogsAfter.size() - 1).getContent(), "Der letzte hinzugefügte Blog sollte den gleichen Inhalt haben.");
    }
}
