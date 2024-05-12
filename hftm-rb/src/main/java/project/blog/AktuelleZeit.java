package project.blog;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Path("/Zeit")
public class AktuelleZeit {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String aktuelleZeit(){
        LocalDateTime aktuell = LocalDateTime.now();

        DateTimeFormatter de = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Willkommen auf meinem Blog: \n" + aktuell.format(de);
        
}
   
}
