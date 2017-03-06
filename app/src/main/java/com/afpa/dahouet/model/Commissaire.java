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
public class Commissaire extends Personne {
    
    private String nameComite;

    public Commissaire(String nameComite, String name, String firstname, String email, int anneeNaissance) {
        super(name, firstname, email, anneeNaissance);
        this.nameComite = nameComite;
    }

    public Commissaire(String nameComite, String name, String firstname, int anneeNaissance) {
        super(name, firstname, anneeNaissance);
        this.nameComite = nameComite;
    }
    

    public String getNameComite() {
        return nameComite;
    }

    public void setNameComite(String nameComite) {
        this.nameComite = nameComite;
    }
    
    

    @Override
    public String toString() {
        return "Commissaire{" + "nameComite=" + nameComite + ", " +  super.toString();
    }
    



  
    
    
}
