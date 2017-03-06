/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

/**
 *
 * @author Afpa
 */
public class Proprietaire extends Personne {

    private ClubNautique clubNautique;
    private int id;
    private int id_Pro;

    public int getId_Pro() {
        return id_Pro;
    }

    public void setId_Pro(int id_Pro) {
        this.id_Pro = id_Pro;
    }
    
    public Proprietaire(String name, String firstname, String email, int anneeNaissance) {
        super(name, firstname, email, anneeNaissance);
    }

    public Proprietaire(String name, String firstname, int anneeNaissance) {
        super(name, firstname, anneeNaissance);
    }

    public Proprietaire(ClubNautique clubNautique, String name, String firstname, String email, int anneeNaissance) {
        super(name, firstname, email, anneeNaissance);
        this.clubNautique = clubNautique;
    }

    public Proprietaire(ClubNautique clubNautique, String name, String firstname, int anneeNaissance) {
        super(name, firstname, anneeNaissance);
        this.clubNautique = clubNautique;
    }

    public Proprietaire(ClubNautique clubNautique, int id, int id_Pro, String name, String firstname, int anneeNaissance) {
        super(name, firstname, anneeNaissance);
        this.clubNautique = clubNautique;
        this.id = id;
        this.id_Pro = id_Pro;
    }


    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
    

    public ClubNautique getClubNautique() {
        return clubNautique;
    }

    public void setClubNautique(ClubNautique clubNautique) {
        this.clubNautique = clubNautique;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Proprietaire{"   + super.toString();
    }

}
