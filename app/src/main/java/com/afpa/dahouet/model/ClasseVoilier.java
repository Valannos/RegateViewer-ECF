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


public class ClasseVoilier {
    
    private int id;
    private String name;
    private char type;
    private double coef;

    public ClasseVoilier(int id, String name, char type, double coef) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.coef = coef;
    }

    public ClasseVoilier(String name, char type, double coef) {
        this.name = name;
        this.type = type;
        this.coef = coef;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }
    
    
    
    
}
