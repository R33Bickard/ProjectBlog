package project.blog.control;

import java.util.List;

import io.quarkus.logging.Log;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import project.blog.entity.Blog;
import project.blog.repository.BlogRepository;

@Dependent
public class BlogService {
    @Inject
    BlogRepository blogRepository;

    public List<Blog> getBlogs() {
        var blogs = blogRepository.getBlogs();
        Log.info("Returning " + blogs.size() + " blogs");
        return blogs;
    }

    public void addBlog(Blog blog) {
        Log.info("Adding blog " + blog.getTitle());
        blogRepository.addBlog(blog);
    }
}