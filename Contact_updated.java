package data;

import java.sql.*;
import java.util.*;

public class Contact {
	int idcontact;
	String nom;
	String prenom;
	
	Connection con = null;
	
	public int getIdcontact() {
		return idcontact;
	}
	public void setIdcontact(int idcontact) {
		this.idcontact = idcontact;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Contact() {
		super();
	}
	public Contact(int idcontact, String nom, String prenom) {
		super();
		this.idcontact = idcontact;
		this.nom = nom;
		this.prenom = prenom;
		
		
		String url = "jdbc:mysql://localhost:3306/restdb";
		String username = "mouna";
		String password = "mouna";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Contact> getContacts(){
		List<Contact> Contacts = new ArrayList<>();
		String sql = "select * from restbd";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Contact a = new Contact();
				a.setIdcontact(rs.getInt(1));
				a.setNom(rs.getString(2));
				a.setPrenom(rs.getString(3));
				
				Contacts.add(a);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return Contacts;
	}
	public Contact getContact(){
		List<Contact> Contacts = new ArrayList<>();
		String sql = "select * from restbd";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				Contact a = new Contact();
				a.setIdcontact(rs.getInt(1));
				a.setNom(rs.getString(2));
				a.setPrenom(rs.getString(3));
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return a;
	}
	public String toString() {
		return "Contact [idcontact=" + idcontact + ", Nom=" + nom + ", Prenom=" + prenom +"]";
	}
	
}
