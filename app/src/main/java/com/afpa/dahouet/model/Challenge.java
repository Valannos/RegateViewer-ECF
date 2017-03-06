/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

import java.sql.Date;

/**
 *
 * @author Valannos
 */
public class Challenge {
    
    private String id;
    private Date startingDate;
    private Date endingDate;

    public Challenge(String id, Date startingDate, Date endingDate) {
        this.id = id;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }
    
    
    
}
