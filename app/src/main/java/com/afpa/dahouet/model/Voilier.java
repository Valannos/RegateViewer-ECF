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
public class Voilier {
    
    private Proprietaire pro;
    private ClasseVoilier cv;
    private String nom;
    private int id;

    public Voilier(Proprietaire pro, ClasseVoilier classe, String nom) {
        this.pro = pro;
        this.cv = classe;
        this.nom = nom;
    }

    public Voilier(Proprietaire pro, ClasseVoilier cv, String nom, int id) {
        this.pro = pro;
        this.cv = cv;
        this.nom = nom;
        this.id = id;
    }
    

    public Proprietaire getPro() {
        return pro;
    }

    public void setPro(Proprietaire pro) {
        this.pro = pro;
    }

    public ClasseVoilier getClasse() {
        return cv;
    }

    public void setClasse(ClasseVoilier classe) {
        this.cv = classe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    
    
    
    
    
    
}
