package project.blog.control;
import java.util.List;

import project.blog.entity.Blog;
import project.blog.repository.BlogRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

@Dependent
public class BlogService {

    @Inject
    BlogRepository blogRepository;

    public List<Blog> getBlogs() {
        var blogs = blogRepository.listAll();
        Log.info("Returning " + blogs.size() + " blogs");
        return blogs;
    }

    @Transactional
    public void addBlog(Blog blog) {
        Log.info("Adding blog " + blog.getTitle());
        blogRepository.persist(blog);
    }

    @Transactional
    public void updateBlog(Long id, Blog updatedBlog){
        Blog existingBlog = blogRepository.findById(id);
        existingBlog.setTitle(updatedBlog.getTitle());
        existingBlog.setContent(updatedBlog.getContent());
        blogRepository.persist(existingBlog);
        }

    @Transactional
    public void partialUpdateBlog(Long id, Blog partialUpdatedBlog){
        Blog existingBlog = blogRepository.findById(id);
        if(partialUpdatedBlog.getTitle() != null){
            existingBlog.setTitle(partialUpdatedBlog.getTitle());
        }        
        if(partialUpdatedBlog.getContent() != null){
            existingBlog.setContent(partialUpdatedBlog.getContent());
        }
        blogRepository.persist(existingBlog);
    }

    @Transactional
    public void deleteBlog(String title) {
        Blog blogToDelete = blogRepository.find("title", title).firstResult();
        if(blogToDelete != null){
            Log.info("Deleting blog " + blogToDelete.getTitle());
            blogRepository.delete(blogToDelete);
        }else{
            Log.info("Blog not found");
            throw new WebApplicationException("Blog with title not found.", 404);
            }
        }
}