import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/2")
public class SecondPage {
    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello My Company From Second Page";
    }
}