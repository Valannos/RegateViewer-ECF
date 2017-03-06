/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

import java.sql.Time;

/**
 *
 * @author Valannos
 */
public class Participation {

    private int id;
    private Time tpsReg;
    private Time tpsReel;
    private int scrReg;
    private Regate regate;
    private Voilier voilier;
    private Concurrent skipper;
    private CodeResultat codeResultat;
    private int rank;

    public Participation(int id, Regate regate, Voilier voilier, Concurrent skipper) {
        this.id = id;
        this.regate = regate;
        this.voilier = voilier;
        this.skipper = skipper;


    }

    public Participation(int id, Time tpsReg, Time tpsReel, int scrReg, int rank, Regate regate, Voilier voilier, Concurrent skipper, CodeResultat codeResultat) {
        this.id = id;
        this.tpsReg = tpsReg;
        this.scrReg = scrReg;
        this.regate = regate;
        this.voilier = voilier;
        this.skipper = skipper;
        this.codeResultat = codeResultat;
        this.tpsReel = tpsReel;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTpsReg() {
        return tpsReg;
    }

    public void setTpsReg(Time tpsReg) {
        this.tpsReg = tpsReg;
    }

    public Time getTpsReel() {
        return tpsReel;
    }

    public void setTpsReel(Time tpsReel) {
        this.tpsReel = tpsReel;
    }

    public int getScrReg() {
        return scrReg;
    }

    public void setScrReg(int scrReg) {
        this.scrReg = scrReg;
    }

    public Regate getRegate() {
        return regate;
    }

    public void setRegate(Regate regate) {
        this.regate = regate;
    }

    public Voilier getVoilier() {
        return voilier;
    }

    public void setVoilier(Voilier voilier) {
        this.voilier = voilier;
    }

    public Concurrent getSkipper() {
        return skipper;
    }

    public void setSkipper(Concurrent skipper) {
        this.skipper = skipper;
    }

    public CodeResultat getCodeResultat() {
        return codeResultat;
    }

    public void setCodeResultat(CodeResultat codeResultat) {
        this.codeResultat = codeResultat;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }












}
