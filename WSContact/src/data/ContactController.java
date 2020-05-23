package data;

import java.util.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/contact")
public class ContactController {
  private ContactRepo contactRepo = ContactRepo.getInstance();

  @GET @Path("/") @Produces(MediaType.APPLICATION_JSON)
  public List<Contact> getAllContacts() {
    return contactRepo.getAllContacts();
  }

  @GET @Path("/{id}") @Produces(MediaType.APPLICATION_JSON)
  public Contact getContactById(@PathParam("id") int id) {
    return contactRepo.getContactById(id);
  }

  @POST @Path("/") @Produces(MediaType.APPLICATION_JSON)
  public Contact addContact(Contact contact) {
    return contactRepo.addContact(contact);
  }

  @DELETE @Path("/{id}") @Produces(MediaType.APPLICATION_JSON)
  public Contact deleteContact(@PathParam("id") int id) {
    return contactRepo.deleteContact(id);
  }
}
