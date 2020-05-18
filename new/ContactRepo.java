import java.sql.*;
import java.util.*;

public class ContactRepo {
  private static ContactRepo instance;
  private DBConnection connection;

  private ContactRepo() {
    this.connection = DBConnection.getInstance();
  }

  public static ContactRepo getInstance() {
    if (instance == null) {
      instance = new ContactRepo();
    }
    return instance;
  }

  public List<Contact> getAllContacts() {
    List<Contact> contacts = new ArrayList<>();
    String sql = "SELECT * FROM restbd";
    try {
      Statement st = connection.getConnection().createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        Contact contact = new Contact();
        contact.setId(rs.getInt(1));
        contact.setNom(rs.getString(2));
        contact.setPrenom(rs.getString(3));
        contacts.add(contact);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return contacts;
  }

  public Contact getContactById(int id) {
    Contact contact = null;
    String sql = "SELECT * FROM restbd WHERE id=?";
    try {
      PreparedStatement st = connection.getConnection().prepareStatement(sql);
      st.setInt(1, id);
      ResultSet rs = st.executeQuery();
      if (rs.next()) {
        contact = new Contact();
        contact.setId(rs.getInt(1));
        contact.setNom(rs.getString(2));
        contact.setPrenom(rs.getString(3));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return contact;
  }

  public Contact addContact(Contact contact) {
    // TODO:
    return null;
  }

  public Contact deleteContact(int id) {
    // TODO:
    return null;
  }
}