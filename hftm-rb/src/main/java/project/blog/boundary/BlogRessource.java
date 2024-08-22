package project.blog.boundary;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

import project.blog.control.BlogService;
import project.blog.entity.Blog;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/blogs")
public class BlogRessource {

  @Inject
  BlogService blogService;

  @GET
  @PermitAll
  @Operation(summary = "Auflistung aller Blog-Einträge")
  public List<Blog> getBlogs() {
    return blogService.getBlogs();
  }

  @POST
  @RolesAllowed({"user", "admin"})
  @Operation(summary = "Erstellen eines Blog-Eintrags")
  public Response addBlog(Blog blog) {
    blogService.addBlog(blog);
    return Response.status(Status.CREATED).entity("Blog erfolgreich erstellt").build();
  }
  
  @PUT
  @RolesAllowed({"user", "admin"})
  @Operation(summary = "Vollständige Aktualisierung eines Blog-Eintrags")
  @Path("{id}")
  public Response updateBlog(@PathParam("id") Long id, Blog updatedBlog) {
    try {
      blogService.updateBlog(id, updatedBlog);
      return Response.ok("Blog erfolgreich aktualisiert").build();
    } catch (WebApplicationException e) {
      return Response.status(e.getResponse().getStatus()).entity(e.getMessage()).build();
    }
  }
  
  @PATCH
  @RolesAllowed({"user", "admin"})
  @Operation(summary = "Teilweise Aktualisierung eines Blog-Eintrags")
  @Path("{id}")
  public Response updateBlogPartial(@PathParam("id") Long id, Blog update) {
    try {
      blogService.partialUpdateBlog(id, update);
      return Response.ok("Blog erfolgreich teilweise aktualisiert").build();
    } catch (WebApplicationException e) {
      return Response.status(e.getResponse().getStatus()).entity(e.getMessage()).build();
    }
  }

  @DELETE
  @RolesAllowed("admin")
  @Operation(summary = "Löschen eines Blog-Eintrags")
  @Path("{title}")
  public Response deleteBlog(@PathParam("title") String title) {
    try {
      blogService.deleteBlog(title);
      return Response.noContent().build();
    } catch (WebApplicationException e) {
      return Response.status(e.getResponse().getStatus()).entity(e.getMessage()).build();
    }
  }
}
