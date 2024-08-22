package project.blog;


import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import project.blog.control.BlogService;
import project.blog.entity.Blog;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.keycloak.client.KeycloakTestClient;
import jakarta.inject.Inject;

@QuarkusTest
public class KeyCloakTest {
    
    @Inject
    BlogService blogService;

     KeycloakTestClient keycloakClient = new KeycloakTestClient();


     @Test
     public void getBlogsNoAuth() {
         given()
             .when().get("/blogs")
             .then()
                 .statusCode(200);
     }


     @Test
     public void getBlogsWithAuth() {
         given()
             .auth().oauth2(keycloakClient.getAccessToken("peter"))
             .when().get("/blogs")
             .then()
                 .statusCode(200);
     }



     @Test
     public void deleteBlogWithAdminRole() {
         Blog blog = new Blog();
         blog.setTitle("Blog to be deleted by admin");
         blog.setContent("This blog post will be deleted by admin.");
 
         blogService.addBlog(blog);
 
         given()
             .auth().oauth2(keycloakClient.getAccessToken("rich"))
             .when().delete("/blogs/" + blog.getTitle())
             .then()
                 .statusCode(204);
     }


     
    @Test
    public void deleteBlogWithoutAdminRole() {
        Blog blog = new Blog();
        blog.setTitle("Blog to be deleted by user");
        blog.setContent("This blog post should not be deleted.");

        blogService.addBlog(blog);

        given()
            .auth().oauth2(keycloakClient.getAccessToken("peter"))
            .when().delete("/blogs/" + blog.getTitle())
            .then()
                .statusCode(403);
    }
    
}
