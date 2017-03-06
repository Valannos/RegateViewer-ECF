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
public class ClubNautique {
    
    private int id;
    private String nomClub;

    public ClubNautique(int id, String nomClub) {
        this.id = id;
        this.nomClub = nomClub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }
    
    
    
}
