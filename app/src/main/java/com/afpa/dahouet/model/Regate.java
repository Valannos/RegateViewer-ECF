/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

import java.sql.Date;
import java.util.List;


/**
 *
 * @author Valannos
 */
public class Regate {
    
    private String id;
    private Date date;
    private double distance;
    private Challenge challenge;
    private List<com.afpa.dahouet.model.Commissaire> commissaires;


    public Regate(String id, Date date, double distance, Challenge challenge) {
        this.id = id;
        this.date = date;
        this.distance = distance;
        this.challenge = challenge;
    }

    public Regate(String id, Date date, double distance, Challenge challenge, List<Commissaire> commissaires) {
        this.id = id;
        this.date = date;
        this.distance = distance;
        this.challenge = challenge;
        this.commissaires = commissaires;
    }

    public List<Commissaire> getCommissaires() {
        return commissaires;
    }

    public void setCommissaires(List<Commissaire> commissaires) {
        this.commissaires = commissaires;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }


    
    
    
    
    
}
