package com.example.clientws;

public class Contact {
    int idcontact;
    String nom;
    String prenom;

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
    }

    public String toString() {
        return "Contact [idcontact=" + idcontact + ", Nom=" + nom + ", Prenom=" + prenom +"]";
    }

}

