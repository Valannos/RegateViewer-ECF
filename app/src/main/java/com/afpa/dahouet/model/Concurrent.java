/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

/**
 *
 * @author Valannos
 */
public class Concurrent extends Personne {
    
 private int numLicence;
 private int anneLicence;
 private int id;

    public Concurrent(int numLicence, int anneLicence, String name, String firstname, int anneeNaissance) {
        super(name, firstname, anneeNaissance);
        this.numLicence = numLicence;
        this.anneLicence = anneLicence;
    }

    public int getNumLicence() {
        return numLicence;
    }

    public void setNumLicence(int numLicence) {
        this.numLicence = numLicence;
    }

    public int getAnneLicence() {
        return anneLicence;
    }

    public void setAnneLicence(int anneLicence) {
        this.anneLicence = anneLicence;
    }

 

    public Concurrent(int numLicence, int anneLicence, int id, String name, String firstname, int anneeNaissance) {
        super(name, firstname, anneeNaissance);
        this.numLicence = numLicence;
        this.anneLicence = anneLicence;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
 
 
    
    
    
}
